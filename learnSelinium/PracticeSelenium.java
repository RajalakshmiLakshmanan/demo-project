package learnSelinium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeSelenium {
	
	
	    public static void main(String[] args) throws IOException {
	        WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        WebElement rating = driver.findElement(By.xpath("//span[@class='aok-offscreen']"));
	        Select select = new Select(rating);
	        select.selectByIndex(0);
	        driver.switchTo().alert().accept();
	        driver.switchTo().alert().dismiss();
	        Actions action = new Actions(driver);
	        action.moveToElement(rating);
	        Set<String> windows = driver.getWindowHandles();
	        List<String> handle = new ArrayList<>(windows);
	        
	        driver.switchTo().window(handle.get(1));
	        String parentWindow = driver.getWindowHandle();
	        for(String win: windows){
	            if(!win.equals(parentWindow)){
	             driver.switchTo().window(win);  
	             break;
	            }
	        }
	        
	        File src= driver.getScreenshotAs(OutputType.FILE);
	        String filePath = "./sanp/image.png";
            File des = new File(filePath);
            FileUtils.copyFile(src,des);
	    }
	    
	    WebdriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().windows().maximize();
        driver.manage().timeouts().implicitlyWait().(Duration.ofSeconds(10));
        
	}

