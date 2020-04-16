package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorld {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHtmlHello() {
		return Response.ok()
        .entity("{\"name\": \"fish\"}")
        .header("Access-Control-Allow-Origin", "*")
        .build();
    }
}