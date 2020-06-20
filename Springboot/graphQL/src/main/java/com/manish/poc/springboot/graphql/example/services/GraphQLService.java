package com.manish.poc.springboot.graphql.example.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.manish.poc.springboot.graphql.example.model.Book;
import com.manish.poc.springboot.graphql.example.respository.BookRepository;
import com.manish.poc.springboot.graphql.example.services.datafetcher.AllBookDataFetcher;
import com.manish.poc.springboot.graphql.example.services.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	
	@Value("classpath:books.graphql")
	Resource resource;
	@Autowired
	private AllBookDataFetcher allBooksDataFetcher;
	@Autowired
	private BookDataFetcher bookDataFetcher;
	@Autowired
	BookRepository bookRepository;

	private GraphQL graphQL;

	// load schema at application start up
	@PostConstruct
	private void loadSchema() throws IOException {
		loadDataToPostgresDB();
		File file = resource.getFile();
		// Parse the Schema
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	private void loadDataToPostgresDB() {
		List<Book> collect = Stream.of(new Book("1","Book 1","Book 1 Publisher",new String[] {"Manish"},"Nov 12 2012"),
				new Book("2","Book 2","Book 2 Publisher",new String[] {"Manish"},"Nov 13 2013"),
				new Book("3","Book 3","Book 3 Publisher",new String[] {"Manish"},"Nov 14 2014"),
				new Book("4","Book 4","Book 4 Publisher",new String[] {"Manish"},"Nov 15 2015")
				).collect(Collectors.toList());
		collect.forEach(bookRepository::save);
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("allBooks", allBooksDataFetcher).dataFetcher("book", bookDataFetcher)).build();
	}
	
	public GraphQL getGraphQL() {
		return graphQL;
	}

}
