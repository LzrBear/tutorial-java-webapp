package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import executor.csvXtractExecutor;

@Path("/Logs")
public class Logs {
    
    @GET
    @Path("/Get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        String Logs = csvXtractExecutor.getLogs();
        String response2 = "{\"Logs\": \"" + Logs + "\"}";

		return Response.ok()
        .entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}