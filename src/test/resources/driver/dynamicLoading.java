package stepdefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.dynamics;
import pages.forms;
import pages.homePage;


public class dynamicLoading  {
	private formAuthentication arg3;
	WebDriver driver;
	forms formsAuth;
	dynamics loading;
	homePage home;
	
	
	public dynamicLoading()
	{
		System.out.println("printing the driver value in dynamic loading constructor method"+driver);
		this.driver=driver;
		
	}
	@Given("^click on home image$")
	public void click_on_home_image() throws Throwable {
		formsAuth=new forms(arg3.driver);	
		
		System.out.println("printing the driver value in dynamic loading constructor method"+driver);
	}
	
	
	

	@When("^click on Dynamic Loading and click exampleSecond$")
	public void click_on_Dynamic_Loading_and_click_exampleSecond() throws Throwable {
		home=new homePage(driver);
		home.navigatetoDynamicPage();
		loading=new dynamics(driver);
	 System.out.println("click on dynamic page");
	 
		loading.clicklink();
		System.out.println("clicked dynamic page");
	 	}

	@And("^click on start and wait for the loading dsappears$")
	public void click_on_start_and_wait_for_the_loading_dsappears() throws Throwable {
		System.out.println("click on start");
		loading.startandLoading();
		System.out.println("loading complete");
		
	}

	@Then("^verify the Hello message$")
	public void verify_the_Hello_message() throws Throwable {
	   
		loading.checkMessage();
	}


}
