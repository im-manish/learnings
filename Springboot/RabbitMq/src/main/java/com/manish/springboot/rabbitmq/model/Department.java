/**
Copyright (c) 2020 This Program is sole property of Manish Kumar written on 06-Jul-2020
 * 
 */
package com.manish.springboot.rabbitmq.model;

import java.io.Serializable;

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
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer departmentId;
	private String departmentName;

}
