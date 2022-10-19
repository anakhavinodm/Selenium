package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng {
	WebDriver driver;

	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "/home/qbuser/Downloads/chromedriver");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void openBrowser() {
		driver.get("https://demoqa.com/books");
		System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
	}

	@Test
	public void login() throws InterruptedException {

		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("userName")).sendKeys("anakhavinodm");
		driver.findElement(By.id("password")).sendKeys("anakha@123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
	}

	@Test
	public void logout() {
		driver.findElement(By.id("submit")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
