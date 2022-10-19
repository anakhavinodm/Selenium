package Selenium.Activity;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.DashBoard;
import pageObject.HomePage;
import pageObject.LoginPage;


public class ToolsQA {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/qbuser/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/books");

		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		DashBoard dashboard = new DashBoard(driver);

		login.enterLogin();
		Thread.sleep(3000);

		login.enterUsername("anakhavinodm");
		login.enterPassword("anakha@123");

		login.clickLogin();
		Thread.sleep(3000);

		System.out.println("The page heading is --- " + dashboard.getHeading());

		dashboard.clickLogout();

		driver.quit();

	}

}
