package DemoBlaze;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TCPDP002 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("https://www.demoblaze.com/index.html");
	}
	
	@Test (priority = 1)
	public void signIn() throws InterruptedException {
		String username = "Rahmad";
		String password = "Rah";
        driver.findElement(By.linkText("Log in")).click();
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#loginusername")));
        user.sendKeys(username);
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#loginpassword")));
		pass.sendKeys(password);
		driver.findElement(By.xpath("//div[@id='logInModal']/div[@role='document']//div[@class='modal-footer']/button[2]")).click();
		
		Thread.sleep(5000);
		
		String nameOfUser = driver.findElement(By.id("nameofuser")).getText();
		if(nameOfUser.contains("username")) {
			System.out.print("Login Successfully");
		}
		
	}
	
	@Test (priority = 2)
	public void homePage() {
		List<WebElement> listOfProduct = driver.findElements(By.xpath("//a[@class='hrefch']"));
		for(WebElement nameOfProduct : listOfProduct) {
			System.out.println(nameOfProduct.getText());
		}
	}
	
	@Test (priority = 3)
	public void laptopCategories() throws InterruptedException {
		driver.findElement(By.cssSelector(".list-group > a:nth-of-type(3)")).click();
		Thread.sleep(3000);
		
		List<WebElement> listOfProduct = driver.findElements(By.xpath("//a[@class='hrefch']"));
		for(WebElement nameOfProduct : listOfProduct) {
			System.out.println(nameOfProduct.getText());
		}
	}
	
	@Test (priority = 4)
	public void detailProduct() throws InterruptedException {
		WebElement nameOfProduct = driver.findElement(By.linkText("MacBook Pro"));
		String name = nameOfProduct.getText();
		nameOfProduct.click();
		Thread.sleep(5000);
		WebElement pdpName = driver.findElement(By.cssSelector("div#tbodyid > .name"));
		String detailName = pdpName.getText();
		WebElement pdpPrice = driver.findElement(By.cssSelector("div#tbodyid > .price-container"));
		String detailPrice = pdpPrice.getText();
		WebElement pdpDesc = driver.findElement(By.cssSelector("div#more-information > p"));
		String detailDesc = pdpDesc.getText();
		
		Assert.assertEquals(name, detailName);
	}

  @AfterSuite
  public void end() {
	  driver.quit();
  }
}
