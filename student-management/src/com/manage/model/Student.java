package com.manage.model;

import java.util.Scanner;

public class Student {
	private int id;
	private String name;
	private int age;
	private String address;
	private float gpa;
	private String clas;

	public Student() {
	}

	public Student(int id, String name, int age, String address, float gpa, String clas) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
		this.clas = clas;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public void add() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Id student: ");
		id = scan.nextInt();
		System.out.println("class student: ");
		scan.next();
		clas = scan.nextLine();
		System.out.println("name student: ");
		scan.next();
		name = scan.nextLine();
		System.out.println("age student: ");
		age = scan.nextInt();
		System.out.println("address student: ");
		scan.next();
		address = scan.next();
		System.out.println(" gpa student: ");
		gpa = scan.nextFloat();
	}
}
