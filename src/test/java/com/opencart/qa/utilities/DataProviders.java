package com.opencart.qa.utilities;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws Exception {
		String path = "C:\\Users\\Rawat\\eclipse-workspace\\Open-Cart-Automation\\test-data\\login-data.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		Object[][] data = new Object[totalrows][totalcols];
		
		for(int i = 1;i<=totalrows;i++) {
			for(int j = 0;j<totalcols;j++) {
				data[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}
	
	public HashMap<String, String> mapData() throws Exception {
		String path = "C:\\Users\\Rawat\\eclipse-workspace\\Open-Cart-Automation\\test-data\\signup-data.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i = 2;i<=totalrows;i++) {
			map.put(xlutil.getCellData("Sheet1", i, 0),xlutil.getCellData("Sheet1", i, 1));
		}
		return map;
	}
}
