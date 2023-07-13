package com.springmvc.entity;

public class Employee {

	private int id;
	private String name;
	private int sal;

	public Employee() {
		System.out.println("Creating Employee object");
	}

	public Employee(int id, String name, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSal() {
		return sal;
	}

}
