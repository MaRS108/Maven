package neoStox_Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStox_Utility.Neo_Utility;

public class Listener extends Neo_Base implements ITestListener {

	public void onTestFailure(WebDriver driver, ITestResult result) {
		Reporter.log("TC " + result.getName() + " Failed Please Check It", true);
		try {
			Neo_Utility.screenShot(driver, "TC " + result.getName() + "Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC " + result.getName() + " Passed Successfully", true);
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test is skipped please retry", true);

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}