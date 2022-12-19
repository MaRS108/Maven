package d_MAVENNeostoxTestNG_;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import b_MAVENNeostoxUtility.NeostoxUTILITYCLASS;
import c_MAVENTESTNeostoxPOM.MA_NeostoxLoginPageExcel;
import c_MAVENTESTNeostoxPOM.MB_NeostoxpasswordExcel;
import c_MAVENTESTNeostoxPOM.MC_NeostoxWarningpageExcel;
import c_MAVENTESTNeostoxPOM.MD_NeostoxHomepageExcel;
import c_MAVENTESTNeostoxPOM.ME_Neostoxlogoutexcel;

public class F_NEOSTOX_TESTNG {
	MA_NeostoxLoginPageExcel UserID;
	MB_NeostoxpasswordExcel pwd;
	MC_NeostoxWarningpageExcel wrng;
	MD_NeostoxHomepageExcel hmpg;
	ME_Neostoxlogoutexcel lgoff2;
	protected WebDriver driver;

	@BeforeClass
	public void openportal() {
		System.setProperty("webdriver.chrome.driver", "D:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		driver.get("https://neostox.com/");
		Reporter.log("launching browser", true);
		UserID = new MA_NeostoxLoginPageExcel(driver);
		pwd = new MB_NeostoxpasswordExcel(driver);
		wrng = new MC_NeostoxWarningpageExcel(driver);
		hmpg = new MD_NeostoxHomepageExcel(driver);
		lgoff2 = new ME_Neostoxlogoutexcel(driver);
	}

	@BeforeMethod
	public void Neostoxlogincrendetial() throws EncryptedDocumentException, IOException, InterruptedException {

		UserID.neostoxsign();
		UserID.neostoxmobilenumber(NeostoxUTILITYCLASS.readDatafromExcel(1, 1));
		UserID.signinbutton();
		Reporter.log("correct username", true);
		pwd.putpassword(NeostoxUTILITYCLASS.readDatafromExcel(1, 2));
		pwd.submitbutton();

		Reporter.log("correct password", true);

		wrng.handlepopup();
		Reporter.log("all popup closed", true);

	}

	@Test
	public void testcase() {
		hmpg.neostoxprofileValidation();
		Reporter.log("validate userId", true);

	}

	@AfterMethod
	public void afterMethod() {
		hmpg.amount();
		Reporter.log("amount of NEOSTOX", true);

	}

	@AfterClass
	public void closebrowser() {

		lgoff2.signout();

	}

}