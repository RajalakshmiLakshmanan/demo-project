package learnSelinium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverStart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/rajalakshmi/Downloads/chromedriver-linux64-121/chromedriver-linux64/chromedriver");
		//WebDriver driver = new ChromeDriver();
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--remote=allow-origins=*");
		ChromeDriver driver= new ChromeDriver(option);
		
		driver.get("https://www.google.com");

	}

}
