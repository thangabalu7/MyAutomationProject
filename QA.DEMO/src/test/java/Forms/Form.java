package Forms;

import java.io.FileNotFoundException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.gson.stream.JsonReader;

import Demo.HomePage.HomePage;
import Demo.HomePage.HomePage1;
import Demo.ReusableFuction.DriverSetupClass;
import Demo.ReusableFuction.JsonReaders;

public class Form  extends DriverSetupClass 
{

	@Test
	public void formDriver() throws FileNotFoundException
	{
		HomePage1 home = new HomePage1(driver);
		WebDriver driver1 =home.frameTiles("Forms");
		driver1.findElement(By.xpath("//span[text()='Practice Form']")).click();
		Object[][] userDataArray = JsonReaders.getUserData();
		PracticeForm  practiceFormfilling = new PracticeForm(driver1);
		for(Object[] datas : userDataArray)
		{
			Map<String,String> usetDatas = (Map<String,String>)datas[0];
			practiceFormfilling.formFilling(usetDatas);
		}
		
		
	}
	

}
