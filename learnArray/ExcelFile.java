package learnArray;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	 public static void main(String[] args) throws IOException {
	        XSSFWorkbook book =  new XSSFWorkbook("/home/rajalakshmi/Documents/logintest1.xlsx");;
	        XSSFSheet sheet = book.getSheetAt(0);
	        XSSFRow row = sheet.getRow(1);
	        int rowLength = sheet.getLastRowNum();
	        int colLength = row.getLastCellNum();
	        for(int i=1; i<=rowLength; i++){
	            for(int j=0; j<colLength; j++){
	                String data = sheet.getRow(i).getCell(j).getStringCellValue();
	                System.out.println("Data: "+data);
	            }
	        }
	        
	        book.close();
}
	 
}
