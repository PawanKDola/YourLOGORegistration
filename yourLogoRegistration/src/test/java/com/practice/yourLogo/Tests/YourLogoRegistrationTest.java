package com.practice.yourLogo.Tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class YourLogoRegistrationTest extends YourLogoCentralTestBase{
		
		
		
		@Parameters({"emailKey"})
		@Test
		public void createTestAccount(String emailKey){
				String emailId = ylCommOps.getValueFromSheet(emailKey);
				ylSignInPg.signInBtnFn.click();
				ylRegPg.emailIdFn.sendKeys(emailId);
				ylRegPg.createBtnFn.click();
		}
}
