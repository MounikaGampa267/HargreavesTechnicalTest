package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsAuthentication {

	WebDriver driver;
	@FindBy(linkText = "Form Authentication")
	WebElement form_Auth;
	By txt_username = By.name("username");
	@FindBy(name = "password")
	WebElement txt_password;
	By button = By.xpath("//button[@type='submit']");
	By message = By.xpath("//*[@class='flash success']");
	By home = By.xpath("//a//img");

	public FormsAuthentication(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void formAuthentication() {
		form_Auth.click();
	}

	public void enterUsername() {
		driver.findElement(txt_username).sendKeys("tomsmith");
	}

	public void enterPassword() {
		txt_password.sendKeys("SuperSecretPassword!");
	}

	public void clickLogin() {
		driver.findElement(button).click();
		System.out.println("Succesfully logged in");
	}

	/**
	 * Verifies the Login and click on Logout
	 */
	public void messageVissible() {
		WebElement messages = driver.findElement(message);
		System.out.println(messages.getText());
		if (messages.isDisplayed()) {
			System.out.println("Succesfully loggedin");
			System.out.println("message visible");
			driver.findElement(By.xpath("//div[@class='example']//a")).click();
			System.out.println("Succesfully logged out");
		}

	}

	public void clickHome() {
		WebElement arg = driver.findElement(home);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", arg);
	}

}
