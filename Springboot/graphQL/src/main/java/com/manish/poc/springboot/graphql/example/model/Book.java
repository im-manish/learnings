package com.manish.poc.springboot.graphql.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table()
@Entity
@ToString
public class Book {
	@Id
	private String isn;
	
	private String title;
	private String publisher;
	private String[] authors;
	private String publishedDate;
}
