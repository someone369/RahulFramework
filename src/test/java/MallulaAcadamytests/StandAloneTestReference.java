package MallulaAcadamytests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestReference {
		@Test
		public void test() throws InterruptedException {
			String productName = "ADIDAS ORIGINAL";
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.rahulshettyacademy.com/client/");
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
			
			driver.findElement(By.id("userEmail")).sendKeys("useforoverall@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Ap39ky4995");
			driver.findElement(By.id("login")).click();
			//System.out.println(driver.findElement(By.cssSelector(".mb-3")).getText());
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
			List<WebElement> itemList = driver.findElements(By.cssSelector(".mb-3"));
			
			WebElement item = itemList.stream().filter(s->s.findElement(By.cssSelector("b")).
					getText().equals(productName)).findFirst().orElse(null);
			
			item.findElement(By.cssSelector("button.btn.w-10.rounded")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#toast-container"))));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

			
			WebElement kartButton = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
			wait.until(ExpectedConditions.elementToBeClickable(kartButton));
			kartButton.click();
			WebElement continShop = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
			wait.until(ExpectedConditions.elementToBeClickable(continShop));
			
			List<WebElement> itemsInKart = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
			if(itemsInKart.size()==1) {
			boolean ststusofItem = itemsInKart.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(ststusofItem, productName);
			}else {
				System.out.println("Number of items in the kart is not mathed with number of items added");
			}
			
			
			driver.findElement(By.xpath("//button[text()='Checkout']")).click();
			WebElement placeOrderButton = driver.findElement(By.xpath("//a[text()='Place Order ']"));
			wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
			WebElement countryInput = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
			//ountryInput.sendKeys("India");
			
			Actions act =new Actions(driver);
			act.sendKeys(countryInput, "India").build().perform();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("section.ta-results"))));
			driver.findElement(By.xpath("//button[@type='button'][2]")).click();
			placeOrderButton.click();
			WebElement downloadOrderButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
			wait.until(ExpectedConditions.elementToBeClickable(downloadOrderButton));	
			
			driver.close();
		}

}
