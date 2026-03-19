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

			String reportDir = projectPath + "\\reports\\";
			File dir = new File(reportDir);

			if (!dir.exists()) {
				dir.mkdirs(); // ✅ create folder
			}

			String filePath = reportDir + date + ".html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
			reporter.config().setDocumentTitle("Automation Report");
			reporter.config().setReportName("Test Execution Report");

			reports.attachReporter(reporter);
		}

		return reports;
	}
}