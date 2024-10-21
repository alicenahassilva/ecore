package anahas.exam.login;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class LoginTestCases {
	
	//Page Object
	private LoginPageObject loginPage;
	
	//Pre-condition: Have the main page loaded
	@BeforeEach
	public void beforeEach () {
		loginPage = new LoginPageObject();
	}

	//Post-test: Close browser
	@AfterEach
	public void afterEach () {
		loginPage.closePage();
	}
	
	//Test Case 001
	//Description: happy path. After successful login, the new
	//page should be verified.
	@Test
	@Order(1)
	public void tc001 () {
	//Step1
		//Testing variables
		String username = "demouser";
		String password = "abc123";
		//Test
		loginPage.enterCredentials (username, password);
		loginPage.submitLogin();
		Assert.assertTrue(loginPage.checkLogOutButton());
		Assert.assertEquals("Automation Example", loginPage.checkTitle());
		Assert.assertEquals("Invoice Details",loginPage.findInvoiceLink());

	}
	
	//Test Case 002
	//Description: 3 invalid logins (check error message). Last
	//login is successful (validate).
	@Test
	@Order(2)
	public void tc002 () {
	//Interaction1
			//Testing variables
			String username = "Demouser";
			String password = "abc123";
			//Test
			loginPage.enterCredentials (username, password);
			loginPage.submitLogin();
			Assert.assertFalse(loginPage.checkLogOutButton());
			Assert.assertEquals("Wrong username or password.", loginPage.loginErrorMessage());
	//Interaction2
			//Testing variables
			String username2 = "demouser_";
			String password2 = "xyz";
			//Test
			loginPage.enterCredentials (username2, password2);
			loginPage.submitLogin();
			Assert.assertFalse(loginPage.checkLogOutButton());
			Assert.assertEquals("Wrong username or password.", loginPage.loginErrorMessage());
	//Interaction3
			//Testing variables
			String username3 = "demouser";
			String password3 = "nananana";
			//Test
			loginPage.enterCredentials (username3, password3);
			loginPage.submitLogin();
			Assert.assertFalse(loginPage.checkLogOutButton());
			Assert.assertEquals("Wrong username or password.", loginPage.loginErrorMessage());
	//Interaction4
			//Testing variables
			String username4 = "demouser";
			String password4 = "abc123";
			//Test
			loginPage.enterCredentials (username4, password4);
			loginPage.submitLogin();
			Assert.assertTrue(loginPage.checkLogOutButton());
			Assert.assertEquals("Invoice Details",loginPage.findInvoiceLink());
	}
}
	
	