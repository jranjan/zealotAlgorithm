package nip;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class TestMaskPassword {

	MaskPassword sc;
    JsonObject passwordJson, passwrdPlusJson, nonPasswordJson;
	
	@BeforeTest
	public void initStringsAndObjects(){
		sc = new MaskPassword();
		
		passwordJson = new JsonObject();
		passwordJson.addProperty("user","nody");
		passwordJson.addProperty("password","nody@123");
		
		passwrdPlusJson = new JsonObject();
		passwrdPlusJson.addProperty("user","nody");
		passwrdPlusJson.addProperty("passwordPlus","nody@123");
		
		nonPasswordJson = new JsonObject();
		nonPasswordJson.addProperty("user","nody");
		nonPasswordJson.addProperty("token","nody@123");
	}
	
	@Test (priority = 1)
	public void testPasswordJson(){
		String newString = sc.removePasswordFromJsonString(passwordJson.toString());
		JsonObject convertedObject = new Gson().fromJson(newString, JsonObject.class);
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(convertedObject.get("user").getAsString().equals("nody"));
		Assert.assertTrue(convertedObject.get("password").getAsString().isEmpty() == true);
	}
	
	@Test(priority = 2)
	public void testPasswordPlusJson(){
		String newString = sc.removePasswordFromJsonString(passwrdPlusJson.toString());
		JsonObject convertedObject = new Gson().fromJson(newString, JsonObject.class);
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(convertedObject.get("user").getAsString().equals("nody"));
		Assert.assertTrue(convertedObject.get("passwordPlus").getAsString().isEmpty() == false);
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
	
	@AfterTest
	public void cleanup(){
	}
}




