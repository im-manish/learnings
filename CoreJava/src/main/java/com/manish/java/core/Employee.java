package com.manish.java.core;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Manish
 *
 */
class Employee  {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

   
    @Override
    //this is required to print the user friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }
/*
	public int compareTo(Employee emp) {
		return (this.id - emp.id);
	}*/
	
	public static void main(String[] args) {
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Manish", 25, 10000);
		empArr[1] = new Employee(10, "Mikey", 25, 10000);
		empArr[2] = new Employee(20, "Arun", 29, 20000);
		empArr[3] = new Employee(5, "Lisa", 35, 5000);

		//sorting employees array using Comparable interface implementation
		Arrays.sort(empArr,nameComparator);
		System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));
	}
	
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		public int compare(Employee emp1, Employee emp2) {
			return emp1.name.compareTo(emp2.getName());
		}
	};

}


class EmployeeComparatorByIdAndName implements Comparator<Employee> {

    public int compare(Employee o1, Employee o2) {
        int flag = o1.getId() - o2.getId();
        if(flag==0) flag = o1.getName().compareTo(o2.getName());
        return flag;
    }
}

/*public class ComparableAndComparatorTest {

	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(10);
		integerList.add(1);integerList.add(16);integerList.add(2);
		System.out.println(integerList);
		Collections.sort(integerList);
		System.out.println(integerList);
		
	}
}
*/