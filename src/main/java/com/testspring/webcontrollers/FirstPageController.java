package com.testspring.webcontrollers;

import java.net.URI;
import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testspring.models.Person;
import com.testspring.services.PersonService;

@Controller
public class FirstPageController {

	@Autowired
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(value="/myFirstPage")
	public String addFactory() {
		List<Person> people = personService.getPeople();
		int count = 0;
		for(Person person : people) {
			System.out.println("Count in person loop : " + count);
			System.out.println("name is : " + person.getName());
			System.out.println("age is : " + person.getAge());
			System.out.println("salary is : " + person.getSalary());
			System.out.println("birth_date is : " + person.getBirthDate());
			count ++;
		}
		return "firstPage";
	}
	
	@RequestMapping(value={"/viewData2"})
	public String viewClothes() {
		System.out.println("#S viewClothes()");
//		List<Cloth> clothList = clothService.showClothes();
//		System.out.println("#S clothList is: " + clothList);
//		
//		List<Factory> factoryList = this.factoryService.showFactories();
//		System.out.println("#S factoryList: " + factoryList);
		
		return "viewData";
	}
	
	public void testJDBC() {
//		String env = "PROD";
		String env = "DEV";

		System.out.println("#S in addFactory()");
		final String JDBC_DRIVER = "org.postgresql.Driver";  
		final String DB_URL = "postgres://vuqawfzvcaajtj:649f5cc6b76c8c483d86d15aa2c9c273a4617c7f1e62ed770853edc1d9eb168b@ec2-23-21-220-48.compute-1.amazonaws.com:5432/d6dqu4l3kpal1d";

		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      
			  // For Heroku 
		      URI dbUri = null;
		      if( "PROD".equals(env) ) {
		    	  dbUri = new URI(System.getenv("DATABASE_URL"));  
		      }
		      else {
		    	  dbUri = new URI(DB_URL);
		      }		      
			  
		      String username = dbUri.getUserInfo().split(":")[0];
			  String password = dbUri.getUserInfo().split(":")[1];
			  String sslParam = "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			  
			  String dbUrl = "";
			  if( "PROD".equals(env) ) {
				  dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath(); 
			  }
			  else {
				  dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + sslParam;
			  }
			  System.out.println("#S dbUrl: " + dbUrl);
			  // End For Heroku
			  
		      conn = DriverManager.getConnection(dbUrl, username, password);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM \"Person\"";
		      ResultSet rs = stmt.executeQuery(sql);

		      int count = 0;
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		    	  System.out.println("#S count: " + count);
		         //Retrieve by column name
		    	  int id  = rs.getInt("id");
		    	  String name = rs.getString("name");
		    	  int age = rs.getInt("age");

		         //Display values
		    	  System.out.println("ID: " + id);
		    	  System.out.println("Name: " + name);
		    	  System.out.println("Age: " + age);
		    	  count++;
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      System.out.println("#S success woi!!!");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } finally {
		      //finally block used to close resources
		      try {
		         if(stmt!=null)
		            stmt.close();
		      } catch(SQLException se2) {
		      }// nothing we can do
		      try {
		         if(conn!=null)
		            conn.close();
		      } catch(SQLException se) {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
	}
}
