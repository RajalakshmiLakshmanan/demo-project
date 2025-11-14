package learnSelinium;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rail {
	@Test
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://erail.in/");
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		WebElement from = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		from.clear();
		from.sendKeys("chennai egmore");
		
		WebElement to = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		to.clear();
		to.sendKeys("mumbai central");
		driver.findElement(By.xpath("//input[@id='buttonFromTo']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class,'TrainList')]/tbody/tr/td[2]/a"));
	    List<String> trainName  = new ArrayList<>();
	  
	    for(WebElement element:elements ) {
	    	String str = element.getText();
	    	trainName.add(str);
	    	
	    }
	    
	    Collections.sort(trainName);
	   System.out.println(trainName);
	
	
	}
	

}
