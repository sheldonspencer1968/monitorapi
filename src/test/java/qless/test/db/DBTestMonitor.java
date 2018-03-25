package qless.test.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;


import com.mysql.jdbc.ResultSet;
import com.qless.api.db.QLessDb;
import com.qless.api.util.Monitor;

import org.junit.Assert;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DBTestMonitor {

	@Mock
	private DataSource ds;
	
	@Mock
	private Connection c;
	
	@Mock
	private PreparedStatement stmt;
	
	@Mock
	private ResultSet rs;
	
	@Mock
	PreparedStatement prepStmt;

	Monitor mon;
	
	/*
	@Test
	public void NewMonitorInsert(){
		
		Monitor mon = new Monitor();
		
	}*/
	@Before
	public void setItUp() {
	 
	     MockitoAnnotations.initMocks(this);
	}
	 
	
	@Test 
    public void createNewMonitor() throws Exception {
		String sqlstmt = "INSERT INTO account (userid) values (?)";
		prepStmt = c.prepareStatement(sqlstmt);
        Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(prepStmt);
        Mockito.when(rs.first()).thenReturn(true);
        Mockito.when(stmt.executeQuery()).thenReturn(rs);
    }
    @Test
    public void readMonitor(){
 
    	String sqlstmt = "SELECT account_userid FROM employee WHERE merchant_id = ? and lastname = 'monitor'"; 
		
    	try {
			prepStmt = c.prepareStatement(sqlstmt);
			Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(prepStmt);
			Mockito.when(rs.first()).thenReturn(true);
			Mockito.when(stmt.executeQuery()).thenReturn(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//connection.setAutoCommit(false);    //begin transaction
    	
    	

    }
	
}


