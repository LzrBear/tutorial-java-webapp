# Tutorial Java WebApp

Basically it is split into 2 components. The UI and the Webservice.

The UI is built in react and calls the webservice to conduct business logic and only contains presentation logic.

The web service contains all the business logic and is built using JAX-RS and Jersey.


## Build

Uses maven for build

To build ui
```
cd ui
mvn clean
mvn compile
mvn install
```

To build webservice
```
cd webservice
mvn clean
mvn compile
mvn install
```

Note: once running the ```mvn install``` command a war package will be created in a folder named ```target```.

The war package can be easily deployed onto glassfish using the web ui.

## Other notes
- pom.xml contains maven build configurations
- web.xml contains how glassfish will host the service (this gets packaged into the war)