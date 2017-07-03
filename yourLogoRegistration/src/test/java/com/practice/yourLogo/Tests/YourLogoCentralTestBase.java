package com.practice.yourLogo.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.practice.yourLogo.Pages.YourLogoCommOps;
import com.practice.yourLogo.Pages.YourLogoRegistrationPage;
import com.practice.yourLogo.Pages.YourLogoSignInPage;


public class YourLogoCentralTestBase extends YourLogoTestBase {
	
	public YourLogoCommOps ylCommOps;
	public YourLogoSignInPage ylSignInPg;
	public YourLogoRegistrationPage ylRegPg;
		
	@BeforeClass
	@Parameters({"idCol"})
	public void instantiatePageObjects(String idCol){
			
			ylCommOps = new YourLogoCommOps(idCol);
			ylSignInPg = new YourLogoSignInPage(driver);
			ylRegPg = new YourLogoRegistrationPage(driver);
	}

}
