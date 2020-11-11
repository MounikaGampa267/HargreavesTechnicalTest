package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public static WebDriver driver;

	By form_Auth = By.partialLinkText("Form Authentication");

	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	WebElement clickIcon;

	@FindBy(linkText = "JavaScript Alerts")
	WebElement clickJS;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void formAuthentication() {
		driver.findElement(form_Auth).click();
	}

	public void navigatetoDynamicPage() {
		clickIcon.sendKeys(Keys.ENTER);
		// clickIcon.click();
		System.out.println("Clicked on dynamic loading");
	}

	public void clickJsConfirm() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", clickJS);

	}

}
