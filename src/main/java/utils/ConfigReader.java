package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;
	private static FileInputStream fis;
	static 
	{
		try {
			fis=new FileInputStream("src/test/resources/Properties/config.properties");
			prop=new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Failed to load config properties");
		}
		
	}
	
	public static String getProperty(String propertyName) {
		System.out.println(prop.getProperty(propertyName));
		return prop.getProperty(propertyName);
		
		
	}
}
