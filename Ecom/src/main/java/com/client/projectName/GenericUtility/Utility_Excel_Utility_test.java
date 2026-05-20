package com.client.projectName.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility_Excel_Utility_test {
	
 public String getDataFromExcel(String sh, int row, int cell) throws EncryptedDocumentException, IOException {
	 
	 FileInputStream fis = new FileInputStream("./Test_Data/Project_Data_Amazon.xlsx");
		
	 Workbook wb = WorkbookFactory.create(fis);

	 String data = wb.getSheet(sh).getRow(row).getCell(cell).toString();
		
	 wb.close();
	return data;
	
}
}
