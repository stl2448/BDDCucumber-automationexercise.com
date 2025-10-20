package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

public class ScreenShotUtil {

	private static WebDriver driver = DriverFactory.getDriver();

	public static String getScreenShot() {
		
		if(driver==null) 
		{
			System.out.println("Driver is null");
			return null;
		}
		String date = DatePattern.getDate();
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath + "\\screenshots\\" + date + ".png";
		File file = new File(filePath);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filePath;
	}
}
