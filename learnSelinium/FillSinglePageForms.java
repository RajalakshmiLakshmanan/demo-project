package learnSelinium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import formsAutomate.ReadForms;


public class FillSinglePageForms {
   public ChromeDriver driver;
 
  
   @Test(dataProvider = "excelFiles")	
   public void readExcelFile(File file) throws InterruptedException, IOException {
	   System.out.println("Reading Excel file: " + file.getName());
       String[][] urllist = ReadAskForms.readData(file);  
       int index= 0;
	   for(String url[]:urllist) {
		   loadPage(url[index]);
		   index++;
		   
	   }
	   
   }
		public void loadPage(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/rajalakshmi/Downloads/chromedriver-linux64-121/chromedriver-linux64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote=allow-origins=*");
	     driver = new ChromeDriver(option);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String element ="";
		try {
			element = driver.findElement(By.xpath("//h2[text() = 'Your details']")).getText();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("element: " +element);
		
		if(!(element.contains("Your details"))) {
			
			System.out.println("element: " +element);

			fillFirstName();
		}else {
			
		fillYourDetails();
		
		}
		if (url.contains("ask")) {
			driver.findElement(By.className("nhsuk-textarea")).sendKeys("question from patient");
			clickCheckBox();
			clickSubmit();
		}
		Thread.sleep(2000);
		driver.close();
		
	}
	
	public void fillYourDetails() {
		try {
			driver.findElement(By.id("patient_firstnames")).sendKeys("DONOTUSE");
			driver.findElement(By.id("patient_lastname")).sendKeys("XXTESTPATIENT-TGNP");
			driver.findElement(By.id("patient_dob-day")).sendKeys("06");
			driver.findElement(By.id("patient_dob-month")).sendKeys("01");
			driver.findElement(By.id("patient_dob-year")).sendKeys("1932");
			driver.findElement(By.id("contact_sex-0")).click();
			driver.findElement(By.id("patient_postcode")).sendKeys("LS16AE");
			driver.findElement(By.id("contact_phone")).sendKeys("07438038327");
			driver.findElement(By.id("contact_email")).sendKeys("silicontest.nedholdings@gmail.com");
		} catch (Exception e) {
			System.out.println("Do manual Testing");
						e.printStackTrace();
		}
		
	}
	
	public void fillFirstName() {
		
		try {
			driver.findElement(By.id("field_h2w8uy")).sendKeys("XXTESTPATIENT-TGNP DONOTUSE");
			driver.findElement(By.id("field_qiqd62")).sendKeys("06/01/1932");
			driver.findElement(By.id("field_ghgz9h")).sendKeys("07438038327");
			driver.findElement(By.id("field_q6pbnb")).sendKeys("silicontest.nedholdings@gmail.com");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	     
		
	}
	
	public void clickSubmit() throws InterruptedException {
		Thread.sleep(3000);
        try {
			driver.findElement(By.xpath("(//button[@class='nhsuk-button'])[3]")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
      try {
		driver.findElement(By.xpath("//input[@class = 'nhsuk-button']")).click();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	}
	
	public void clickCheckBox() {
		
		try {
			driver.findElement(By.xpath("//input[@class= 'nhsuk-checkboxes__input']")).click();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@DataProvider(name = "excelFiles")
    public Object[][] getExcelFiles() {
        
        String folderPath = "./Url";


        File folder = new File(folderPath);

        
        File[] files = folder.listFiles();

        if (files != null) {
            Object[][] data = new Object[files.length][1];

            
            for (int i = 0; i < files.length; i++) {
               
                if (files[i].isFile() && files[i].getName().endsWith(".xlsx")) {
                    data[i][0] = files[i];
                }
            }
            return data;
        } else {
            System.out.println("Folder is empty or does not exist.");
            return new Object[0][0];
        }
    }
}
