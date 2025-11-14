package learnArray;


	import java.io.IOException;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ReadTwoDimen {

	    public static Object[][] readData() throws IOException {
	        XSSFWorkbook book = new XSSFWorkbook("./Data/fielddetailsAsk.xlsx");

	        // Read data for sheet1 (row-wise)
	        XSSFSheet sheet1 = book.getSheetAt(0);
	        int rowNum1 = sheet1.getLastRowNum() + 1;
	        Object[][] sheet1Data = new Object[rowNum1 - 1][2]; // Assuming 2 columns
	        for (int i = 1; i < rowNum1; i++) {
	            XSSFRow row = sheet1.getRow(i);
	            if (row != null) {
	                XSSFCell cell1 = row.getCell(0);
	                XSSFCell cell2 = row.getCell(1);
	                sheet1Data[i - 1][0] = cell1 != null ? cell1.getStringCellValue() : "";
	                sheet1Data[i - 1][1] = cell2 != null ? cell2.getStringCellValue() : "";
	            }
	        }

	        // Read data for sheet2 (column-wise)
	        XSSFSheet sheet2 = book.getSheetAt(1);
	        int rowNum2 = sheet2.getLastRowNum() + 1;
	        int colNum2 = 2; // Assuming 2 columns
	        Object[][] sheet2Data = new Object[colNum2][rowNum2 - 1];
	        for (int i = 1; i < rowNum2; i++) {
	            XSSFRow row = sheet2.getRow(i);
	            if (row != null) {
	                for (int j = 0; j < colNum2; j++) {
	                    XSSFCell cell = row.getCell(j);
	                    sheet2Data[j][i - 1] = cell != null ? cell.getStringCellValue() : "";
	                }
	            }
	        }

	        // Read data for sheet3 (column-wise)
	        XSSFSheet sheet3 = book.getSheetAt(2);
	        int rowNum3 = sheet3.getLastRowNum() + 1;
	        Object[][] sheet3Data = new Object[rowNum3 - 1][1]; // Assuming 1 column
	        for (int i = 1; i < rowNum3; i++) {
	            XSSFRow row = sheet3.getRow(i);
	            if (row != null) {
	                XSSFCell cell = row.getCell(0);
	                sheet3Data[i - 1][0] = cell != null ? cell.getStringCellValue() : "";
	            }
	        }

	        book.close();

	        return new Object[][] { sheet1Data, sheet2Data, sheet3Data };
	    }
	}

	
	

