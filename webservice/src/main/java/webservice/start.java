package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CSVXtract.csvXtractThread;

@Path("/start")
public class start {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        csvXtractThread.start();

		return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}