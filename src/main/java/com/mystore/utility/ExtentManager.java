package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"Report.html");
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "SeleniumEcommerceProject");
		extent.setSystemInfo("Tester", "HuuDoann");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Edge");
		
	}
	
	public static void endReport() {
		extent.flush();
	}
}
