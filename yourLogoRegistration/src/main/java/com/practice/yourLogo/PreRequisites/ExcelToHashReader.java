package com.practice.yourLogo.PreRequisites;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashReader {
	
	public String excelPath = "/YourLogoTestData.xlsx";
	public String excelSheet = "TestData";
	public HashMap<String, String> elemLocators = null;
	public HashMap<String, String> dataLocators = null;
	
	public HashMap<String,String> getElemLocators(){
			InputStream fis = Thread.currentThread().getClass().getResourceAsStream(excelPath);
			XSSFWorkbook wb;
			try {
				wb = new XSSFWorkbook(fis);
				XSSFSheet ws = wb.getSheet(excelSheet);
				
				int rowCnt = ws.getLastRowNum() + 1;
				int idCol = 1;
				
				HashMap<String,String> dataHandler = new HashMap<String,String>();
				elemLocators = populateHashMap(rowCnt,idCol,ws,dataHandler);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return elemLocators;

	}
	
	public HashMap<String,String> getDataLocators(String idCol){
			InputStream fis = Thread.currentThread().getClass().getResourceAsStream(excelPath);
			XSSFWorkbook wb;
			try {
				wb = new XSSFWorkbook(fis);
				XSSFSheet ws = wb.getSheet(excelSheet);
				int rowCnt = ws.getLastRowNum() + 1;
				XSSFRow row = ws.getRow(0);
				int colCnt = row.getLastCellNum();
				int colId = 0;
				for (int i=0 ; i<colCnt ; i++){
					XSSFCell colIdCell = row.getCell(i);
					if (colIdCell!=null){
						String colIdData = cellToString(colIdCell);
						if(colIdData.equals(idCol)){
							colId=i;
							break;
						}
					}
				}
				HashMap<String,String> dataHandler = new HashMap<String,String>();
				dataLocators = populateHashMap(rowCnt,colId,ws,dataHandler);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				return dataLocators;
	}
	
	private HashMap<String,String> populateHashMap(int rowCnt, int idCol, XSSFSheet sh, HashMap<String,String> dataHandler){
			for (int i=0 ; i<rowCnt ; i++){
				XSSFRow row = sh.getRow(i);
				XSSFCell hashKeyCell = row.getCell(0);
				if (hashKeyCell!=null){
					String hashKey = cellToString(hashKeyCell);
					if(!((hashKey.trim()).equals("BLNKCELL")) && (hashKey.trim()!="")){
							XSSFCell hashValCell = row.getCell(idCol);
							if(hashValCell!=null){
								String hashVal = cellToString(hashValCell);
							dataHandler.put(hashKey, hashVal);
							}
					}
				}
			}
			return dataHandler;
	}
	
	private String cellToString(XSSFCell cellData){
		int cellType = cellData.getCellType();
		Object cellBuffData;
		switch(cellType){
			case 0 : 
				cellBuffData = cellData.getNumericCellValue();
				break;
			case 1 :
				cellBuffData = cellData.getStringCellValue();
				break;
			default :
				cellBuffData = "BLNKCELL";
		}
		
		return cellBuffData.toString();
	}

}

