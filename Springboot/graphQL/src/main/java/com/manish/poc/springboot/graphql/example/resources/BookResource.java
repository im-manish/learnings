package com.manish.poc.springboot.graphql.example.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.poc.springboot.graphql.example.services.GraphQLService;

import graphql.ExecutionResult;

/**
 * @author hp
 *
 */
@RequestMapping("/rest/books")
@RestController
public class BookResource {
	
	@Autowired
	GraphQLService graphQlService;
	
	@PostMapping
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult execute = graphQlService.getGraphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
