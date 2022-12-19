package neoStox_Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import neoStox_Utility.Neo_Utility;

public class Neo_Base {

	public static WebDriver driver;

	public void launchBrowser1() throws IOException {
		WebDriverManager.chromedriver();
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\Manoj\\Software\\CHROME WEBDRIVER\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Neo_Utility.readDataFromPropertyFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

	}

}
