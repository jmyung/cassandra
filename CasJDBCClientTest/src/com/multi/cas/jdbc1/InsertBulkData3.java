package com.multi.cas.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class InsertBulkData3 {

	public static void main(String[] args) throws Exception {
	    Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
	    Connection con = DriverManager.getConnection("jdbc:cassandra://192.168.56.101:9160/testdb");
	    //Connection con = DriverManager.getConnection("jdbc:cassandra://192.168.56.121:9160/testdb");
	    
	    String sql = "INSERT INTO products3 (productid, type, productname, price) VALUES (?, ?, ?, ?)";
	    PreparedStatement pstmt =  con.prepareStatement(sql);
	    
	    String[] types = new String[]{ "A", "B", "C", "D", "E" }; 
	    
	    for (int i=1; i <= 3000; i++) {
	    	pstmt.setInt(1, i);
	    	pstmt.setString(2, types[i % 5]);
	    	pstmt.setString(3, "아이패드" + i);
	    	pstmt.setInt(4, 1000+(500*(i % 10)));
	    	pstmt.executeUpdate();
	    }

	    pstmt.close();
	    con.close();
	    
	    System.out.println("Row 생성 완료");
	}

}
