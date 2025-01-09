package com.tushar.beans;

public class StaticBlockExecution {
	public static void main(String[] args) {
		try {
			Class.forName("com.tushar.beans.Student");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//From JDBC 4.0 and Java 1.6 onwards we dont need to register driver explicitly.
	// because JDBC will load it from classpath automatically.
}
