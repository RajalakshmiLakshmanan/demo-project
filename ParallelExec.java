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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParallelExec {
	  public RemoteWebDriver driver;
	  public String filePath = "./Forms/ask doctor a question.xlsx";
	  public List<String> testResult = new ArrayList<>();
      public List<String> formResult = new ArrayList<>();
      
      
      @Parameters({"browser"})
  	@BeforeMethod
  	public void runPrecondition(String browser) {
  		ChromeOptions option = new ChromeOptions();
  		FirefoxOptions op = new FirefoxOptions();
  		
  		//op.addArguments("remote-allow-origins=*");
  		option.addArguments("remote-allow-origins=*");
  		if(browser.equalsIgnoreCase("chrome")) {
  			 System.setProperty("webdriver.chrome.driver", "/home/rajalakshmi/Downloads/chromedriver-linux64-121/chromedriver-linux64/chromedriver");
  		     driver =new ChromeDriver(option);
  		     
  		}else if(browser.equalsIgnoreCase("firefox")) {
  			System.setProperty("webdriver.gecko.driver", "/home/rajalakshmi/code/geckodriver");
  			driver = new FirefoxDriver(op);
  				
  		}
  		
  	}
      
	
	 @Test(dataProvider = "setData",invocationCount=1)
	    public void fillReception(FormDetailModel[] formObjectModelArr) throws InterruptedException, FileNotFoundException, IOException {
	        FormDetailModel formObjectModel = formObjectModelArr[0];
	        String url = formObjectModel.getUrl();
	            
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
	                case "textarea":
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
	                case "radio":
	                	try {
	                		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	                        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(key)));
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	            			wait.until(ExpectedConditions.elementToBeClickable(element));
	            			Thread.sleep(5000);
	            			element.click();
	                
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
	                
	                	WebElement selectElement;
						try {
							selectElement = driver.findElement(By.xpath("//select[@id='"+ key +"']"));
							Select select = new Select(selectElement);
		                	//select.selectByIndex(1);
							select.selectByValue("Other");
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
							testResult.add("Pass");System.setProperty("webdriver.chrome.driver", "/home/rajalakshmi/Downloads/chromedriver-linux64-121/chromedriver-linux64/chromedriver");
							
						}catch (Exception e) {
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                	break;
	                case"button":	
	                	try {
	                    Thread.sleep(2000);		
						driver.findElement(By.xpath("(//button[@type = '"+key+"'])[2]")).click();
				         testResult.add("Pass");	
				         
	                	} catch (Exception e) {
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}	
		             	break;
	                case "span":
	                	try {
	                		Thread.sleep(2000);
							driver.findElement(By.xpath("(//span[@class='"+key+"'])[2]")).click();
							testResult.add("Pass");
						} catch (Exception e) {
							testResult.add(e.getClass().getName());
							e.printStackTrace();
						}
	                default:
	                    System.out.println("Unsupported field type: " + type);
	                    break;
	            }
	            	
	            }
	            
	            String msg = "";
	        	try {
	        		msg = driver.findElement(By.xpath("//div[@class = 'frm_message']/h3")).getText();
	        	} catch (Exception e) {
	        		
	        		e.printStackTrace();
	        	}
	              
	                if (msg.equalsIgnoreCase("Thank you")) {
	                	formResult.add("Pass");
	                    System.out.println("Form Submitted--- "+formObjectModel.getId());
	                	
	                }else {
	                	formResult.add("Fail");
	                	System.out.println("Fail----"+formObjectModel.getId());

	                }                              
	   
	 }
	 @AfterMethod
	   public void runPostcondition() {
	   
	            
	            driver.quit();
	        }
	 
	/* @AfterTest
	 public void writeTestResult() throws FileNotFoundException, IOException {
	        
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
	        
	    }*/

	    @DataProvider
	    public FormDetailModel[] setData() throws IOException {
	        
	    	FormDetailModel[] objArr = ReadFieldDetails.readData(filePath);
	        return objArr;
	    }


}
