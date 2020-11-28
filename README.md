# MarsRoverChallenge
Project building step

step1: Pull the project from git repository.

step2: Go to the source folder and build it using below command.

  mvn clean install
  
step3: Go to the target  folder and run jar file using below command.

 java -jar target/MarsOverChallenge-1.0.jar
 
 Service endpoint URL
http://localhost:8080/getRoverCordination

Request JSON 
{
  "x": 5,
  "y": 5,
  "roverList": [{
    "roverX": 1,
    "roverY": 2,
    "direction": "N",
    "roverCommand": "LMLMLMLMM"
  }, {
    "roverX": -3,
    "roverY": 3,
    "direction": "E",
    "roverCommand": "MMRMMRMRRM"
  }]
}
Response JSON
{
  "roversPath": ["1 3 N", "5 1 E"],
  "errorDescription": "success"
}

Swagger URL details.
http://localhost:8080/swagger-ui.html#/mars-rover-controller/getRoverCordinationUsingPOST
