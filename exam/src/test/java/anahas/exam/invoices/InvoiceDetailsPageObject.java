package anahas.exam.invoices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class InvoiceDetailsPageObject {
	
	private WebDriver driver;
	By totalStayCount = By.xpath("/html/body/section/div/table[1]/tbody/tr[3]/td[2]");
	By totalStayAmount = By.xpath("/html/body/section/div/table[1]/tbody/tr[4]/td[2]");
	By checkCheckIn = By.xpath("/html/body/section/div/table[1]/tbody/tr[5]/td[2]");
	By checkCheckOut = By.xpath("/html/body/section/div/table[1]/tbody/tr[6]/td[2]");
	By checkDeposit = By.xpath("/html/body/section/div/table[2]/tbody/tr/td[1]");
	By checkTaxVat = By.xpath("/html/body/section/div/table[2]/tbody/tr/td[2]");
	By checkTotalAmount = By.xpath("/html/body/section/div/table[2]/tbody/tr/td[3]");
	
	public InvoiceDetailsPageObject(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void closePage() {
		this.driver.quit();
	}

	public boolean checkInvoiceDetails(String text) {
		try {
			return driver.getPageSource().contains(text);
		}
		catch (Exception e) {
			return false;
		}
	}

	public String checkTotalStayCount() {
		return driver.findElement(totalStayCount).getText();
	}

	public String checkTotalStayAmount() {
		return driver.findElement(totalStayAmount).getText();
	}

	public String checkCheckIn() {
		return driver.findElement(checkCheckIn).getText();
	}

	public String checkCheckOut() {
		return driver.findElement(checkCheckOut).getText();
	}

	public String checkDeposit() {
		return driver.findElement(checkDeposit).getText();
	}

	public String checkTaxVat() {
		return driver.findElement(checkTaxVat).getText();
	}

	public String checkTotalAmount() {
		return driver.findElement(checkTotalAmount).getText();
	}
	
	
}
