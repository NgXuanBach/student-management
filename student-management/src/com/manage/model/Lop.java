package com.manage.model;

import java.util.LinkedList;
import java.util.Scanner;

public class Lop {
	private int id;
	private String name;
	private LinkedList<Student> studentList;
	private int quantity = 0;

	public Lop() {
	}

	public Lop(int id, String name, int quantity, LinkedList<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.studentList = studentList;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LinkedList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Student student) {
		this.studentList.add(student);
		this.quantity++;
	}

	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Id class: ");
		id = scan.nextInt();
		System.out.println("name class: ");
		name = scan.next();
	}

	public void showStudent() {
		boolean test = false;
		for (Student student : studentList) {
			test = true;
			System.out.println("Id student: " + student.getId());
			System.out.println("name student: " + student.getName());
			System.out.println("age student: " + student.getAge());
			System.out.println("address student: " + student.getAddress());
			System.out.println(" gpa student: " + student.getGpa());
			System.out.println("/****************************************/");
		}
		if (test == false) {
			System.out.println("class nay chua co student nao.");
		}
	}
}
