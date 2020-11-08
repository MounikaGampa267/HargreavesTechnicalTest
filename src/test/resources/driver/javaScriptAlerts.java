package stepdefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.dynamics;
import pages.homePage;
import pages.jsConfirm;

public class javaScriptAlerts {
	
WebDriver driver;
jsConfirm jsAlert;
dynamics loading;
homePage home;

	@Given("^click on home image on Dynamic loading$")
	public void click_on_home_image_on_Dynamic_loading() throws Throwable {
		loading=new dynamics(driver);
		loading.clickHome();//include in given
		System.out.println("on home page");
	 
	}

	@When("^click on JavaScript Alerts and js confirm button$")
	public void click_on_JavaScript_Alerts_and_js_confirm_button() throws Throwable {
		jsAlert=new jsConfirm(driver);
		home.clickJsConfirm();
		
		jsAlert.clickJsButton();
	}

	@Then("^verify the alert message$")
	public void verify_the_alert_message() throws Throwable {
		jsAlert.getAletmsg();
	}

}
