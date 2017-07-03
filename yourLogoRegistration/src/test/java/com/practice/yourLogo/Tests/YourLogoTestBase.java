package com.practice.yourLogo.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

public class YourLogoTestBase {
	
	protected WebDriver driver;
	
	@BeforeTest
	protected void setWebDriver(){
			InputStream fis = Thread.currentThread().getClass().getResourceAsStream("/Global.Properties");
			Properties prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String wbDriver = prop.getProperty("driver");
			String baseUrl = prop.getProperty("baseUrl");
			
			if (wbDriver.equalsIgnoreCase("chromeDriver")){
					driver = instantiateChromeDriver(baseUrl);
			}
			else if(wbDriver.equalsIgnoreCase("firefoxDriver")){
					driver = instantiateFirefoxDriver(baseUrl);
			}
			else
			{
					System.out.println("DriverCompatibility Mismatch");
			}
		
	}
	
	private WebDriver instantiateChromeDriver(String baseUrl){
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to(baseUrl);
			driver.navigate().refresh();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
			
	}
	
	private WebDriver instantiateFirefoxDriver(String baseUrl){
		
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.navigate().to(baseUrl);
			driver.navigate().refresh();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
		
	}
	
	@AfterClass
	public void quitDriver(){
		driver.quit();
	}
}
