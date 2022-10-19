package cucumberTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	public static WebDriver driver;


	@Given("User is on HomePage")
	public void user_is_on_HomePage() {
		System.setProperty("webdriver.chrome.driver", "/home/qbuser/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/books");


	}

	@When("User clicks on login")
	public void user_clicks_on_login() {
		driver.findElement(By.id("login")).click();

	}
	@Then("Login page open")
	public void login_page_open() throws InterruptedException {
		driver.get("https://demoqa.com/login");


	}

	@Given("I want to login with valid credentials")
	public void login_with_valid_credentials() throws InterruptedException {
		driver.get("https://demoqa.com/login");
		Thread.sleep(3000);
	}

	@When("I enter username as {string} and password as {string}")
	public void Enter_username_password(String username, String password) {
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	@Then("I should be able to login sucessfully and new page open")
	public void Login_Successful() {
		System.out.println(driver.findElement(By.cssSelector("label[id='userName-value123']")).getText());
	}

	@Then("Logout")
	public void logout() {
		driver.findElement(By.id("submit")).click();


	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("hi");
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "report.html"); // ... and embed it in the report.
			driver.quit();
		}
	}

}
