package stepDefinationfiles;

import java.io.IOException;

import org.testng.Assert;

import MallulaAcadamypageObjects.KartPage;
import MallulaAcadamypageObjects.LandingPage;
import MallulaAcadamypageObjects.OrderDetailsPage;
import MallulaAcadamypageObjects.PaymentPage;
import MallulaAcadamypageObjects.ProductcatalogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.BaseTest;

public class stepdefination extends BaseTest {

	public LandingPage landingpage;

	public ProductcatalogPage pcPage;
	public KartPage kartp;
	public PaymentPage pp;
	public OrderDetailsPage odp;
	// Given navigate to the landingpage

	@Given("^navigate to the landingpage$")
	public void Given_navigate_to_the_landingpage() throws IOException {
		landingpage = launchApplication();
	}

	@Given("^login application with (.+) and (.+)$")
	public void login_with_username_and_password(String username, String password) {
		pcPage = landingpage.loginApplication(username, password);

	}
	@Given("^login applications with (.+) and (.+)$")
	public void logins_with_username_and_password(String username, String password) {
		pcPage = landingpage.loginApplication(username, password);

	}

	@When("^add the (.+) to the kart and checkout$")
	public void add_product_to_the_kart_and_ckekout(String productName) throws InterruptedException {
		kartp = pcPage.addProductToKart(productName);

		boolean Status = kartp.validateKartforAddedProducts(productName);
		Assert.assertTrue(Status);
		pp = kartp.gotoCkeckout();
	}

	@And("^add the (.+) in the paymentpage$")
	public void add_address_in_paymentPage(String address) {
		odp = pp.addpaymentsAndOrder(address);

	}

	@Then("^I verify the order in the orders page$")
	public void verify_the_order_in_orderspage() {
		odp.verifyNavigatedToOrdersPage();
		driver.close();
	}

}
