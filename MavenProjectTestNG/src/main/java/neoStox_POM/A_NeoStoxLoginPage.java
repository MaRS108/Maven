package neoStox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_NeoStoxLoginPage {

	@FindBy(xpath = "//input[@id='MainContent_signinsignup_txt_mobilenumber']")
	private WebElement mobilenumber;
	
	@FindBy(xpath = "//a[@id='lnk_signup1']")
	private WebElement signin;

	public A_NeoStoxLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendMobileNumber(String mn) {
		mobilenumber.clear();
		mobilenumber.sendKeys(mn);
	}

	public void clickOnSignIn() {
		signin.click();
	}
}
