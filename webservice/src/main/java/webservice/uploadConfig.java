package webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CSVXtract.csvXtractThread;

@Path("/uploadConfig")
public class uploadConfig {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        //String Logs = App.getLogs();
        //String response2 = "{\"Logs\": \"" + Logs + "\"}";

		return Response.ok()
        //.entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}