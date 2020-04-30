package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import executor.csvXtractExecutor;

@Path("/Admin")
public class Admin {
    
    @GET
    @Path("/Start")
    @Produces(MediaType.APPLICATION_JSON)
    public Response start() {

        csvXtractExecutor.start();

		return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }

    @GET
    @Path("/Stop")
    @Produces(MediaType.APPLICATION_JSON)
    public Response stop() {

        csvXtractExecutor.stop();
        
		return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }

        
    @GET
    @Path("/Status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response status() {

        String status = csvXtractExecutor.getStatus();
        String response2 = "{\"status\": \"" + status + "\"}";

		return Response.ok()
        .entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}