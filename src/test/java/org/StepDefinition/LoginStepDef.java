package org.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginStepDef {
	WebDriver driver;

	@Given("Launch the FacebookURL")
	public void launchTheFacebookURL() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}

	@When("User enter valid username and password")
	public void userEnterValidUsernameAndPassword() {

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("a.n.swathyraj@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("Marriage@11");

	}

	@When("User enter Invalid username and Invalid password")
	public void userEnterInvalidUsernameAndInvalidPassword() {
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("python123@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("python123");
		
	}

	@When("Click login button")
	public void clickLoginButton() {

		driver.findElement(By.name("login")).click();
	}

	@Then("User should be in homepage of the facebook")
	public void userShouldBeInHomepageOfTheFacebook() {

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("Validate the URL", currentUrl.contains("https://www.facebook.com/"));
		driver.quit();
	}
	
	
	@Then("User should be in invalid credential page")
	public void userShouldBeInInvalidCredentialPage() {
	    
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue("Validate the URL", currentUrl.contains("https://www.facebook.com/login/?privacy_mutation_token"));
		driver.quit();
	}
	
	@When("click the forgotton password")
	public void clickTheForgottonPassword() {
	   driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
	       
	}

	@When("User enter the MobileNo")
	public void userEnterTheMobileNo() {
	   
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("8835455156");
	    
	}

	@Then("User click the search button")
	public void userClickTheSearchButton() {
	   
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	    
	}
	}
