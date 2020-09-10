package nip;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class TestMaskPassword {

	MaskPassword sc;
    JsonObject passwordJson, passwrdPlusJson, nonPasswordJson, nestedJson;
	
	@BeforeTest
	public void initStringsAndObjects(){
		sc = new MaskPassword();
		
		passwordJson = new JsonObject();
		passwordJson.addProperty("user","nody");
		passwordJson.addProperty("dbPassword","nody@123");
		
		passwrdPlusJson = new JsonObject();
		passwrdPlusJson.addProperty("user","nody");
		passwrdPlusJson.addProperty("password","nody@123");
		
		nonPasswordJson = new JsonObject();
		nonPasswordJson.addProperty("user","nody");
		nonPasswordJson.addProperty("token","nody@123");
		
		nestedJson = new JsonObject();
		nestedJson.add("cred", passwordJson);
	}
	
	@Test (priority = 1)
	public void testPasswordJson(){
		String newString = sc.removePasswordFromJsonString(passwordJson.toString());
		JsonObject convertedObject = new Gson().fromJson(newString, JsonObject.class);
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(convertedObject.get("user").getAsString().equals("nody"));
		Assert.assertTrue(convertedObject.get("dbPassword").getAsString().isEmpty() == true);
	}
	
	@Test(priority = 2)
	public void testPasswordPlusJson(){
		String newString = sc.removePasswordFromJsonString(passwrdPlusJson.toString());
		JsonObject convertedObject = new Gson().fromJson(newString, JsonObject.class);
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(convertedObject.get("user").getAsString().equals("nody"));
		Assert.assertTrue(convertedObject.get("password").getAsString().isEmpty() == false);
	}

	@Test(priority = 3)
	public void testNonPasswordJson(){
		String newString = sc.removePasswordFromJsonString(nonPasswordJson.toString());
		JsonObject convertedObject = new Gson().fromJson(newString, JsonObject.class);
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(convertedObject.get("user").getAsString().equals("nody"));
		Assert.assertTrue(convertedObject.get("token").getAsString().isEmpty() == false);
	}
	
	@Test(priority = 4)
	public void testNullJson(){
		String newString = sc.removePasswordFromJsonString(null);
		Assert.assertTrue(newString == null);
	}
	
	@Test (priority = 5)
	public void testNestedPasswordJson(){
		String newString = sc.removePasswordFromJsonString(nestedJson.toString());
		JsonObject convertedObject = new Gson().fromJson(newString, JsonObject.class);
		JsonObject cred = convertedObject.get("cred").getAsJsonObject();
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(cred.get("user").getAsString().equals("nody"));
		Assert.assertTrue(cred.get("dbPassword").getAsString().isEmpty() == true);
	}
	
	@AfterTest
	public void cleanup(){
	}
}




