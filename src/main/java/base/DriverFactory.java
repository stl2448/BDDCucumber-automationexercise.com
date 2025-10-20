package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static void initializeBrowser() {
		String browserName = ConfigReader.getProperty("browser").toLowerCase();
		if (browserName == null) {
			browserName = "chrome";
		}
		switch (browserName) {
		case "chrome": {
			WebDriver driver = new ChromeDriver();
			tlDriver.set(driver);
			break;
		}
		case "firefox": {
			WebDriver driver = new FirefoxDriver();
			tlDriver.set(driver);
			break;
		}
		case "edge": {
			WebDriver driver = new EdgeDriver();
			tlDriver.set(driver);
			break;
		}
		default:
			WebDriver driver = new ChromeDriver();
			tlDriver.set(driver);
			break;
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicit"))));
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitBrowser() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			tlDriver.remove();
		}

	}
}
