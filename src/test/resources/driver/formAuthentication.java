package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.forms;
import pages.homePage;

public class formAuthentication {
	
	public static WebDriver driver;
	forms formsAuth;
	homePage home;
	
	@Before
	@Given("Initializing browser for Form Authentication")
	public void initializing_browser_for_form_authentication() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\resources\\driver\\chromedriver.exe");
	     driver=new ChromeDriver();		
	     System.out.println("successfully launched browser");
	     driver.get("https://the-internet.herokuapp.com/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("successfully launched website");
			System.out.println("printing the driver value in formAuthentication class"+driver);
	}

	@And("clicking on Form Authentication link")
	public void clicking_on_form_authentication_link() {
		home=new homePage(driver);
		home.formAuthentication();
		System.out.println("clicked on form authentication");
		System.out.println("printing the driver value in formAuthentication class in and method"+driver);
	   
	}

	@When("Enter username and password")
	public void enter_username_and_password() {
		//System.out.println("printing the driver value in formAuthentication class when method"+driver);
		formsAuth=new forms(driver);
		formsAuth.enterUsername();
		formsAuth.enterPassword();
		formsAuth.clickLogin();
		System.out.println("Succesfully logged in");
		
		}

	@Then("verify the user is succesfully logged and click logout")
	public void verify_the_user_is_succesfully_logged_and_click_logout() {
		System.out.println("printing the driver value in formAuthentication class then class"+driver);
		System.out.println("message visible");
		formsAuth.messageVissible();
			System.out.println("loggedout");
		formsAuth.clickHome();
		System.out.println("on home page");
		
		System.out.println("printing the driver value in formAuthentication class after logout"+driver);
	}
	


}
