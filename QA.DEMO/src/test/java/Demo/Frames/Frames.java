package Demo.Frames;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Demo.HomePage.HomePage;
import Demo.ReusableFuction.DriverSetupClass;
import Demo.frames.Alerts;
import Demo.frames.Browser;
import Demo.frames.Frame;
import Demo.frames.NestedFrameClass;

public class Frames extends DriverSetupClass {

	

	@Test
	public void mainFramesDriver() throws InterruptedException
	{
	HomePage home = new HomePage(driver);
	NestedFrameClass nfc = home.frameTiles("Alerts, Frame & Windows");
	Frame frm =nfc.nestedFrames();
	Thread.sleep(3000);
	Alerts alst = frm.farmesFrm();
	Thread.sleep(3000);
	alst.alerts();
	
	}

}
