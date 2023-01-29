package MallulaAcadamytests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MallulaAcadamypageObjects.KartPage;
import MallulaAcadamypageObjects.OrderDetailsPage;
import MallulaAcadamypageObjects.OrdersPage;
import MallulaAcadamypageObjects.PaymentPage;
import MallulaAcadamypageObjects.ProductcatalogPage;
import testComponents.BaseTest;

public class MakeOrder_DataProviderHashMap extends BaseTest {
	String product_Name = "ADIDAS ORIGINAL";

	@Test(dataProvider = "dataSets", groups = "OrderWithHashMap")
	public void test(HashMap<String, String> map) throws InterruptedException, IOException {
		String countryName = "India";

		ProductcatalogPage pcPage = landpag.loginApplication(map.get("username"), map.get("password"));

		// List<WebElement> itemList = pcPage.getProductsList();

		KartPage kartp = pcPage.addProductToKart(map.get("product"));

		boolean Status = kartp.validateKartforAddedProducts(map.get("product"));
		Assert.assertTrue(Status);
		kartp.gotoCkeckout();

		PaymentPage pp = new PaymentPage(driver);
		pp.addpaymentsAndOrder(countryName);

		OrderDetailsPage odp = new OrderDetailsPage(driver);
		odp.verifyNavigatedToOrdersPage();

	}

	@Test(dependsOnMethods = { "test" })
	public void verifyOrderHystory() {
		ProductcatalogPage pcPage = landpag.loginApplication("useforoverall@gmail.com", "Ap39ky4995");
		OrdersPage orderspge = pcPage.gotoOrdersPage();
		orderspge.verifyOrders(product_Name);
		Assert.assertTrue(orderspge.verifyOrders(product_Name));
	}

	@DataProvider
	public Object[][] dataSets() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "useforoverall@gmail.com");
		map.put("password", "Ap39ky4995");
		map.put("product", "ADIDAS ORIGINAL");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("username", "anshika@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "ZARA COAT 3");

		return new Object[][] { { map }, { map1 } };

	}
}
