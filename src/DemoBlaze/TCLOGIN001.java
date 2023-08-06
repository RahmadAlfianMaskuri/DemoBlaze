package DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TCLOGIN001 {
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

  @AfterSuite
  public void end() {
	  driver.quit();
  }
}
