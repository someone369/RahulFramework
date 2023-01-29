package MallulaAcadamytests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import MallulaAcadamypageObjects.KartPage;
import MallulaAcadamypageObjects.OrderDetailsPage;
import MallulaAcadamypageObjects.PaymentPage;
import MallulaAcadamypageObjects.ProductcatalogPage;
import testComponents.BaseTest;
import testComponents.Retry;

public class ErrorValidationTest extends BaseTest{
	@Test(groups = {"ErrorHandle"}, retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
		
		landpag.loginApplication("useforoverall@gmail.com", "Ap39ky495");
		Assert.assertEquals("Incorrect email password.", landpag.getErrorMesg());
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException, IOException {
		String productName = "ADIDAS ORIGINAL";
		String countryName = "India";

		ProductcatalogPage pcPage = landpag.loginApplication("useforoverall@gmail.com", "Ap39ky4995");

		//List<WebElement> itemList = pcPage.getProductsList();

		KartPage kartp = pcPage.addProductToKart(productName);

		boolean Status = kartp.validateKartforAddedProducts("Wrong product");
		Assert.assertTrue(Status);
	}

}
