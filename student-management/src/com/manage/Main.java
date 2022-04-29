package com.manage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;

import com.manage.model.Lop;
import com.manage.model.Student;

public class Main {
	private static LinkedList<Student> studentList;
	private static Scanner scanner;
	private static List<Lop> classList;

	public static void main(String[] args) {
		studentList = new LinkedList<>();
		classList = new ArrayList<>();
		scanner = new Scanner(System.in);
		int number;
		do {
			showMenu();
			number = scanner.nextInt();
			switch (number) {
			case 0:
				System.out.println("Ket thuc");
				break;
			case 1:
				try {
					addClass();
				} catch (Exception e) {
					System.out.println("nhap sai vui long nhap lai.");
				}
				break;
			case 2:
				try {
					editClassById();
				} catch (Exception e) {
					System.out.println("nhap sai vui long nhap lai ");
				}
				break;
			case 3:
				deleteClassById();
				break;
			case 4:
				sortClassByName();
				break;
			case 5:
				try {
					addStudent();
				} catch (Exception e) {
					System.out.println("nhap sai vui long nhap lai.");
				}
				break;
			case 6:
				editStudentById();
				break;
			case 7:
				try {
					deleteStudentById();
				} catch (Exception e) {
					System.out.println("nhap sai vui long nhap lai.");
				}
				break;
			case 8:
				sortStudentGpa();
				break;
			case 9:
				sortStudentByName();
				break;
			case 10:
				showStudent();
				break;
			case 11:
				showClassByName();
				break;
			default:
				System.out.println("Nhap sai, moi ban nhap lai.");
				break;
			}

		} while (number != 0);

	}

	public static void addStudent() {
		Student student = new Student();
		student.add();
		studentList.add(student);
		try {
			for (Student sinhVien : studentList) {
				if (student.getName() == sinhVien.getName() || student.getId() == sinhVien.getId()) {
					classList.remove(student);
					throw new Exception("trung thong tin voi student khac vui long nhap lai ! ");
				}
			}
		} catch (Exception e) {
			e.getMessage();
			return;
		}
		for (Lop clas : classList) {
			if (student.getClas() == clas.getName()) {
				clas.setStudentList(student);
			}
		}

	}

	public static void addClass() throws Exception {
		Lop lop = new Lop();
		lop.add();
		try {
			for (Lop clas : classList) {
				if (
						lop.getId() == clas.getId()) {
					throw new Exception("trung id voi class khac vui long nhap lai ! ");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		classList.add(lop);
	}

	public static void editStudentById() {
		boolean test = false;
		System.out.println("Nhap id sinh vien muon edit: ");
		int findId = scanner.nextInt();
		for (Student student : studentList) {
			if (student.getId() == findId) {
				test = true;
				student.add();
				System.out.println("Edit thanh cong");
			}
			if (test == false) {
				System.out.println("Id: " + findId + " khong ton tai");
			}
		}
	}

	public static void deleteStudentById() {
		System.out.println("nhap id sinh vien muon xoa. ");
		int idDelete = scanner.nextInt();
		boolean test = false;
		for (Student student : studentList) {
			if (student.getId() == idDelete) {
				studentList.remove(student);
				test = true;
				System.out.println("Da xoa id" + idDelete);
			}
		}
		if (test == false) {
			System.out.println(" khong co id nay.");
		}
	}

	public static void deleteClassById() {
		System.out.println("nhap id class muon xoa. ");
		int idDelete = scanner.nextInt();
		boolean test = false;
		for (Lop clas : classList) {
			if (clas.getId() == idDelete) {
				classList.remove(clas);
				test = true;
				System.out.println("Da xoa id" + idDelete);
			}
		}
		if (test == false) {
			System.out.println("Id: " + idDelete + " khong ton tai");
		}
	}

	public static void editClassById() {
		boolean test = false;
		System.out.println("Nhap id class muon edit: ");
		int findId = scanner.nextInt();
		for (Lop clas : classList) {
			if (clas.getId() == findId) {
				test = true;
				clas.add();
				System.out.println("Edit thanh cong");
			}
		}
		if (test == false) {
			System.out.println("Id: " + findId + " khong ton tai");
		}
	}

	public static void showStudent() {
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
			System.out.println("Chua co sinh vien nao.");
		}
	}

	public static void sortStudentGpa() {
		boolean test = false;
		for (int i = 0; i < studentList.size() - 1; i++) {
			test = true;
			Student min = studentList.get(i);
			int viTriMin = i;
			for (int j = i + 1; j < studentList.size(); j++) {
				if (studentList.get(i).getGpa() > studentList.get(j).getGpa()) {
					min = studentList.get(j);
					viTriMin = j;
				}
			}
			studentList.set(viTriMin, studentList.get(i));
			studentList.set(i, min);
		}
		if (test == false) {
			System.out.println("Chua co sinh vien nao de sap xep.");
		} else {
			System.out.println("Da sap xep tang dan. ");
		}
	}

	public static void sortClassByName() {
		Collections.sort(classList, new Comparator<Lop>() {

			@Override
			public int compare(Lop o1, Lop o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
	}

	public static void sortStudentByName() {
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());

			}
		});
		System.out.println("da sap xep. ");

	}

	public static void showClassByName() {
		boolean test = false;
		System.out.println("nhap ten class muon show: ");
		scanner.next();
		String name = scanner.nextLine();
		for (Lop clas : classList) {
			if (clas.getName() == name) {
				test = true;
				System.out.println("Id student: " + clas.getId());
				System.out.println("name student: " + clas.getName());
				System.out.println("quantily class" + clas.getQuantity());
				clas.showStudent();
				System.out.println("/****************************************/");
				break;
			}
		}
		if (test == false) {
			System.out.println("Chua co class nao.");
		}
	}

	public static void showMenu() {
		System.out.println("1. Add Lõìp\r\n" + "2. Edit Lõìp by id.\r\n" + "3. Delete Lõìp by id.\r\n"
				+ "4. Sort Lõìp by name..\r\n" + "5. Add student.\r\n" + "6. Edit student by id.\r\n"
				+ "7. Delete student by id.\r\n" + "8. Sort student by gpa.\r\n" + "9. Sort student by name.\r\n"
				+ "10. Show student.\r\n" + "11. Show class by name\r\n" + "0. Exit.\r\n"
				+ "/****************************************/\r\n");
	}

}
