package com.practice.yourLogo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
	public static void main(String[] Args){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("a[class='login']")).click();
		driver.findElement(By.cssSelector("input[id='email_create']")).sendKeys("Sample");
	}
}
