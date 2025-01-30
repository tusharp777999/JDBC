package com.tushar.beans.parameter.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

public class ParameterMetadataProgram {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?)");
			ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
			int parameterCount = parameterMetaData.getParameterCount();
			for(int i = 0; i <= parameterCount; i++) {
				System.out.println("Parameter Class Name: " + parameterMetaData.getParameterClassName(i));
				System.out.println("Parameter Mode: " + parameterMetaData.getParameterMode(i));
				System.out.println("Parameter Type: " + parameterMetaData.getParameterType(i));
				System.out.println("Parameter Type Name: " + parameterMetaData.getParameterTypeName(i));
				System.out.println("Precision: " + parameterMetaData.getPrecision(i));
				System.out.println("Scale: " + parameterMetaData.getScale(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
