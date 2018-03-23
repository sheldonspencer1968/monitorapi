package com.qless.api.monitor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		 
	    
		return Response.status(200).entity(obj.toString()).build();
    }
	@GET
	@Path("/{param}")
	public Response getMonitorList(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;
        JSONObject obj = new JSONObject();
        try {
			obj.append("name", msg);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        
		return Response.status(200).entity(sb.toString()).build();

	}
}
