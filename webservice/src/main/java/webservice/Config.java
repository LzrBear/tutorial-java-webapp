package webservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import CSVXtract.csvXtractExecutor;

@Path("/Config")
public class Config {
    
    @POST
    @Path("/Upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response upload(  @FormDataParam("file") InputStream fileInputStream) throws Exception
    {
        String UPLOAD_PATH = csvXtractExecutor.getCSVXtractWorkingDirectory();
        try
        {
            int read = 0;
            byte[] bytes = new byte[1024];
     
            String filePath = UPLOAD_PATH + "/configuration.properties";
            File confFile = new File(filePath);
            OutputStream out = new FileOutputStream(confFile);
            while ((read = fileInputStream.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
            
        } catch (IOException e) {
            throw new WebApplicationException("Error while uploading configuration file. Please try again.");
        }
        return Response.ok("Configuration file uploaded successfully.").build();
    }

    @GET
    @Path("/Download")
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