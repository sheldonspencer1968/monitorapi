package com.qless.api.monitor;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qless.api.db.QLessDb;
import com.qless.api.util.Monitor;

@Path("")
public class MonitorResource {
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/create")
    public Response createMonitor(String j) throws Exception{
        
		 JSONObject obj = new JSONObject(j);
		 System.out.println(obj.get("userid").toString());
		
		 Monitor mon = new Monitor();
		 mon.setUserid(obj.get("userid").toString());
		 
		 QLessDb db = new QLessDb();
		 System.out.println("this is "+obj.get("userid"));
         db.createNewMonitor(mon);
		 
         db.closeConn();
	    
		return Response.status(200).entity(obj.toString()).build();
    }
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/add/queue")
    public Response addQueue(String queue) throws Exception{
        
		 JSONObject obj = new JSONObject(queue);
		 System.out.println(obj.get("userid").toString());
		
		 Monitor mon = new Monitor();
		 mon.setUserid(obj.get("userid").toString());
		 
		 QLessDb db = new QLessDb();
		 System.out.println("this is "+obj.get("userid"));
         db.createNewMonitor(mon);
		 
         db.closeConn();
	    
		return Response.status(200).entity(obj.toString()).build();
    }
	
	@GET
	@Path("/accounts/{param}")
	public Response getMonitorList(@PathParam("param") int Merchant_id) {

		
        JSONArray objArray = new JSONArray();
        
        QLessDb db = new QLessDb();
        //.fromObject(mybeanList);
        
        objArray = db.readMonitor(Merchant_id);
        	
		
        StringBuilder sb = new StringBuilder();
        sb.append(objArray);
        db.closeConn();
        
		return Response.status(200).entity(sb.toString()).build();

	}
	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateMonitor(@PathParam("userid") int id){
	     
	      return null;
	}
	
	@DELETE
	@Path("/delete/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMonitor(@PathParam("merchant_id") int userid){
	   
	   return null;
	}
}
