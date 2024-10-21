package anahas.exam.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import anahas.exam.invoices.InvoicePageObject;

public class LoginPageObject {
	
	private String TestUrl = "https://automation-sandbox-python-mpywqjbdza-uc.a.run.app/";
	private WebDriver driver;
	
	//Chrome Driver processes
	public LoginPageObject() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.navigate().to(TestUrl);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void closePage() {
		this.driver.quit();
	}

	public void enterCredentials(String username, String password) {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	}

	public InvoicePageObject submitLogin() {
		driver.findElement(By.id("btnLogin")).submit();
		return new InvoicePageObject(driver);
	}

	public boolean checkLogOutButton() {
		try {
			return driver.findElement(By.xpath("/html/body/nav/ul/li/a")).isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}

	public String loginErrorMessage() {
		return driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
	}

	public String checkTitle() {
		return driver.findElement(By.className("navbar-brand")).getText();
	}

	public String findInvoiceLink() {
		return driver.findElement(By.xpath("//a[@href='/invoice/0']")).getText();
	}
	
	

}
