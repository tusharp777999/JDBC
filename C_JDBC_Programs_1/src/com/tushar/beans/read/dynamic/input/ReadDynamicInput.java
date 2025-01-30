package com.tushar.beans.read.dynamic.input;

import java.util.Scanner;

public class ReadDynamicInput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the employee id.");
		int id = scanner.nextInt();

		System.out.println("Enter the employee name.");
		String name = scanner.next();

		System.out.println("Enter the department.");
		String department = scanner.next();

		System.out.println("Your provided input is as follow:");
		System.out.println(id + " " + name + " " + department);

		scanner.close();
	}
}
