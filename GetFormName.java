package test.demo;
		import java.io.FileInputStream;
import java.io.FileOutputStream;
		import java.io.IOException;
		import java.time.Duration;
		import java.util.ArrayList;
		import java.util.List;
		import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
		import org.openqa.selenium.chrome.*;
		import org.openqa.selenium.chrome.ChromeDriver;

		public class GetFormName {

		    public static void main(String[] args) throws InterruptedException, IOException {
		        
		    	String chromeDriverPath = args[0];
		    	String siteUrl = args[1];
		    	String filename = args[2];
		    	
		    	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		        ChromeOptions option = new ChromeOptions();
		        option.addArguments("--remote=allow-origins=*");
		        ChromeDriver driver = new ChromeDriver(option);
		        driver.get(siteUrl+"/wp-admin/edit.php?post_type=transaction&orderby=title&order=asc");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		        driver.findElement(By.id("user_login")).sendKeys("silicon");
		        driver.findElement(By.id("user_pass")).sendKeys("G7H2fbS3$9f@");
		       // driver.findElement(By.id("user_pass")).sendKeys("FRW%Gp1cE&pv*Aj!hTgD96Qp");
		        driver.findElement(By.id("wp-submit")).click();
		        String totalPages = driver.findElement(By.xpath("//span[@class = 'total-pages']")).getText();
		       int pages = Integer.parseInt(totalPages);
		        //int pages = 1;
                //String filename = "./Sites/test.xlsx";
		        List<String> urllist = new ArrayList<>();
		        List<String> formlist = new ArrayList<>();
		        for (int i = 0; i < pages; i++) {
		            List<WebElement> forms = driver.findElements(By.xpath("//a[@class = 'row-title']"));

		            for (WebElement form : forms) {
		                String formName = form.getText();
		                if (formName != null && !formName.isEmpty()) {
		                    formlist.add(formName);
		                    System.out.println(formName);
		                }
		            }

		            List<WebElement> links = driver.findElements(By.xpath("//a[text() = 'View']"));

		            for (WebElement link : links) {
		                String url = link.getAttribute("href");
		                if (url != null && !url.isEmpty()) {
		                    urllist.add(url);
		                    System.out.println(url);
		                }
		            }
		            if (i != pages) {

		                try {
		                    driver.findElement(By.xpath("//a[@class = 'next-page button']")).click();
		                } catch (Exception e) {
		                	System.out.println("System error-----" +e.getClass().getName());
		                    e.printStackTrace();
		                }

		            }
		        }

		      	    try (FileInputStream fis = new FileInputStream(filename)) {
		            XSSFWorkbook workbook = new XSSFWorkbook(fis);
		         
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            for (int i = 0; i < formlist.size(); i++) {
		                XSSFRow row = sheet.createRow(i);
		                XSSFCell cell = row.createCell(0);
		                cell.setCellValue(formlist.get(i));
		            }
		          

		        Thread.sleep(3000);

		       
		            for (int i = 0; i < urllist.size(); i++) {
		                XSSFRow row = sheet.getRow(i);
		                if (row == null) {
		                    row = sheet.createRow(i);
		                }
		                XSSFCell cell = row.createCell(1);
		                cell.setCellValue(urllist.get(i));
		            }
		            try (FileOutputStream fos = new FileOutputStream(filename)) {
		            workbook.write(fos);
		            System.out.println("Form names have been written successfully."); 
		            System.out.println("URLs have been written successfully.");
		        }

		        Thread.sleep(2000);
		        driver.close();
		    }
		
		    }

	}


