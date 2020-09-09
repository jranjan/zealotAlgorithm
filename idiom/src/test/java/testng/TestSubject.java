package testng;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestSubject {
	Subject sc;
	String str1, str2;
	
	@BeforeTest
	public void initStringsAndObjects(){
		sc = new Subject();
		str1 = "abc";
		str2 = "def";
	}
	
	@Test (priority = 1)
	public void testMergeStrings(){
		Assert.assertNotNull(sc.mergeStrings(str1, str2));
		Assert.assertEquals(sc.mergeStrings(str1, str2), "abcdef");
	}
	
	@Test(priority = 2)
	public void testMergeStringsWithDash(){
		Assert.assertNotNull(sc.mergeStringsWithDash(str1, str2));
		Assert.assertEquals(sc.mergeStringsWithDash(str1, str2), "abc-def");
		Assert.assertNotSame(sc.mergeStringsWithDash(str1, str2), "abcdef");
	}

	@AfterTest
	public void cleanup(){
		str1 = null;
		str2 = null;
		sc = null;
	}
}