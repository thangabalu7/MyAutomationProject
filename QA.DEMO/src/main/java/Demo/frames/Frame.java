package Demo.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Frame {

	WebDriver driver;

	public Frame(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='element-list collapse show'] ul li:nth-of-type(2)")
	WebElement alert;

	public Alerts farmesFrm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.xpath("/html/body/h1")).getText());
		driver.switchTo().defaultContent();
		js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame("frame2");
		System.out.println(driver.findElement(By.xpath("/html/body/h1")).getText());
		driver.switchTo().defaultContent();
		alert.click();
		 System.out.println("---Successfully handled Frame---");
		return new Alerts(driver);

	}

}
