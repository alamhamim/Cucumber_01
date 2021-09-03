package step_def;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import browsers.BrowserConfig;
import pages.LandingPage;
import pages.SignInPage;
import pages.WomenPage;

import io.cucumber.java.en.*;

public class Steps {
	BrowserConfig browserConfig;
	LandingPage landingPage;
	WomenPage womenPage;
	SignInPage signInPage;

	@Given("browser is open")
	public void browser_is_open(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> browserData = dataTable.asLists(String.class);
		String getBrowserName = browserData.get(0).get(0);
		browserConfig = new BrowserConfig();
		browserConfig.browserSetup(getBrowserName);

	}

	@Given("user navigate to the url")
	public void user_navigate_to_the_url() throws IOException {
		landingPage = browserConfig.navigateTo();
	}

	@When("user on the homepage and verify the search box")
	public void user_on_the_homepage_and_verify_the_search_box() {
		landingPage.verifyTheSearchBox();
	}

	@When("search something in the search box <{string}>")
	public void search_something_in_the_search_box(String string) {
		landingPage.searchSomething(string);
	}

	@Then("verify the search result")
	public void verify_the_search_result() {
		landingPage.verifyTheSearchResult();
	}

	@Then("close the browser")
	public void close_the_browser() {
		browserConfig.tearDown();
	}

	@When("verify the homepage")
	public void verify_the_homepage() {
		landingPage.verifyThePage();
	}

	@When("click on the women")
	public void click_on_the_women() {
		womenPage = landingPage.clickOnWomen();
	}

	@When("click on all the women product and go back")
	public void click_on_all_the_women_product_and_go_back() {
		womenPage.clicksOnAllProducts();
	}

	@When("verify the login logo")
	public void verify_the_login_logo() {
		landingPage.verifyTheSignInIcon();
	}

	@When("click on it")
	public void click_on_it() {
		signInPage = landingPage.clickOnSignIn();
	}

	@When("enters email address and password")
	public void enters_email_address_and_password(io.cucumber.datatable.DataTable dataTable) {
		WebDriver driver = null;
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String userName = data.get(0).get("username");
		String passWord = data.get(0).get("password");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(passWord);

	}

	@Then("click on sign in")
	public void click_on_sign_in() {

	}

	@Then("verify the error")
	public void verify_the_error() {

	}

}
