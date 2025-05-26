package Demo.HomePage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Demo.frames.NestedFrameClass;

public class HomePage1 {

	
	WebDriver driver;
	public  HomePage1(WebDriver driver)
	{
	 this.driver = driver;	
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='category-cards']/div[@class='card mt-4 top-card']/div//div[@class='card-body']")
	List<WebElement> tiles;
	
	public WebDriver frameTiles(String tileName)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		tiles.stream().filter(s->s.getText().contains(tileName)).findAny().ifPresent(s->s.click());
		js.executeScript("window.scrollBy(0,500)");
		return driver;
	}


}
