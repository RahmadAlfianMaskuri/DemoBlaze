package DemoBlaze;

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

public class TCLOGIN002 {
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
	public void signIn() throws InterruptedException {
		String username = "Rahmad";
		String password = "Rah";
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(3500);
		driver.findElement(By.xpath("//div[@id='logInModal']/div[@role='document']//div[@class='modal-footer']/button[2]")).click();
		Thread.sleep(5000);
		
		String textAlert = driver.switchTo().alert().getText();
		System.out.print(textAlert);
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(textAlert, "Please fill out Username and Password.");
		Thread.sleep(5000);
		
	}

  @AfterSuite
  public void end() {
	  driver.quit();
  }
}
