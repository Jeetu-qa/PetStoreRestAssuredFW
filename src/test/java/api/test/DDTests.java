package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.UserPojo;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests {
	//Instead of using faker for getting id and other data , we will use Data provider from utilities.

	// if data provider is in same class then we specify like @Test(Priority=1,dataprovider ="data")
	// if data provider is in same class then we specify like below and import dataprovider lib.
	
	@Test(priority=1, dataProvider ="Data", dataProviderClass = Dataproviders.class)  
	
public void testPostuser(String UserID, String UserName, String UserFirstName, String UserLastName , String Email, String Password , String Phone)
//Using these parameter and data we will create payload like POJO 

// 1. DP fetch data from excel sheet and provided to postrequest then we can pass the data to payload for payload creation.

{
	UserPojo UserPayload = new UserPojo(); // using UserPayload we will send above data to payload.
	
	UserPayload.setId(Integer.parseInt(UserID)); 
	UserPayload.setUsername(UserName);
	UserPayload.setFirstName(UserFirstName);
	UserPayload.setLastName(UserLastName);
	UserPayload.setEmail(Email);
	UserPayload.setPassword(Password);
	UserPayload.setPhone(Phone);
	
	//2. Now need to send post request
	
		Response response = UserEndPoints.createUser(UserPayload);
		Assert.assertEquals(response.getStatusCode(),200);
	
}
	
	
	@Test(priority = 2,dataProvider ="UserNames", dataProviderClass = Dataproviders.class )
	public void testDeleteUserByName(String UserName)
	{
		Response response = UserEndPoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}













