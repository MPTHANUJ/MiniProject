package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="na")
	public String [][] getData() throws IOException
	{
		String path=".\\TestData\\RegData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",0);
				
		String logindata[][]=new String[1][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=0;i<1;i++)  
		{		
			for(int j=0;j<totalcols;j++)  
			{
				logindata[i][j]= xlutil.getCellData("Sheet1",i, j);  
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
