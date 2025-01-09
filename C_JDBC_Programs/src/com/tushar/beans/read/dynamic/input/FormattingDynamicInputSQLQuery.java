package com.tushar.beans.read.dynamic.input;

import java.util.Scanner;

public class FormattingDynamicInputSQLQuery {
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
		
		String formattedQuery = "insert into employee values(" + id + ",'" + name + "','" + department + "')";
		System.out.println(formattedQuery);
	}
}
