package anahas.exam.invoices;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import anahas.exam.login.LoginPageObject;



public class InvoiceTestCases {
	
	//Page Object
	private InvoicePageObject invoiceDetails;
	

	//Post-test: Close browser
	@AfterEach
	public void afterEach () {
		invoiceDetails.closePage();
	}
	
	@Test
	public void checkInvoiceDetails () {
	//Step1
		//Testing variables
		String username = "demouser";
		String password = "abc123";
		//Test
		LoginPageObject loginPage = new LoginPageObject();
		loginPage.enterCredentials(username, password);
		invoiceDetails = loginPage.submitLogin();
		InvoiceDetailsPageObject invoiceList = invoiceDetails.selectInvoice();
	//Step 2 - Assertions
			//Hotel Name
			Assert.assertTrue(invoiceList.checkInvoiceDetails("Rendezvous Hotel"));
			//Invoice Number
			Assert.assertTrue(invoiceList.checkInvoiceDetails("110"));
			//Invoice Date
			Assert.assertTrue(invoiceList.checkInvoiceDetails("14/01/2018"));
			//Due date
			Assert.assertTrue(invoiceList.checkInvoiceDetails("15/01/2018"));
			//Booking Code
			Assert.assertTrue(invoiceList.checkInvoiceDetails("0875"));
			//Room
			Assert.assertTrue(invoiceList.checkInvoiceDetails("Superior Double"));
			//Customer Details - Name
			Assert.assertTrue(invoiceList.checkInvoiceDetails("JOHNY SMITH"));
			//Customer Details - Address
			Assert.assertTrue(invoiceList.checkInvoiceDetails("R2, AVENUE DU MAROC"));
			//Customer Details - Phone
			Assert.assertTrue(invoiceList.checkInvoiceDetails("123456"));
			//COMMENT: to show another possibility, I'm going to change to another
			//assertion method below.
			//Total Stay Count
			Assert.assertEquals("1", invoiceList.checkTotalStayCount());
			//Total Stay Amount
			Assert.assertEquals("$150", invoiceList.checkTotalStayAmount());
			//Check-In
			Assert.assertEquals("14/01/2018", invoiceList.checkCheckIn());
			//Check-Out
			Assert.assertEquals("15/01/2018", invoiceList.checkCheckOut());
			//Billing Details - Deposit Nowt
			Assert.assertEquals("USD $20.90", invoiceList.checkDeposit());
			//Billing Details - Tax&VAT
			Assert.assertEquals("USD $19", invoiceList.checkTaxVat());
			//Billing Details - Total Amount
			Assert.assertEquals("USD $209", invoiceList.checkTotalAmount());
			
	}
}
	
	