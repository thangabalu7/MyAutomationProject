package Forms;

import java.io.FileNotFoundException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Demo.ReusableFuction.JsonReaders;
import com.google.gson.stream.JsonReader;

public class PracticeForm {
     WebDriver driver;
	public PracticeForm(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='firstName']")
	WebElement name;
	
	
    @Test(dataProvider ="userData",dataProviderClass = JsonReader.class)
	public void formFilling(Map<String, String> userData)
	{
    	System.out.println("hello");
    	System.out.println("Name: " + userData.get("Name"));
        System.out.println("Last Name: " + userData.get("Last Name"));
        System.out.println("Gender: " + userData.get("Gender"));
        System.out.println("Mobile Number: " + userData.get("Mobile Number"));
        System.out.println("Subject: " + userData.get("Subject"));
        System.out.println("Hobbies: " + userData.get("Hobbies"));
        System.out.println("Address: " + userData.get("Current Address"));
        System.out.println("State: " + userData.get("State"));
        System.out.println("City: " + userData.get("City"));

	}
    
    

	

}
