package pages;

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

public class dynamics {
	
WebDriver driver;
	
	@FindBy(xpath="//a[text()='Dynamic Loading']")
	WebElement clickIcon;
	
	@FindBy(linkText="Example 2: Element rendered after the fact")
	WebElement clicklink2;
	
	@FindBy(xpath="//h4[contains(text(),'Hello World!')]")
	WebElement messageHello;
	
	@FindBy(xpath="//a//img")
	WebElement homeImage;
	
	@FindBy(xpath="//button[text()='Start']")
	WebElement clickStart;
	
	@FindBy(id="loading")
	By loading;
	
	public dynamics(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateNextPage()
	{
		clickIcon.sendKeys(Keys.ENTER);
		 System.out.println("Clicked on dynamic loading");
	}
	
	public void startandLoading() throws InterruptedException
	{
		clickStart.click();
		Thread.sleep(5000);
		//WebDriverWait wait=new WebDriverWait(driver,20);
	   //wait.until(ExpectedConditions.visibilityOfElementLocated(loading));
		//wait.until(driver = !driver.FindElement(By.Id("processing")).Displayed);
	
	}
	
	public void checkMessage()
	{
		Assert.assertTrue( messageHello.getText().equalsIgnoreCase("Hello World!"));
		System.out.println(messageHello.getText());
	}
	
	public void clickHome()
	{
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].click()", homeImage);
	}
	public void clicklink()
	{
		clicklink2.click();	
	}
}
