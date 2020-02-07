# transitchecker-service
This is the service that allows to check if the Vehicle is Allow To transit according to the  Ecuadorian "Pico y Placa" rules

# Software Requirements

* JDK 1.8 or greater
* Maven

# Info

This application demostrate the use of services, in this case the rules related to the "Pico y Placa" is serve by a REST service. The main goal is that service will be invoked by many front-end and IOT devices. For sample propouses I created an mobile App that Invoke this service.

# Build

In order to build this program, open a command line on the transitchecker-service path and execute

~~~~
  mvn spring-boot:run
~~~~

This command launch the Pico y Placa service on the port 8080

> If you need to run on a different port you can modify the src/main/resources/application.properties on the value of the server.port property

When you run this item you will be able to invoke the rest service with swagger-ui on the
following URL address:

~~~~
  http://localhost:8080/swagger-ui.html
~~~~

It will open a swagger ui with the explanation to invoke the service, please open the transit-check-controller operation, on the request field you can put the following JSON in order to invoke:


~~~~
{
  "date": "02/02/2020",
  "time": "17:29",
  "vehicleId": "ABB0233"
}
 ~~~~
 
 The service has three parameters on the JSON
 
 * date - The date in format dd/MM/yyyy
 * time - The time in format HH:mm
 * vehicleId - The "Placa" of the vehicle
 
 ![Invoke the service](screen1.png)
 
 # Android Application
 
 Alternatively on the [Transit Checker App Repository](https://github.com/cgsuarez/transitchecker) you can build and use an Android/iOS App (based on Flutter) that act like a client of the service. This client takes the "Placa" the Date to verify if its allowed to go, with the service. As you can see on the pictures below, in order to configure the URL of the service on the upper right corner you can modify the value of the URL of the server (by default the URL is the Android Emulator localhost IP)
 
 
  ![Mobile Screen](screen2.png)
  
  ![Mobile Screen](screen3.png)
