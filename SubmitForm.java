package test.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class SubmitForm {
	  //public String filePath = "./Sites/roundwell.xlsx";
	  public List<String> testResult = new ArrayList<>();
      public List<String> formResult = new ArrayList<>();
      
      private static String filePath;
      private static String chromeDriverPath;

      @BeforeClass
      @Parameters({"chromeDriverPath","filePath"})
      public void setUp(String chromeDriverPath,String filePath) {
          SubmitForm.filePath = filePath;
          SubmitForm.chromeDriverPath = chromeDriverPath;
      }
	  
      @Parameters({"chromeDriverPath","filePath"})
	 @Test(dataProvider = "setData")
	    public void fillReception(FormDetailModel[] formObjectModelArr) throws InterruptedException, FileNotFoundException, IOException {
	        FormDetailModel formObjectModel = formObjectModelArr[0];
	        String url = formObjectModel.getUrl();
                 
	        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote=allow-origins=*");
	        options.addArguments("--headless");
	        ChromeDriver driver = new ChromeDriver();
 
	        try {
	            
	            driver.get(url);
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	            for (FieldDetails fieldModel : formObjectModel.getfieldDetils()) {
	            	String type = fieldModel.getFieldTypes();
	            	String key = fieldModel.getFieldKeys();
	            	String value = fieldModel.getFieldValues();
	            //	String label = "field_" + key;
	            	switch (type.toLowerCase()) {
	                case "text":
	                case "phone":
	                case "postcode": 
	                case "number":
	                case "email": 
	                	try {
							driver.findElement(By.id(key)).sendKeys(value);
							testResult.add("Pass");
						} catch (Exception e) {
							
	                        testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                    break;
	                case "textarea":
	                	try {
	                		Thread.sleep(2000);
							WebElement inputField = driver.findElement(By.xpath("//input[@id='" + key + "']"));
							((JavascriptExecutor) driver).executeScript("arguments[0].value='"+value+"';", inputField);
							testResult.add("Pass");
							
						} catch (Exception e) {
							
	                        testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                    break;
	                	
	                case "radio":
	                	try {
	                		
							driver.findElement(By.id(key)).click();
							testResult.add("Pass");
						} catch (Exception e) {
							
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                	break;
	                case "checkbox":
	                	try {
							//driver.findElement(By.xpath("//label[@for = '"+label + "']")).click();
							driver.findElement(By.xpath("//label[@for = '"+ key + "']")).click();
							testResult.add("Pass");
						} catch (Exception e) {
							
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                    break;
	                case "select":
	                	Thread.sleep(3000);
	                	WebElement selectElement;
						try {
							selectElement = driver.findElement(By.xpath("//select[@id='"+ key +"']"));
							Select select = new Select(selectElement);
		                	select.selectByIndex(1);
							//select.selectByValue("Other");
		                	testResult.add("Pass");
						
						} catch (Exception e) {
							
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                	break;
	                case "input":
	                	Thread.sleep(2000);
	                	
	                	try {
							driver.findElement(By.xpath("//input[@value = '"+key+"']")).click();
							testResult.add("Pass");
							
						}catch (Exception e) {
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                	break;
	                case"button":	
	                	try {
						driver.findElement(By.xpath("//button[@type = '"+key+"']")).click();
				         testResult.add("Pass");	
				         
	                	} catch (Exception e) {
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}	
		             	break;
	                default:
	                    System.out.println("Unsupported field type: " + type);
	                    break;
	            }
	            	
	            }
	            Thread.sleep(5000);
	            String msg = "";
	        	try {
	        		msg = driver.findElement(By.xpath("//div[@class = 'frm_message']/h2")).getText();
	        	} catch (Exception e) {
	        		
	        		e.printStackTrace();
	        	}
	              
	                if (msg.equalsIgnoreCase("You have completed the form")) {
	                	formResult.add("Pass");
	                    System.out.println("Form Submitted--- "+formObjectModel.getId());
	                	
	                }else {
	                	formResult.add("Fail");
	                	System.out.println("Fail----"+formObjectModel.getId());

	                }
	                                       
	        } finally {
	            
	            driver.quit();
	        }
	 }
      @Parameters({"filePath"})
	 @AfterTest
	 public void writeTestResult(String filePath) throws FileNotFoundException, IOException {
	        
	        try (FileInputStream fis = new FileInputStream(filePath)) {
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            
	            XSSFSheet sheet1  = workbook.getSheetAt(0);
	            for (int i = 0; i < formResult.size(); i++) {
	            	XSSFRow row = sheet1.getRow(i+1);
	                if (row == null) {
	                    row = sheet1.createRow(i);
	                }
	                
	                XSSFCell cell = row.createCell(3);
	                cell.setCellValue(formResult.get(i));
	            }
	            
	         
	            XSSFSheet sheet = workbook.getSheetAt(1);
	            for (int i = 0; i < testResult.size(); i++) {
	            	XSSFRow row = sheet.getRow(i+1);
	                if (row == null) {
	                    row = sheet.createRow(i);
	                }
	                
	                XSSFCell cell = row.createCell(4);
	                cell.setCellValue(testResult.get(i));
	            }
	          

	       	            try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            workbook.write(fos);
	            workbook.close();
	            System.out.println("Test Result have been written successfully."); 

	        }
	        }
	        
	    }
      
	    @DataProvider
	    public FormDetailModel[] setData() throws IOException {
	        
	    	FormDetailModel[] objArr = ReadFieldDetails.readData(filePath);
	        return objArr;
	    }


}
