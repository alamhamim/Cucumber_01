package browsers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import pages.LandingPage;

public class BrowserConfig {

	WebDriver driver;

	public void browserSetup(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hamim\\Desktop\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hamim\\Desktop\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\Users\\Hamim\\Desktop\\driver\\operadriver.exe");
			driver = new OperaDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Hamim\\Desktop\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else {
			System.out.println("Sorry the browser name you have provided is not supported yet");
		}

//		this line of the code will maximize the browser
		driver.manage().window().maximize();
	}

	public LandingPage navigateTo() throws IOException {
		driver.get("http://automationpractice.com/index.php");
		return new LandingPage(driver);

	}

	public void tearDown() {
		driver.quit();

	}
}
