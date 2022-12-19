package neoStox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_NeoStoxHomePage {

	public C_NeoStoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='lbl_username']")
	private WebElement UserID;
	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logout;
	@FindBy(xpath = "(//a[text()='OK'])[2]")
	private WebElement popupOKbutton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")
	private WebElement popupClosebutton;

	public String getActualUserID(WebDriver driver) {
		String actualUID = UserID.getText();
		return actualUID;
	}

	public void logoutFromApplication(WebDriver driver) {
		UserID.click();
		Neo_Utility.wait(driver, 500);
		logout.click();
	}

	public void handlePopUp(WebDriver driver) {
		Neo_Utility.wait(driver, 500);
		popupOKbutton.click();
		Neo_Utility.wait(driver, 5000);
		popupClosebutton.click();
	}
}
