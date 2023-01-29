package MallulaAcadamypageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mallulaAcadamyAbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrder;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryInput;

	@FindBy(css = "section.ta-results")
	WebElement dropdownCountries;
	
	@FindBy(xpath = "//button[@type='button'][2]")
	WebElement countryindia;
	
	By selectindia = By.cssSelector("section.ta-results");

	public OrderDetailsPage addpaymentsAndOrder(String countryName) {
		clickableWebelement(placeOrder);
		WebElement countryInput = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		// ountryInput.sendKeys("India");

		Actions act = new Actions(driver);
		act.sendKeys(countryInput, countryName).build().perform();
		visibilityOfByLocator(selectindia);
		countryindia.click();
		placeOrder.click();
		OrderDetailsPage odp = new OrderDetailsPage(driver);
		return odp;
	}

	
}
