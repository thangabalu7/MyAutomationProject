package Demo.frames;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Browser {
    WebDriver driver;
	public Browser(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='menu-list']/li/span[text()='Browser Windows']")
	WebElement brows;
	@FindBy(css="div[id='tabButtonWrapper'] button")
	WebElement newTab;
	@FindBy(xpath="//html/body/h1")
	WebElement samplePage;
	public void windows() throws InterruptedException
	{
		Thread.sleep(1000);
		brows.click();
		Thread.sleep(5000);
		newTab.click();
		String tab=driver.getWindowHandle();
		driver.switchTo().window(tab);
		System.out.println("New Tab : "+samplePage.getText());
		driver.close();
		driver.switchTo().defaultContent();
	}

}
