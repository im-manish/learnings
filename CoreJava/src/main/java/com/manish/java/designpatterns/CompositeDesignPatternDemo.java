package com.manish.java.designpatterns;

import java.util.ArrayList;

/**
 * @author Manish
 *
 */

interface Employee {
	public void getSalary();
	public void getEmployeeDetails();
}

class Manager implements Employee {
	
	private String name;
	private String age;
	
	

	public Manager(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public void getSalary() {
		System.out.println("Salary of manager -> 1000");
		
	}

	@Override
	public void getEmployeeDetails() {
		System.out.println("Employee name ->"+name+ " Age - >"+age + "  Salary -> 100");
		
	}
	
}

class Devloper implements Employee {
	
	private String name;
	private String age;
	
	

	public Devloper(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public void getSalary() {
		System.out.println("Salary of manager -> 1000");
		
	}

	@Override
	public void getEmployeeDetails() {
		System.out.println("Employee name ->"+name+ " Age - >"+age + "  Salary -> 100");
		
	}
	
}


class CompanyEmployee implements Employee {
	
	java.util.List<Employee> employeeList = new ArrayList<>();
	
/*
	public CompanyEmployee(java.util.List<Employee> employeeList) {
		super();
		this.employeeList = employeeList;
	}
*/
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		employeeList.remove(employee);
	}
	@Override
	public void getSalary() {
		employeeList.forEach(item->item.getSalary());
	}

	@Override
	public void getEmployeeDetails() {
		employeeList.forEach(item -> item.getEmployeeDetails());
	}
	
}


public class CompositeDesignPatternDemo {
	
	public static void main(String[] args) {
		Manager manager = new Manager("manish", "20");
		Devloper devloper = new Devloper("Manish", "15");
		CompanyEmployee companyEmployee = new CompanyEmployee();
		companyEmployee.addEmployee(manager);
		companyEmployee.addEmployee(devloper);
		manager.getEmployeeDetails();
		devloper.getEmployeeDetails();
		companyEmployee.getEmployeeDetails();
	}
	

}
