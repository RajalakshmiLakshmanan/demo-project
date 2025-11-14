package learnSelinium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	@Test
	public void main() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt = 'Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whandle = new ArrayList<>(windowHandles);
		driver.switchTo().window(whandle.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).click();
		System.out.println("Title: "+driver.getTitle());
		driver.switchTo().window(whandle.get(0));
		driver.findElement(By.xpath("(//img[@alt = 'Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> whandle2 = new ArrayList<>(windowHandles2);
		driver.switchTo().window(whandle2.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]")).click();
		driver.switchTo().window(whandle2.get(0));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		System.out.println("Title: "+driver.getTitle());
		driver.close();
		
	}

}
