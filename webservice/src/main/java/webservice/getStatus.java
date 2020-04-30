package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CSVXtract.csvXtractExecutor;

@Path("/getStatus")
public class getStatus {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        String status = csvXtractExecutor.getStatus();
        String response2 = "{\"status\": \"" + status + "\"}";

		return Response.ok()
        .entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}