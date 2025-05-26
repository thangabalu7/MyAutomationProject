package Demo.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFrameClass {

	WebDriver driver;

	public NestedFrameClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public NestedFrameClass() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div[class='element-list collapse show'] ul li:nth-of-type(4)")
	WebElement nastedFrame;
	@FindBy(css = "div[class='element-list collapse show'] ul li:nth-of-type(3)")
	WebElement frame;

	public Frame nestedFrames() throws InterruptedException {
		nastedFrame.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		WebElement e = driver.findElement(By.xpath("/html/body/iframe"));
		driver.switchTo().frame(e);
		System.out.println(driver.findElement(By.xpath("//p[normalize-space()='Child Iframe']")).getText()
				.equalsIgnoreCase("Parent Frame"));
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		frame.click();
		 System.out.println("---Successfully handled NestedFrame---");
		return new Frame(driver);

	}
}
