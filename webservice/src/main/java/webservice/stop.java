package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CSVXtract.csvXtractExecutor;

@Path("/stop")
public class stop {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        csvXtractExecutor.stop();
        
		return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}