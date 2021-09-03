package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumHepler;

public class LandingPage {
	
	WebDriver driver;
	Properties properties;
	public LandingPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 properties = SeleniumHepler.readProperties("C:\\Users\\Hamim\\eclipse-workspace\\CucumberDemoOne\\src\\main\\resources\\landingPageData\\landingPageData.properties");
	}
	
	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
	WebElement searchLogo;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[contains(text(),'found')]")
	WebElement searchResult;
	
	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]")
	WebElement womenElement;
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInIcon;

	public void verifyThePage() {
		SeleniumHepler.verifyThePage(driver, properties.getProperty("Title"));
		
	}
	
	public void verifyTheSearchBox() {
		SeleniumHepler.verifyLogo(searchLogo);
		
	}
	
	 public void searchSomething(String textString) {
		 SeleniumHepler.type(searchBox, textString);
		 SeleniumHepler.click(searchLogo);
		
	}
	 
	 public void verifyTheSearchResult() {
		SeleniumHepler.verifyTheSearchResult(searchResult, "No");
	}
	
	 public WomenPage clickOnWomen() {
		SeleniumHepler.click(womenElement);
		return new WomenPage(driver);
	}
	 
	 public void verifyTheSignInIcon() {
		SeleniumHepler.verifyLogo(signInIcon);
	}
	 
	 public SignInPage clickOnSignIn() {
		 SeleniumHepler.click(signInIcon);
		 return new SignInPage(driver);
		
	}

}
