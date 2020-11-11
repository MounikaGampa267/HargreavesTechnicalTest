package stepdefinition;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DynamicLoading;
import pages.FormsAuthentication;
import pages.HomePage;
//import pages.initilization;
import pages.JsAlerts;

public class Base {

	public static WebDriver driver;
	FormsAuthentication formsAuth;
	HomePage home;
	DynamicLoading dynamicLoading;
	JsAlerts jsAlert;
	

	@Before
	@Given("^Initializing browser for Form Authentication$")
	public void initializing_browser_for_Form_Authentication() throws Throwable {
		String path="\\\\src\\\\test\\\\resources\\\\driver";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser name:");
		String browsername = sc.nextLine();
		String projectPath = System.getProperty("user.dir");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://the-internet.herokuapp.com/");

		} else if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					projectPath + "\\src\\test\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\src\\test\\resources\\driver\\Igeckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("^clicking on Form Authentication and Enter usename and password link$")
	public void clicking_on_Form_Authentication_and_Enter_usename_and_password_link() throws Throwable {
		
		
		home = new HomePage(driver);
		formsAuth = new FormsAuthentication(driver);
		home.formAuthentication();
		formsAuth.enterUsername();
		formsAuth.enterPassword();
		formsAuth.clickLogin();
		formsAuth.messageVissible();
		formsAuth.clickHome();
		
	}

	@And("^Clicking on dynamic link and loading and verifying the hello wold$")
	public void clicking_on_dynamic_link_and_loading_and_verifying_the_hello_wold() throws Throwable {

		
		home.navigatetoDynamicPage();
		dynamicLoading = new DynamicLoading(driver);
		Scanner sc=new Scanner(System.in);
		String selectExample=sc.nextLine();
		if(selectExample.equalsIgnoreCase("Example1"))
		{
			dynamicLoading.Example1();
		}
		else if(selectExample.equalsIgnoreCase("Example2"))
		{
		   dynamicLoading.Example2();
		}
		

	}
	@And("^clicking on javascript$")
	public void clicking_on_javascript() throws Throwable {

		jsAlert = new JsAlerts(driver);
		home.clickJsConfirm();
		jsAlert.clickJsButton();

	}

	@Then("^verify the alert message dispalyed correct or not$")
	public void verify_the_alert_message_dispalyed_correct_or_not() throws Throwable {

		jsAlert.getAletmsg();
		driver.close();
	}
	

}