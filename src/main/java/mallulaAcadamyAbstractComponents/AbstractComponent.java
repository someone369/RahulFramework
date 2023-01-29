package mallulaAcadamyAbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	WebDriverWait wait; //= new WebDriverWait(driver, Duration.ofSeconds(5));
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void clickableWebelement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void visableWebelement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void visibilityOfByLocator(By bylocator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
	}
	
	public void invisibilityOfByLocator(By bylocator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(bylocator));
	}

}
