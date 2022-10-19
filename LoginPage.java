package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By lgn = By.id("login");
	By uName = By.id("userName");
	By pswd = By.id("password");
	By loginBtn = By.id("login");

	public void enterLogin() {
		driver.findElement(lgn).click();
	}

	public void enterUsername(String user) {
		driver.findElement(uName).sendKeys(user);
	}

	public void enterPassword(String pass) {
		driver.findElement(pswd).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();

	}

}

