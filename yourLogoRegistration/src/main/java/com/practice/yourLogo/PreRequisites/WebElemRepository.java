package com.practice.yourLogo.PreRequisites;

import java.util.HashMap;

public class WebElemRepository {
	
	public static HashMap<String,String> elemLocs;
	public static HashMap<String,String> dataLocs;
	public static String signInBtnFn;
	public static String createBtnFn;
	public static String emailIdFn;
	
	public static void getWebElements(String idCol){
		ExcelToHashReader excelReader = new ExcelToHashReader();
		elemLocs = excelReader.getElemLocators();
		dataLocs = excelReader.getDataLocators(idCol);
		
		signInBtnFn = (String) elemLocs.get("signInBtnFn");
		createBtnFn = (String) elemLocs.get("createBtnFn");
		emailIdFn = (String) elemLocs.get("emailIdFn");

	}

}
