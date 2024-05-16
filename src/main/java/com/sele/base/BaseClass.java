package com.sele.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sele.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		//Get Driver from threadLocalMap
		return driver.get();
	}
	
	@Parameters("browser")
	public void launchApp(String browserName) {
		
		if (prop == null) {
	        System.out.println("prop is not initialized. loadConfig() method might not have been called.");
	        return; // Nếu prop chưa được khởi tạo, thoát khỏi phương thức để tránh lỗi
	    }

		if (browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());	
			
		} else if (browserName.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver.set( new EdgeDriver());
			
		} 
//		else if (browserName.equalsIgnoreCase("Firefox")) {
//			
//			WebDriverManager.firefoxdriver().setup();
//			driver.set(new FirefoxDriver());
//			
//		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite(groups = { "Smoke", "Sanity", "Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
