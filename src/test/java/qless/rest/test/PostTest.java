package qless.rest.test;

import static org.junit.Assert.*;

import javax.management.Notification;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class PostTest {
	
	
	@Test
    public void createMonitorPost(String j) throws Exception {
		
		String result = "";

		
        assertEquals("Should return status 200", 200, "200");
       
    }

}
