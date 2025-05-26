package Demo.HomePage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Demo.frames.NestedFrameClass;

public class HomePage {

	WebDriver driver;
	public  HomePage(WebDriver driver)
	{
	 this.driver = driver;	
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='category-cards']/div[@class='card mt-4 top-card']/div//div[@class='card-body']")
	List<WebElement> tiles;
	
	public NestedFrameClass frameTiles(String tileName)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		System.out.println(1);
		tiles.stream().filter(s->s.getText().contains(tileName)).findAny().ifPresent(s->s.click());
		System.out.println(2);
		js.executeScript("window.scrollBy(0,250)");
		return new NestedFrameClass(driver);
	}

}
