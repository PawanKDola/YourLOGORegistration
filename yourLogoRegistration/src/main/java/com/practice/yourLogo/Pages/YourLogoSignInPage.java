package com.practice.yourLogo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.yourLogo.PreRequisites.SelectBy;
import com.practice.yourLogo.PreRequisites.WebElemRepository;

public class YourLogoSignInPage extends YourLogoPageBase{
	
	public WebElement signInBtnFn;
	
	public YourLogoSignInPage(WebDriver driver){
			this.driver = driver;
			
			signInBtnFn = getWebElement(WebElemRepository.signInBtnFn, SelectBy.cssSelector);
	}

}
