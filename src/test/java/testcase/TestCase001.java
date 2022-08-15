package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestCase001 extends BaseTest {
	
	@Test(dataProvider="logintestdata")
	public static void LoginTest(String username, String password) throws InterruptedException  {
		
		/* Steps to automate:
		 * 1. open chrome
		 * 2. navigate to URL
		 * 3.click on sign-in button
		 * 4. navigate sign-in page
		 * 5.click on "Sign in with IMDB" button
		 * 6. enter valid e-mail
		 * 7. enter valid password
		 * 8. click on sign-in button
		 * 9. Validation (login Succesfully?)
		 *     -url of the page is "https://www.imdb.com/?ref_=login" */
		
		
		driver.findElement(By.linkText(loc.getProperty("singin_button"))).click();
		driver.findElement(By.linkText(loc.getProperty("signin_w_imdb_button"))).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(loc.getProperty("password_field"))).sendKeys(password);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(loc.getProperty("login_signin_button"))).click();
		Thread.sleep(1000);
		
		
		
		String expectedURL = "https://www.imdb.com/?ref_=login";
		String actualURL = driver.getCurrentUrl();
				
        Assert.assertEquals(expectedURL, actualURL);
		System.out.print("login succesfull.");
		
		
	}
	
	
	@DataProvider(name = "logintestdata")
	public Object[][] createData1() {
	 return new Object[][] {
		{"testing3mail.com","pass355893"},
		{"testing389389@gmail.com","ttttt344"},
		{"tdfgr@gmail.com","goii333"},
		{"testing389389@gmail.com","pass3893"},
	 };
	}


	}
	
	

