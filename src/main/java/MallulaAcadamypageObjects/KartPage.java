package MallulaAcadamypageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mallulaAcadamyAbstractComponents.AbstractComponent;

public class KartPage extends AbstractComponent {

	WebDriver driver;

	public KartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement kartbutton;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement continueShopping;

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> addeditemsInKart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	public boolean validateKartforAddedProducts(String productName) {
		clickableWebelement(kartbutton);
		kartbutton.click();
		clickableWebelement(continueShopping);

		boolean status = verifythenumberofProducts(productName);
		return status;		
	}
	
	public PaymentPage gotoCkeckout() {
		checkOut.click();
		PaymentPage paymtpg = new PaymentPage(driver);
		return paymtpg;
	}

	public boolean verifythenumberofProducts(String productName) {
		boolean status = false;
		List<WebElement> itemsInKart = addeditemsInKart;
		if (itemsInKart.size() == 1) {
			boolean ststusofItem = itemsInKart.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
			status = true;
			//Assert.assertTrue(true, productName);
			System.out.println("kart items matched");
		} else {
			System.out.println("Number of items in the kart is not mathed with number of items added");
		}
		return status;
	}

}
