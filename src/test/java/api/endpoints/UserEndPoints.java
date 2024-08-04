package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import api.payloads.UserPojo;

//USerendpoints java file--created for performing CRUD operations.

public class UserEndPoints {

	public static Response createUser(UserPojo payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
	//.contentType("application/json")
 //.accept("application/json")
	.body(payload)
		
				
		.when()
		.post(Routes.post_url);
		return  response;
	}
	
	
	public static Response readUser(String userName) //get it from test
	{
		Response response = given()
	   .pathParam("username", userName)
		
				
		.when()
		.get(Routes.get_url);
		return  response;
	}
	
	
	public static Response updateUser(String userName, UserPojo payload)
	{
		Response response = given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	//.contentType("application/json")
	 //.accept("application/json")
	.pathParam("username", userName)
	.body(payload)
		
				
		.when()
		.put(Routes.update_url);
		return  response;
	}
	
	
	public static Response deleteUser(String userName) //get it from test
	{
		Response response = given()
	   .pathParam("username", userName)
		
				
		.when()
		.delete(Routes.delete_url);
		return  response;
	}
}
