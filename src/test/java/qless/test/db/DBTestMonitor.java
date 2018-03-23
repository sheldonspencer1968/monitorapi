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
import com.qless.api.util.Monitor;

import org.junit.Assert;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

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
    public void setUp() throws Exception {
        assertNotNull(ds);
        Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
        Mockito.when(ds.getConnection()).thenReturn(c);
        mon = new Monitor();
        mon.setUserid("name.monitor");
        Mockito.when(rs.first()).thenReturn(true);
        Mockito.when(stmt.executeQuery()).thenReturn(rs);
    }

	
}


