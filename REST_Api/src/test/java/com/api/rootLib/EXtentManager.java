package com.api.rootLib;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.*;;

public class EXtentManager {
	private static final String ReportFilePath = null;
	private static ExtentReports extent;
	private static String reportFileName = "Test-Execution.Repoert" + "html";

	public static ExtentReports getInstance() {
		if (extent == null)
		createInstance();
		return extent;
	}

	public static ExtentReports createInstance() {
		Date d = new Date();
		String currentTime = d.toString();
		currentTime.replaceAll("", " ").replaceAll(":", " ");

		reportFileName = reportFileName + currentTime;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./src/TestReport/test-report" + currentTime + ".html");

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat("EEEE,mmmm dd,yyyy,hh:mm a'('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("os", "windows");
		extent.setSystemInfo("Author", "subham");
		return extent;
	}
}
