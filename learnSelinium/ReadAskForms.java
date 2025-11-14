package learnSelinium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAskForms {

public static String[][] readData(File file) throws IOException{
	    FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		int rowNum = sheet.getLastRowNum()+1;
		int cellNum = row.getLastCellNum();
		//int totalRows = 0;
		//String[][] data = new String[rowNum][cellNum];
		String[][] data = new String[rowNum][cellNum];
		for(int i=0;i<rowNum;i++) {
		
			for(int j=0;j<cellNum;j++) {
				XSSFCell valObj = sheet.getRow(i).getCell(j);
				String alldata = null;
				//if(valObj!=null) {
				if(valObj==null || valObj.getCellType()== CellType.BLANK) {
					alldata ="";
				}else {
					alldata = valObj.getStringCellValue();
				}
				//sheet.getRow(i).getCell(j).getStringCellValue();
				data[i][j] = alldata;
		
			}
		}
		book.close();
		return data;
	}
	

	         
	   
	
	
	
	
	
	
	}
	

