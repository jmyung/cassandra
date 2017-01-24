package com.multi.cas.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
		Connection con = DriverManager
				.getConnection("jdbc:cassandra://192.168.56.101:9160/testdb");
		String query = "INSERT INTO employees (empid, deptid, empname) VALUES (?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 1011);
		pstmt.setInt(2, 1);
		pstmt.setString(3, "정형돈");
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		System.out.println("실행 완료!!");
	}

}
