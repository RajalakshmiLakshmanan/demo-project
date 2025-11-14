package learnSelinium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccess {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/rajalakshmi/Downloads/chromedriver-linux64-126/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://cookie.siliconpreview.co.uk/dashboard/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("user_login")).sendKeys("AutoUserAdmin");
        driver.findElement(By.id("password")).sendKeys("Autoadmin@2023");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
       // driver.findElement(By.xpath("//button[text()='Accept']")).click();
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Print the alert text (optional)
       // System.out.println("Alert Text: " + alert.getText());

        // Accept the alert (click "OK" button)
        alert.accept();*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation-modal___BV_modal_content_")));

        // Locate the modal
        WebElement modal = driver.findElement(By.id("confirmation-modal___BV_modal_content_"));

        // Click the button inside the modal
        WebElement modalButton = modal.findElement(By.xpath("//button[contains(text(), 'Accept')]"));
        modalButton.click();
        
        driver.findElement(By.xpath("//button[@id='dropdown-menu-button']")).click();
        driver.findElement(By.xpath("//span[text()='User Access']")).click();
        //Thread.sleep(40000);
        driver.findElement(By.xpath("//a[text()='Create new user']")).click();

        Thread.sleep(2000);
        driver.close();

	}

}
