package com.manish.poc.springboot.graphql.example.services.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manish.poc.springboot.graphql.example.model.Book;
import com.manish.poc.springboot.graphql.example.respository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book> {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book get(DataFetchingEnvironment environment) throws Exception {
		String isn = environment.getArgument("id");
		return bookRepository.getOne(isn);
	}

}
