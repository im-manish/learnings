package com.manish.poc.springboot.graphql.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.poc.springboot.graphql.example.model.Book;

/**
 * @author hp
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String>{

}
