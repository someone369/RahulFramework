package MallulaAcadamypageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mallulaAcadamyAbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submitButton;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errorMessage;
	

	public ProductcatalogPage loginApplication(String username, String password) {
		useremail.sendKeys(username);
		userPassword.sendKeys(password);
		submitButton.click();
		ProductcatalogPage pcPage = new ProductcatalogPage(driver);
		return pcPage;
	}
	
	public String getErrorMesg() {
		visableWebelement(errorMessage);
		return errorMessage.getText();
	}
	public void goTo_Env() {
		
		driver.get("https://www.rahulshettyacademy.com/client/");

	}
}
