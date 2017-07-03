package com.practice.yourLogo.Pages;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.yourLogo.PreRequisites.WebElemRepository;

public class YourLogoPageBase 
{
		protected WebDriver driver;
		protected String idCol;
		
		
		protected void loadTestData() {
			WebElemRepository.getWebElements(idCol);
		}
		
		protected WebElement getWebElement(final String webElemProperty, final int selectBy){
			return (WebElement) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[] { WebElement.class }, new InvocationHandler() {
				private WebElement wbElement;	
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
			switch(selectBy)
			{
				case 0:
					wbElement = driver.findElement(By.id(webElemProperty));
					break;
				case 1:
					wbElement = driver.findElement(By.name(webElemProperty));							
					break;
				case 2:
					wbElement = driver.findElement(By.cssSelector(webElemProperty));
					break;
				case 3:
					wbElement = driver.findElement(By.xpath(webElemProperty));
					break;
				default:
					wbElement = null;
			}
			
			return (method).invoke(wbElement,args);
		}
		});
	}
}
