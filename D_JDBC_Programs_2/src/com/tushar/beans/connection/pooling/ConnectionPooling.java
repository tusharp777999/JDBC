package com.tushar.beans.connection.pooling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class ConnectionPooling {
	public static void main(String[] args) {
		try {
			MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
			mysqlConnectionPoolDataSource.setUrl("jdbc:mysql://localhost:3306/JDBCDB");
			mysqlConnectionPoolDataSource.setUser("root");
			mysqlConnectionPoolDataSource.setPassword("root");
			
			Connection connection = mysqlConnectionPoolDataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getDouble(4));
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
