package learnArray;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YourTestClass {

    @Test(dataProvider = "setData")
    public void yourTestMethod(String[][] sheet1Data, String[][] sheet2Data, String[][] sheet3Data) {
    	
    	        // Iterate over elements of sheet1Data
    	        System.out.println("Sheet 1 Data:");
    	        for (int i = 0; i < sheet1Data.length; i++) {
    	            for (int j = 0; j < sheet1Data[i].length; j++) {
    	                String value = sheet1Data[i][j];
    	                System.out.println("Row: " + i + ", Column: " + j + ", Value: " + value);
    	                // Perform test actions using 'value'
    	            }
    	        }

    	        // Iterate over elements of sheet2Data
    	        System.out.println("Sheet 2 Data:");
    	        for (int i = 0; i < sheet2Data.length; i++) {
    	            for (int j = 0; j < sheet2Data[i].length; j++) {
    	                String value = sheet2Data[i][j];
    	                System.out.println("Row: " + i + ", Column: " + j + ", Value: " + value);
    	                // Perform test actions using 'value'
    	            }
    	        }

    	        // Iterate over elements of sheet3Data
    	        System.out.println("Sheet 3 Data:");
    	        for (int i = 0; i < sheet3Data.length; i++) {
    	            for (int j = 0; j < sheet3Data[i].length; j++) {
    	                String value = sheet3Data[i][j];
    	                System.out.println("Row: " + i + ", Column: " + j + ", Value: " + value);
    	                // Perform test actions using 'value'
    	            }
    	        }
    	    }
    	

    	
    	
    	
    

    @DataProvider
    public Object[][] setData() throws IOException {
        return ReadTwoDimen.readData();
    }
}
