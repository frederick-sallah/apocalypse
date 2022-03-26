
Kindly pay attention to the following steps for the deployment of the Apocalyse application:

- You will find an apocalypse.sql file at the root of the project.
- Please create a mysql database named "apocalypse" and import the apocalypse.sql file.
  (After importing the apocalypse.sql , check if the 3 tables(contamination,survivor,resource) have been created 
- Make sure you update your database credentials in application.properties file
- After running the application on your local machine, you can access the API swagger documentation via http://localhost:8080/swagger-ui/index.html


=================================================================================================================
Endpoints for consuming the API
=================================================================================================================

  + Create a new survivor 
  Endpoint : /apocalypse/v1/survivors/create
  Method : POST
  Payload :{"name": "tety","age": "30","gender": "Male", "latitude": "5555","longitude": "44","inventory": [{"name": "water"}]}
  Instruction : gender field value can be either "Male" or "Female"
  
  
  + Update a  survivor location
  Endpoint : /apocalypse/v1/survivors/update
  Method : POST
  Payload :{"survivor_id": 3,"latitude": "9847.75","longitude": "9857.75"}
  Instruction : survivor_id is the ID of the survivor
  
  
  + Flag survivor as infected
  Endpoint : /apocalypse/v1/infections
  Method : POST
  Payload :{"survivor_id":7,"reporter_id":5,}
  Instruction : reporter_id is the id of the servivor reporting 
  
  + Listing robots
  Endpoint : /apocalypse/v1/robots
  Method : GET
  Payload :
  Instruction : 
  
  
  + Percentage of infected survivors.
  Endpoint : /apocalypse/v1/survivors/infectedPercentage
  Method : GET
  Payload :
  Instruction :
  
  
  + Percentage of non-infected survivors.
  Endpoint : /apocalypse/v1/survivors/nonInfectedPercentage
  Method : GET
  Payload :
  Instruction :
  
  
  + List of infected survivors
  Endpoint : /apocalypse/v1/survivors/infected
  Method : GET
  Payload :
  Instruction : 
  
  
  + List of non-infected survivors
  Endpoint : /apocalypse/v1/survivors/nonInfected
  Method : GET
  Payload :
  Instruction : 
  
  

 
