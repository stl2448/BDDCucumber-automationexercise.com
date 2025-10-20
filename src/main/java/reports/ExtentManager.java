package reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.DatePattern;

public class ExtentManager {
	private static ExtentReports reports;

	public static ExtentReports getReports() {
		if (reports == null) {
			reports = new ExtentReports();
			String date = DatePattern.getDate();
			String projectPath = System.getProperty("user.dir");
			File filePath = new File(projectPath + "\\reports\\" + date + ".html");
			ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
			reporter.config().setDocumentTitle("Test Reports doc Title");
			reporter.config().setReportName("Test Reports report name");
			reports.attachReporter(reporter);
		}
		return reports;
	}

}
