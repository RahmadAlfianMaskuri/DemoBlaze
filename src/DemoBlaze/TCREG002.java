package DemoBlaze;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TCREG002 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("https://www.demoblaze.com/index.html");
	}
	
	@Test
	public void signUp() throws InterruptedException {
        		;
        driver.findElement(By.linkText("Sign up")).click();
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#sign-username")));
        user.sendKeys("asd");
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#sign-password")));
		pass.sendKeys("asd");
		driver.findElement(By.xpath("//div[@id='signInModal']/div[@role='document']//div[@class='modal-footer']/button[2]")).click();
		
		Thread.sleep(5000);
		String textAlert = driver.switchTo().alert().getText();
		System.out.print(textAlert);
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(textAlert, "This user already exist.");
	}

  @AfterSuite
  public void end() {
	  driver.quit();
  }
}
