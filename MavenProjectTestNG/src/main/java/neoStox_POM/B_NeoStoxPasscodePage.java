package neoStox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_NeoStoxPasscodePage {

	@FindBy(xpath = "//input[@id='txt_accesspin']")
	private WebElement passcode;
	@FindBy(xpath = "//a[@id='lnk_submitaccesspin']")
	private WebElement submitbutton;

	public B_NeoStoxPasscodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendPasscode(String pc) {
		passcode.clear();
		passcode.sendKeys(pc);
	}

	public void clickOnSubmitButton() {
		submitbutton.click();
	}

}
