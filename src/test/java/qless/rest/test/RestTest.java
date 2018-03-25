package qless.rest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;


import com.qless.api.monitor.MonitorResource;

import io.restassured.RestAssured;


@RunWith(MockitoJUnitRunner.class)
public class RestTest  {
	
	@Mock
	Client client ;
	
	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }
	
	@Test
    public void getMonitorRead() throws Exception {
		 
		/*
		Response output = target("/accounts/1").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
        
        */
		
		get("/monitor-api/rest/accounts/12");

       
    }
	@Test
    public void monitorPos() throws Exception {
		 

		post("/monitor-api/rest/create");

       
    }
}
