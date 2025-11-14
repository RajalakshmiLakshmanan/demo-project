package learnSelinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/rajalakshmi/Downloads/chromedriver-linux64-121/chromedriver-linux64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote=allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("QDX");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Alex");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("pamphiore");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		System.out.println(driver.getTitle());
		driver.close();
}
}
