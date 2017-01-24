package com.multi.cas.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class testCQLJDBC2 {

	public static void main(String[] args) throws Exception {
	    Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
	    Connection con = DriverManager.getConnection("jdbc:cassandra://192.168.56.121:9160/test1");
	    
	    String sql = "SELECT count(*) AS cnt FROM products";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    rs.next();
	    System.out.println("Ä«¿îÆ® : " + rs.getInt(0));
	    
	    rs.close();
	    stmt.close();
	    con.close();
	}

}
