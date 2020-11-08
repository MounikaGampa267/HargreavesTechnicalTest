package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class jsConfirm {
	
WebDriver driver;
	
	@FindBy(xpath="//button[text()='Click for JS Confirm']")
	WebElement clickJSConfirm;
	
	public jsConfirm(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickJsButton()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click()", clickJSConfirm);
	}
	
	public void getAletmsg()
	{
		Alert allert= driver.switchTo().alert();
		   String jsText=allert.getText();
		   String jsMessage= "I am a JS Confirm";
		   Assert.assertEquals(jsText, jsMessage);
		   System.out.println("The message is relevant");
		   
		   allert.accept();
	}
	
	

	

}
