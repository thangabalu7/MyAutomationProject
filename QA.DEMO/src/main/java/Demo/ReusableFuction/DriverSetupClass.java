package Demo.ReusableFuction;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class DriverSetupClass {

	static public WebDriver driver;

	@BeforeMethod
	public void browserSteup() throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		String browsers = readDate("Browser");
		switch (browsers) {
		case "Chrome":
			driver = new ChromeDriver(options);
			System.out.println("Run by -------->" + browsers);
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Unable to Find Browser: " + browsers);

		}

		driver.get(readDate("url"));
		driver.manage().window().maximize();
		;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	public static String readDate(String resource) throws IOException {
		FileInputStream fls = new FileInputStream(
				"C:\\Users\\thangrs\\git\\MyAutomationProject\\QA.DEMO\\DateStore\\url.properties");
		Properties prop = new Properties();
		prop.load(fls);
		String datas = prop.getProperty(resource);
		return datas;
	}

	public static void waits() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.withTimeout(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
