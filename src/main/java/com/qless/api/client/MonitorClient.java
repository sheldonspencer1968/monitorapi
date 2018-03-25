package com.qless.api.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

import com.qless.api.db.QLessDb;
import com.qless.api.util.Monitor;

public class MonitorClient {
	
	public void createMonitor(){
	
		QLessDb db = new QLessDb();
	    Monitor mon = new Monitor();
	    mon.setUserid("xox0000");
	    
		try {

			Client client = ClientBuilder.newClient(new ClientConfig());
			
			JSONObject obj = new JSONObject(mon);
			
			Response result = client
	                .target("http://localhost:8080/monitor-api/rest")
	                .path("/create")
	                .request()
	                .post(Entity.json(obj.toString()));
			
	        System.out.println(String.format("===> Response = %s", result.toString()));
	        
	        Object o = result.readEntity(String.class);
	        
	        System.out.println(o);
	        
	       
		}catch (Exception e) {

			e.printStackTrace();

		  }

	}
	public void readMonitor(int v){
		
		
	    
		try {

			Client client = ClientBuilder.newClient(new ClientConfig());
			
			Response result = client
	                .target("http://localhost:8080/monitor-api/rest")
	                .path("/accounts/"+ v)
	                .request()
	                .get();
			
	        System.out.println(String.format("===> Response = %s", result.toString()));
	        
	        Object o = result.readEntity(String.class);
	        
	        System.out.println(o);
	        
	       
		}catch (Exception e) {

			e.printStackTrace();

		  }
		
	}
	public void deleteMonitor(){
	
		QLessDb db = new QLessDb();
	    Monitor mon = new Monitor();
	    mon.setUserid("xox0000");
	    
		try {

			Client client = ClientBuilder.newClient(new ClientConfig());
			
			JSONObject obj = new JSONObject(mon);
			
			Response result = client
	                .target("http://localhost:8080/monitor-api/rest")
	                .path("/delete")
	                .request()
	                .delete();
			
	        System.out.println(String.format("===> Response = %s", result.toString()));
	        
	        Object o = result.readEntity(String.class);
	        
	        System.out.println(o);
	        
	       
		}catch (Exception e) {

			e.printStackTrace();

		  }
	}
	 public static void main(String[] args) {

		    MonitorClient client = new MonitorClient();
		    client.readMonitor(1);
	 }
    
	 
}
