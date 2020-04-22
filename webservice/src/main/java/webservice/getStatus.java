package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hello.App; //my helloworld application

@Path("/getStatus")
public class getStatus {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        String status = App.getStatus();
        String response2 = "{\"status\": \"" + status + "\"}";

		return Response.ok()
        .entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}