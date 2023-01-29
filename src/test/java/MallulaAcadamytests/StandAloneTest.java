package MallulaAcadamytests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MallulaAcadamypageObjects.KartPage;
import MallulaAcadamypageObjects.OrderDetailsPage;
import MallulaAcadamypageObjects.OrdersPage;
import MallulaAcadamypageObjects.PaymentPage;
import MallulaAcadamypageObjects.ProductcatalogPage;
import testComponents.BaseTest;

public class StandAloneTest extends BaseTest{
	String product_Name = "ADIDAS ORIGINAL";

	@Test(dataProvider = "dataSets", groups = "purchaseOrder")
	public void test(String usename, String password, String productName) throws InterruptedException, IOException {
		String countryName = "India";

		ProductcatalogPage pcPage = landpag.loginApplication(usename, password);

		//List<WebElement> itemList = pcPage.getProductsList();

		KartPage kartp = pcPage.addProductToKart(productName);

		boolean Status = kartp.validateKartforAddedProducts(productName);
		Assert.assertTrue(Status);
		PaymentPage pp = kartp.gotoCkeckout();

		//PaymentPage pp = new PaymentPage(driver);
		OrderDetailsPage odp = pp.addpaymentsAndOrder(countryName);

		//OrderDetailsPage odp = new OrderDetailsPage(driver);
		odp.verifyNavigatedToOrdersPage();

	}
	//@Test(dependsOnMethods = {"test"})
	public void verifyOrderHystory() {
		ProductcatalogPage pcPage = landpag.loginApplication("useforoverall@gmail.com", "Ap39ky4995");
		OrdersPage orderspge = pcPage.gotoOrdersPage();
		orderspge.verifyOrders(product_Name);
		Assert.assertTrue(orderspge.verifyOrders(product_Name));
	}
	
	@DataProvider
	public Object[][] dataSets() {
		
		return new Object[][] {{"useforoverall@gmail.com","Ap39ky4995","ADIDAS ORIGINAL"},
								{"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"}};	
		
	}
}
