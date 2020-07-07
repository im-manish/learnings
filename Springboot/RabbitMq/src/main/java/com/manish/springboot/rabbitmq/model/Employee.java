/**
Copyright (c) 2020 This Program is sole property of Manish Kumar written on 06-Jul-2020
 * 
 */
package com.manish.springboot.rabbitmq.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Manish
 *
 */
@Builder
@ToString
@Getter
@Setter
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer employeeId;
	private String name;
	private String address;
	private List<Department> depatments;

}
