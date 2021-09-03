package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumHepler;

public class WomenPage {

	WebDriver driver;

	public WomenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#homefeatured>li")
	List<WebElement> allProducts;

	public void clicksOnAllProducts() {
		SeleniumHepler.click(driver, allProducts);

	}

}
