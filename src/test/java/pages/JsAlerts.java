package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JsAlerts {

	WebDriver driver;

	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
	WebElement clickJSConfirm;

	public JsAlerts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * clicks on JavaScript confirm button
	 */
	public void clickJsButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", clickJSConfirm);
	}

	/**
	 * verifys the alert message
	 */
	public void getAletmsg() {
		Alert allert = driver.switchTo().alert();
		String jsText = allert.getText();
		String jsMessage = "I am a JS Confirm";
		Assert.assertEquals(jsText, jsMessage);
		System.out.println("The message is relevant");
		allert.accept();
	}

}
