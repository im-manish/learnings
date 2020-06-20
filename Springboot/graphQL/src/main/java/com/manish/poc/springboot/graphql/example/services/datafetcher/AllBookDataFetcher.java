package com.manish.poc.springboot.graphql.example.services.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manish.poc.springboot.graphql.example.model.Book;
import com.manish.poc.springboot.graphql.example.respository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBookDataFetcher implements DataFetcher<List<Book>> {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) throws Exception {
		return bookRepository.findAll();
	}

}
