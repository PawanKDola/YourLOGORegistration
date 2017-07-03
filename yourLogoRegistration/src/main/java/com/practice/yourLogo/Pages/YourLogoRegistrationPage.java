package com.practice.yourLogo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.yourLogo.PreRequisites.SelectBy;
import com.practice.yourLogo.PreRequisites.WebElemRepository;

public class YourLogoRegistrationPage extends YourLogoPageBase{
	
	public WebElement emailIdFn;
	public WebElement createBtnFn;
	
	public YourLogoRegistrationPage(WebDriver driver){
			this.driver = driver;
			
			emailIdFn = getWebElement(WebElemRepository.emailIdFn, SelectBy.cssSelector);
			createBtnFn = getWebElement(WebElemRepository.createBtnFn, SelectBy.cssSelector);
	}

}
