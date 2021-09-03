package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHepler {

	public static void verifyLogo(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("Eelement is varified");

		} else {
			System.out.println("Can not verify the element");
		}

	}

	public static void type(WebElement element, String text) {
		element.sendKeys(text);

	}

	public static void click(WebElement element) {
		element.click();

	}

	public static void verifyTheSearchResult(WebElement element, String text) {
		if (element.getText().contains(text)) {
			System.out.println("Search Result is verified");
		} else {
			System.out.println("Umexpected result");
		}

	}

	public static void verifyThePage(WebDriver driver, String givenText) {
		if (driver.getTitle().equals(givenText)) {
			System.out.println("Page is verified");

		} else {
			System.out.println("Can not verify the page");
		}

	}

	public static Properties readProperties(String path) throws IOException {
		FileInputStream file = new FileInputStream(new File(path));
		Properties properties = new Properties();
		properties.load(file);
		return properties;

	}

	public static void click(WebDriver driver, List<WebElement> elements) {
		for (WebElement element : elements) {
			element.click();
			driver.navigate().back();
			driver.navigate().refresh();
		}

	}

}
