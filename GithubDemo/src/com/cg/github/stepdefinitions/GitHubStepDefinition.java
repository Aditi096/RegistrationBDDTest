package com.cg.github.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.github.pagebeans.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GitHubStepDefinition {
	private WebDriver driver;
	private LoginPage loginPage;
	@Before
	public void setUpStepEnv() {
		System.setProperty("webdriver.chrome.driver", "D:\\BDDCucumberSelenium\\chromedriver.exe");
	}
	@Given("^User is on Github Login Page$")
	public void user_is_on_Github_Login_Page() throws Throwable {
		driver = new ChromeDriver();
		driver.get("https://github.com/login");
		loginPage=PageFactory.initElements(driver,LoginPage.class);
	}

	@When("^User enter invalid username and password$")
	public void user_enter_invalid_username_and_password() throws Throwable {
		loginPage.setUsername("Aditi096");
		loginPage.setPassword("abcd");
		loginPage.clickSignIn();
	}

	@Then("^'Incorrect Username and Password' Message should display$")
	public void incorrect_Username_and_Password_Message_should_display() throws Throwable {
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, loginPage.getActualErrorMesssage());
	}

	@When("^User enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
		loginPage.setUsername("Aditi096");
		loginPage.setPassword("$#@!");
		loginPage.clickSignIn();
	}

	@Then("^User should successfullt signin on his his Github account$")
	public void user_should_successfullt_signin_on_his_his_Github_account() throws Throwable {
		String actualTitle = driver.getTitle();
	    String expectedTitle = "Aditi096";
	    Assert.assertEquals(expectedTitle, actualTitle);
	}
	@After
	public void tearDownStepEnv() {
		driver.close();
	}
}
