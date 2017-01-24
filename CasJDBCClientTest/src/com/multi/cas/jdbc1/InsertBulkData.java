package com.multi.cas.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class InsertBulkData {

	public static void main(String[] args) throws Exception {
	    Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
	    //Connection con = DriverManager.getConnection("jdbc:cassandra://localhost:9160/testdb");
	    Connection con = DriverManager.getConnection("jdbc:cassandra://192.168.56.101:9160/testdb");
	    
	    String sql = "INSERT INTO products (productid, productname, price) VALUES (?, ?, ?)";
	    PreparedStatement pstmt =  con.prepareStatement(sql);
	    
	    for (int i=1; i <= 3000; i++) {
	    	pstmt.setInt(1, i);
	    	pstmt.setString(2, "아이패드" + i);
	    	pstmt.setInt(3, 1000+(500*(i % 10)));
	    	pstmt.executeUpdate();
	    }

	    pstmt.close();
	    con.close();
	    
	    System.out.println("Row 생성 완료!!");
	}

}
