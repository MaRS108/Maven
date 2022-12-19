package neoStox_POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Neo_Utility {

	public static String readDataFromPropertyFile(String Key) throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(
				"C:\\Users\\manoj\\eclipse-workspace\\Selenium\\src\\neoStox_Test\\NeoStox.property");
		obj.load(objfile);
		String value = obj.getProperty(Key);
		return value;
	}

	public static void screenShot(WebDriver driver, String TCname) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\manoj\\OneDrive\\Pictures\\Seleniumss" + TCname + ".png");
		FileHandler.copy(src, dest);
	}

	public static void wait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
}
