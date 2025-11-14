package learnSelinium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/* 1.Load the URL https://www.amazon.in/
2.search as oneplus 9 pro 
3.Get the price of the first product
4. Print the number of customer ratings for the first displayed product
5. Click the first text link of the first image
6. Take a screen shot of the product displayed
7. Click 'Add to Cart' button
8. Get the cart subtotal and verify if it is correct.
9.close the browser
*/
public class Amazon {
	@Test
	public void runProgram() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("//img[contains(@alt, 'Sony DualSense ')]"));
				element.click();
		WebElement title = driver.findElement(By.xpath("//span[@id='productTitle']"));
		String productTitle = title.getText();
		System.out.println("Title :" +productTitle);
		WebElement rating = driver.findElement(By.xpath("//span[@class='aok-offscreen']"));
		System.out.println(rating.getText());
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String amount = price.getText(); 
		System.out.println(price.getText());
		File src = driver.getScreenshotAs(OutputType.FILE);
		String filePath = "/home/rajalakshmi/eclipse-workspace/siliconpractice/sanp/shot.png";
		File des = new File(filePath);
		FileUtils.copyFile(src, des);
		Actions action = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		action.moveToElement(button).click().perform();
		WebElement skip = driver.findElement(By.xpath("//span[text()=' Skip ']"));
		//action.moveToElement(skip).click().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", skip);
		WebElement cartprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println(cartprice.getText());
		String cart = cartprice.getText();
		if(amount.equals(cart)) {
			System.out.println("success");
			
		}
		
		driver.close();
		
	}
	
	

}
