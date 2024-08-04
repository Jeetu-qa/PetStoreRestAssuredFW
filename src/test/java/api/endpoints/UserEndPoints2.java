package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.ResourceBundle;

import api.payloads.UserPojo;

//created to CRUD methods for user

public class UserEndPoints2 {

	//Load  properties file and read the data from prop. file
	//get the url from prop file
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //bundle class will load the prop file
		return routes;
	}
	
	
	
	public static Response createUser(UserPojo payload)
	{
		
		String post_url = getURL().getString("post_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
	//.contentType("application/json")
 //.accept("application/json")
	.body(payload)
		
				
		.when()
		.post(post_url);
		return  response;
	}
	
	
	public static Response readUser(String userName) //get it from test
	{
		String get_url = getURL().getString("get_url");
		Response response = given()
	   .pathParam("username", userName)
		
				
		.when()
		.get(get_url);
		return  response;
	}
	
	
	public static Response updateUser(String userName, UserPojo payload)
	{
		String update_url = getURL().getString("update_url");
		Response response = given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	//.contentType("application/json")
	 //.accept("application/json")
	.pathParam("username", userName)
	.body(payload)
		
				
		.when()
		.put(update_url);
		return  response;
	}
	
	
	public static Response deleteUser(String userName) //get it from test
	{
		String delete_url = getURL().getString("delete_url");
		Response response = given()
	   .pathParam("username", userName)
		
				
		.when()
		.delete(delete_url);
		return  response;
	}
}
