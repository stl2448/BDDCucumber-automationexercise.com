package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePattern {

	public static String getDate() 
	{
		Date newDate = new Date();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String date = dateFormat.format(newDate);
		date = date.replace(":", "-");
		return date;
		
	}
}
