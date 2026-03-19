package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

public class ScreenShotUtil {

	public static String getScreenShot() {

		WebDriver driver = DriverFactory.getDriver(); // ✅ always fresh driver

		if (driver == null) {
			System.out.println("Driver is null");
			return null;
		}

		String projectPath = System.getProperty("user.dir");
		String date = DatePattern.getDate();

		String screenshotDir = projectPath + "\\screenshots\\";
		File dir = new File(screenshotDir);

		if (!dir.exists()) {
			dir.mkdirs(); // ✅ create folder
		}

		String filePath = screenshotDir + date + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}
}