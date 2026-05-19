package com.client.projectName.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility_File_Utility_test {
	
	public String  getDataFromPropertiesFile(String Key) throws IOException {
		
		FileInputStream fis =new FileInputStream("./Test_Data/CommanData_Amazon.properties");
		
		Properties pOj = new Properties();
		pOj.load(fis);
		String data = pOj.getProperty(Key);
		return data;
		
	}

}
