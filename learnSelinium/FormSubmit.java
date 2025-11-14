package learnSelinium;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSubmit {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://iatcustomer1.nedtechnology.co.in/ask-question-form");
            driver.findElement(By.id("patient_firstnames")).sendKeys("test");
			driver.findElement(By.id("patient_lastname")).sendKeys("form");
			driver.findElement(By.id("patient_dob_day")).sendKeys("06");
			driver.findElement(By.id("patient_dob_month")).sendKeys("01");
			driver.findElement(By.id("patient_dob_year")).sendKeys("1932");
			driver.findElement(By.id("contact_phone")).sendKeys("07438038327");
			driver.findElement(By.id("contact_email")).sendKeys("silicontest.nedholdings@gmail.com");

            // -------- Fill text fields --------
            List<WebElement> textInputs = driver.findElements(By.cssSelector("input.formidable_form_field[type='text']"));
            int counter = 1;
            for (WebElement input : textInputs) {
                if (input.isDisplayed() && input.isEnabled()) {
                    try {
                        js.executeScript("arguments[0].scrollIntoView(true);", input);
                        input.clear();
                        input.sendKeys("SampleText" + counter++);
                    } catch (Exception e) {
                        String value = "SampleText" + counter++;
                        js.executeScript(
                            "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                            "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                            input, value
                        );
                    }
                }
            }

            // -------- Handle checkboxes --------
            List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
            for (WebElement checkbox : checkBoxes) {
                if (!checkbox.isSelected()) {
                    js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
                    js.executeScript("arguments[0].click();", checkbox);
                }
            }

            // -------- Handle radio buttons --------
            List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
            if (!radioButtons.isEmpty()) {
                WebElement firstRadio = radioButtons.get(0);
                js.executeScript("arguments[0].scrollIntoView(true);", firstRadio);
                js.executeScript("arguments[0].click();", firstRadio);
            }

            // -------- Handle textarea --------
            List<WebElement> textAreas = driver.findElements(By.tagName("textarea"));
            for (WebElement textArea : textAreas) {
                js.executeScript("arguments[0].scrollIntoView(true);", textArea);
                textArea.sendKeys("This is a test message from Selenium.");
            }

            // -------- Submit button --------
            WebElement submitButton = driver.findElement(By.cssSelector("button[id='submit']"));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
            js.executeScript("arguments[0].click();", submitButton);

            System.out.println("✅ Form submitted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
	
       

}
