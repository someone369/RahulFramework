package MallulaAcadamypageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mallulaAcadamyAbstractComponents.AbstractComponent;

public class ProductcatalogPage extends AbstractComponent {
	
	WebDriver driver;

	public ProductcatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	By productslist = By.cssSelector(".mb-3");
	By selectedproduct = By.cssSelector("button.btn.w-10.rounded");
	By animation = By.cssSelector(".ng-animating");
	By tostElement = By.cssSelector("div#toast-container");
	
	public List<WebElement> getProductsList() {
		visibilityOfByLocator(productslist);
		return products;
	}
	
	public WebElement findElementByProductName(String productName) {
		WebElement item = getProductsList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return item;
	}
	
	public KartPage addProductToKart(String productName) throws InterruptedException {
		findElementByProductName(productName).findElement(selectedproduct).click();
		KartPage kartp = new KartPage(driver);
		Thread.sleep(3000);
		return kartp;
	}
	
	public OrdersPage gotoOrdersPage() {
		ordersButton.click();
		OrdersPage opg = new OrdersPage(driver);
		return opg;
	}
	

}
