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

//import stepdefinition.formAuthentication;
public class forms {
	
  WebDriver driver;
	
//private formAuthentication arg3;
	@FindBy(linkText="Form Authentication")
	WebElement form_Auth;
	
	By txt_username= By.name("username");
	
	
	@FindBy(name="password")
	WebElement txt_password;
	
	By button=By.xpath("//button[@type='submit']");
	
By message=By.xpath("//*[@class='flash success']");
	
	By home=By.xpath("//a//img");
	

	public forms(WebDriver driver)
	{
		System.out.println(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void formAuthentication()
	{
		form_Auth.click();
	}
	 
	public void enterUsername()
	{
	   driver.findElement(txt_username).sendKeys("tomsmith");
	}
	
	public void enterPassword()
	{
		txt_password.sendKeys("SuperSecretPassword!");
	}
	
	
	public void clickLogin() {
		driver.findElement(button).click();
	}
	
public void messageVissible() {
		
		WebElement messages=driver.findElement(message);
		System.out.println(messages.getText());
		if(messages.isDisplayed())
		{
			System.out.println("Succesfully loggedin");
			//driver.findElement(By.className("close")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[@class='example']//a")).click();
			System.out.println("Succesfully logged out");
			System.out.println(driver);
			
			
			

		}
		
	}
	
	public void clickHome()
	{
		System.out.println(driver);
		WebElement arg=driver.findElement(home);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click()", arg);
	}
	


}
