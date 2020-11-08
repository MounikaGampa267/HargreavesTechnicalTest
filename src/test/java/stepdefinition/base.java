package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dynamics;
import pages.forms;
import pages.homePage;
import pages.jsConfirm;

public class base {

	public static WebDriver driver;
	forms formsAuth;
	homePage home;
	dynamics loading;
	jsConfirm jsAlert;

	@Before
	@Given("^Initializing browser for Form Authentication$")
	public void initializing_browser_for_Form_Authentication() throws Throwable {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@When("^clicking on Form Authentication and Enter usename and password link$")
	public void clicking_on_Form_Authentication_and_Enter_usename_and_password_link() throws Throwable {
		home = new homePage(driver);
		formsAuth = new forms(driver);
		home.formAuthentication();
		formsAuth.enterUsername();
		formsAuth.enterPassword();
		formsAuth.clickLogin();
		System.out.println("Succesfully logged in");

		System.out.println("printing the driver value in formAuthentication class then class" + driver);
		System.out.println("message visible");
		formsAuth.messageVissible();
		System.out.println("loggedout");
		formsAuth.clickHome();
		System.out.println("on home page");

		System.out.println("printing the driver value in formAuthentication class after logout" + driver);

	}

	@And("^Clicking on dynamic link and loading and verifying the hello wold$")
	public void clicking_on_dynamic_link_and_loading_and_verifying_the_hello_wold() throws Throwable {

		home.navigatetoDynamicPage();
		loading = new dynamics(driver);
		System.out.println("click on dynamic page");

		loading.clicklink();
		System.out.println("clicked dynamic page");

		loading.startandLoading();
		System.out.println("loading complete");

		loading.checkMessage();
		loading.clickHome();
	}

	@And("^clicking on javascript$")
	public void clicking_on_javascript() throws Throwable {

		jsAlert = new jsConfirm(driver);
		home.clickJsConfirm();
		jsAlert.clickJsButton();

	}

	@Then("^verify the alert message dispalyed correct or not$")
	public void verify_the_alert_message_dispalyed_correct_or_not() throws Throwable {

		jsAlert.getAletmsg();
		driver.close();
	}

}
