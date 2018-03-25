package com.qless.api.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qless.api.util.Monitor;

public class QLessDb {
	private Connection conn;
	public QLessDb(){
	  
		try {
       	 if (conn == null){
			  Class.forName("com.mysql.jdbc.Driver");
		     conn =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3305/qless",  "admin", "kentish");
	         conn.setAutoCommit(true);
			}
		
		} catch (SQLException ex){
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public void createNewMonitor(Monitor mon){
		
		String sqlstmt = "INSERT INTO account (userid) values (?)"; 
		insertNewEmployee(mon);
		try {
			PreparedStatement prepStmt = conn.prepareStatement(sqlstmt);
			
			prepStmt.setString(1, mon.getUserid());
			
			prepStmt.execute("use qless");
			prepStmt.executeUpdate();
			prepStmt.close();
			 } catch (SQLException ex){
				 ex.printStackTrace();
				 
			 }
	}
	private void insertNewEmployee(Monitor mon){
		
		String sqlstmt = "INSERT INTO employee (userid, lastname) values (?, ?)"; 
		
		try {
			PreparedStatement prepStmt = conn.prepareStatement(sqlstmt);
			
			prepStmt.setString(1, mon.getUserid());
			prepStmt.setString(2, "monitor");
			prepStmt.execute("use qless");
			prepStmt.executeUpdate();
			prepStmt.close();
			 } catch (SQLException ex){
				 ex.printStackTrace();
				 
			 }
	}
	public JSONArray readMonitor(int Merchant_id){
		
		String sqlstmt = "SELECT account_userid FROM employee WHERE merchant_id = ? and lastname = 'monitor'"; 
		JSONArray jArray = new JSONArray();
		
		PreparedStatement prepStmt;
		try {
			prepStmt = conn.prepareStatement(sqlstmt);
			prepStmt.setInt(1, Merchant_id);
			ResultSet rs = prepStmt.executeQuery();
			
			while (rs.next()) {
			
				JSONObject obj = new JSONObject();
				obj.put("userid", rs.getString(1));
				jArray.put(obj);
				
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jArray;
	}
	public void closeConn(){
	 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
