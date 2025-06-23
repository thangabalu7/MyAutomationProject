package Demo.frames;

import java.util.List;
import Demo.ReusableFuction.DriverSetupClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Alerts {
   WebDriver driver;
   
	public Alerts(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div/button[@id='alertButton']")
	WebElement one;
	
	@FindBy(xpath="//div[@class='col']/button[@id='timerAlertButton']")
	WebElement two;
	@FindBy(xpath="//*[@id=\"confirmButton\"]")
	WebElement three;
	@FindBy(xpath="//*[@id=\"promtButton\"]")
	WebElement four;
	@FindBy(xpath ="div[class='col-md-6'] span:nth-child(2)")
	WebElement cancle;
	public void alerts() throws InterruptedException
	{
	  Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)");
	  one.click();
	  driver.switchTo().alert().accept();
	  two.click();
      Thread.sleep(6000);
      driver.switchTo().alert().accept();
      Thread.sleep(1000);
      js.executeScript("window.scrollBy(0,200)");
      three.click();
      driver.switchTo().alert().dismiss();
      Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-md-6']/span[2]")).getText(),"You selected Cancel");
      Thread.sleep(1000);
      js.executeScript("window.scrollBy(0,200)");
      four.click();
	  driver.switchTo().alert().sendKeys("Thangabalu");
	  driver.switchTo().alert().accept();
	  String name = driver.findElement(By.xpath("(//div[@class='mt-4 row']//div[@class='col-md-6']//span[2])[2]")).getText();
	  Assert.assertEquals(name,"You entered Thangabalu");
	  System.out.println("---Successfully handled Alert---");
	  
	}

}
