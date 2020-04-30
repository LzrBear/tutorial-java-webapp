package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CSVXtract.csvXtractThread;

@Path("/getLogsServerFilePath")
public class getLogsServerFilePath {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        String LogsServerFilePath = csvXtractThread.getLogPath();
        String response2 = "{\"LogsServerFilePath\": \"" + LogsServerFilePath + "\"}";

		return Response.ok()
        .entity(response2)
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}