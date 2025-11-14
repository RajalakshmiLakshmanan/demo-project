package learnSelinium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * URL - https://www.cleartrip.com/

1) Launch chrome and load URL, Add implicitwait

2) Click Round trip

3) Enter From city (Chennai) and TAB

4) Enter To city (New York) and TAB

5) Click Depart On (text box) 

6) Select current date as Depart date

7) Click Return On (text box) 

8) Select tomorrow's date as return date

9) Select Adults (as 2)

10) Select Children (as 1)

11) Select Infant (as 1)

12) Click More Options (use id as locator)

13) Select Premium Economy as Class of Travel

14) Enter Preferred Airline as Emirates and TAB

15) Click Search Flights 

 */		



public class ClearTrip {
	@Test
	public void startBrowser() throws IOException, InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cleartrip.com/");
		Actions action = new Actions(driver);
		action.moveByOffset(100,200).click().perform();
		driver.findElement(By.xpath("//input[@Placeholder='Where from?']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='MAA']")).click();
		driver.findElement(By.xpath("//input[@Placeholder='Where to?']")).sendKeys("Newyork");
		WebElement element = driver.findElement(By.xpath("//div[text()='NYC']"));
		//Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
				
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		driver.findElement(By.xpath("(//div[@class='DayPicker-Day']/div)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='1 Adult, Economy']/following::span)[1]")).click();
		driver.findElement(By.xpath("//p[text()='Premium economy']")).click();
		driver.findElement(By.xpath("(//button[@class='bn c-pointer'])[2]")).click();
		driver.findElement(By.xpath("(//button[@class='bn c-pointer'])[3]")).click();
		driver.findElement(By.xpath("//h4[text()='Search flights']")).click();
		Thread.sleep(5000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("/home/rajalakshmi/eclipse-workspace/siliconpractice/sanp/trip.png");
	    FileUtils.copyFile(src, des);
	    driver.close();
		
		
		
		
		
		
	}
	
	

}
