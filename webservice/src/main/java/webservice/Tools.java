package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CSVXtract.csvXtractExecutor;

@Path("/Tools")
public class Tools {
    
    @GET
    @Path("/GET/CSVXtractWorkingDirectory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        String CSVXtractWorkingDirectory = csvXtractExecutor.getCSVXtractWorkingDirectory();
        String response2 = "{\"CSVXtractWorkingDirectory\": \"" + CSVXtractWorkingDirectory + "\"}";

		return Response.ok()
        .entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}