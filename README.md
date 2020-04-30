# Tutorial Java WebApp

Basically it is split into 2 components. The UI and the Webservice.

The UI is built in react and calls the webservice to conduct business logic and only contains presentation logic.

The web service contains all the business logic and is built using JAX-RS and Jersey.


## Run in Debug

### Webservice
The following commands should start a local grizzly http server with the webservice project. 
```
cd webservice
mvn exec:java
```
To test if running go to the url http://localhost:1337/CSVXtract-WS/rest/getStatus, you should see a json response with the status.

### UI
The following commands will start a development environment. Note once running all changes made to the front end files will automatically be refelected in the running development instance.
```
cd ui
npm install
npm start
````

n.b. you only need to run npm install when your local copy is missing the node_modules dependancies.

## Build

To build run the build script
```
./build.sh
```

The generated war files will be placed in a directory called target.

**Notes**:
- Uses maven for build
- Once running the ```mvn install``` command a war package will be created in a folder named ```target```.
- The war package can be easily deployed onto glassfish using the glassfish admin web interface.
- pom.xml contains maven build configurations
- web.xml contains how glassfish will host the service (this gets packaged into the war)