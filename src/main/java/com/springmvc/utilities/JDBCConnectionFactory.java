package com.springmvc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionFactory {
	private static Connection connection = null;
	static {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345678" );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static Connection getJDBCConnection() {
		return connection;
	}
}
