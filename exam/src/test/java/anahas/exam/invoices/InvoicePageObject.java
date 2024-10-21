package anahas.exam.invoices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvoicePageObject {
	
	private WebDriver driver;
	
	public InvoicePageObject(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void closePage() {
		this.driver.quit();
	}

	//Selecting the first "Invoice Details" link.
	//We need to check to the new tab, otherwise the tab is opened but
	//the first tab still has the "focus" from the testing perspective.
	public InvoiceDetailsPageObject selectInvoice() {
		driver.findElement(By.xpath("//a[@href='/invoice/0']")).click();
		Object[] windowHandles=driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[1]);
		return new InvoiceDetailsPageObject(driver); 
	}

}
