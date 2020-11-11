package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoading {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	WebElement clickIcon;

	@FindBy(linkText = "Example 2: Element rendered after the fact")
	WebElement clicklink2;

	By clicklink1 = By.linkText("Example 1: Element on page that is hidden");

	@FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
	WebElement messageHello;

	@FindBy(xpath = "//a//img")
	WebElement homeImage;

	@FindBy(xpath = "//button[text()='Start']")
	WebElement clickStart;

	@FindBy(id = "loading")
	By loading;

	public DynamicLoading(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Example1() throws InterruptedException {
		driver.findElement(clicklink1).click();
		checkMessage();
	}

	public void Example2() throws InterruptedException {
		clicklink2.click();
		checkMessage();
	}

	/**
	 * Will wait upto the loading and displays the Hello world message
	 * 
	 * @throws InterruptedException
	 */
	public void checkMessage() throws InterruptedException {
		clickStart.click();
		Thread.sleep(5000);
		Assert.assertTrue(messageHello.getText().equalsIgnoreCase("Hello World!"));
		System.out.println(messageHello.getText());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", homeImage);
	}

}
