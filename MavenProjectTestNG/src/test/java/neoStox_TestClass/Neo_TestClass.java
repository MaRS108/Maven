package neoStox_TestClass;

import org.testng.annotations.Test;

import neoStox_Utility.Neo_Utility;
import neoStox_Base.Neo_Base;
import neoStox_POM.A_NeoStoxLoginPage;
import neoStox_POM.B_NeoStoxPasscodePage;
import neoStox_POM.C_NeoStoxHomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

@Listeners(neoStox_Base.Listener.class)
public class Neo_TestClass extends Neo_Base {
	A_NeoStoxLoginPage login;
	B_NeoStoxPasscodePage passcode;
	C_NeoStoxHomePage home;

	@BeforeClass
	public void launchBrowser() throws IOException {
		launchBrowser1();
		Reporter.log("Launching Browser", true);
		login = new A_NeoStoxLoginPage(driver);
		passcode = new B_NeoStoxPasscodePage(driver);
		home = new C_NeoStoxHomePage(driver);

	}

	@BeforeMethod
	public void loginToNeoStox() throws IOException {
		login.sendMobileNumber(Neo_Utility.readDataFromPropertyFile("mobilenumber"));
		login.clickOnSignIn();
		Reporter.log("Signing in..", true);
		Neo_Utility.wait(driver, 1000);
		passcode.sendPasscode(Neo_Utility.readDataFromPropertyFile("passcode"));
		passcode.clickOnSubmitButton();
		Reporter.log("Password Entered..", true);
		Neo_Utility.wait(driver, 1000);
		home.handlePopUp(driver);

	}

	@Test
	public void validateUserName() throws IOException {
		Assert.assertEquals(home.getActualUserID(driver), Neo_Utility.readDataFromPropertyFile("expUserName"));
		Reporter.log("validating userName and Taking screenshot", true);
		Neo_Utility.screenShot(driver, "TCID");
	}

	@AfterMethod
	public void logoutFromUpstox() throws InterruptedException {
		Neo_Utility.wait(driver, 1000);
		home.logoutFromApplication(driver);
		Reporter.log("logging out....", true);
	}

	@AfterClass
	public void closeBrowser() {
		Neo_Utility.wait(driver, 1000);
		Reporter.log("closing browser....", true);
		driver.close();
	}

}
