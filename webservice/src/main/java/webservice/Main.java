package webservice;

import javax.xml.ws.Endpoint;
import webservice.SimpleWebService;

public class Main {
	public static void main(String[] args){
		Endpoint.publish("http://localhost:8888/testWS", new SimpleWebService());
	}
}