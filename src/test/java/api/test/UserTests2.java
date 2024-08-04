package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints2;
import api.payloads.UserPojo;
import io.restassured.response.Response;

public class UserTests2 {
	
	
	Faker faker;
	
	UserPojo userpayload;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
	
		faker = new Faker(); // pass the data to pojo class method variables
		
		userpayload = new UserPojo();    //pass the data to pojo class payload
		
		userpayload.setId(faker.idNumber().hashCode());  //generate random id
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPassword(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//logs
		
		logger = LogManager.getLogger(this.getClass()); 
		
		
	}
	
	@Test(priority = 1)
	public void testPostUser()
	
	{
		logger.info("****************Creating User****************");
		Response response = UserEndPoints2.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****************User is Created****************");
	}

	
	@Test(priority = 2)
	public void testGetUser()
	{
		logger.info("****************Reading User Info****************");
		Response response = UserEndPoints2.readUser(this.userpayload.getUsername()); // this to refer payload
		response.then().log().all();
		//response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200); //we user get status code while assertion
		logger.info("****************User info is displayed****************");
	}

@Test(priority = 3)
	public void testUpdateUserByName()
	{
	logger.info("****************Updating User Info****************");
	//update data for same payload
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setPassword(faker.internet().safeEmailAddress());
	
		Response response = UserEndPoints2.updateUser(this.userpayload.getUsername(),userpayload);
		//response.then().log().all();
		response.then().log().body().statusCode(200);
		//Assert.assertEquals(response.getStatusCode(),200);
		
		//Checking data after update
		Response responseAfterUpdate = UserEndPoints2.readUser(this.userpayload.getUsername()); // this to refer payload
		responseAfterUpdate.then().log().all();
		//response.statusCode();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("****************User Info is Updated****************");
	}
	
@Test(priority = 4)
public void testDeleteUserByName()
{
	logger.info("****************Deleting User Info****************");
	Response response = UserEndPoints2.deleteUser(this.userpayload.getUsername());
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("****************User Info is Deleted****************");
	
}
	
}
