package MallulaAcadamypageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mallulaAcadamyAbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	@FindBy(xpath = "//h1")
	WebElement yourOrdersHeader;
	
	@FindBy(xpath = "//tbody//tr/td[2]")
	List<WebElement> itemsList;
	
	public boolean verifyOrders(String productname) {
		ordersButton.click();
		visableWebelement(yourOrdersHeader);
		boolean status = itemsList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		return status;
		
	}
	
	
	  public OrdersPage gotoOrdersPage() { ordersButton.click();
	  visableWebelement(yourOrdersHeader); OrdersPage opg = new OrdersPage(driver);
	  return opg; }
	 

}
