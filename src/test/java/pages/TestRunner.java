package pages;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature", glue = { "stepdefinition" }, monochrome = true, plugin = {
		"pretty", "junit:target/JUnitReports/report.xml", "json:target/JsonReports/report.json",
		"html:target/HtmlReports/HtmlReports" })
public class TestRunner {

}
