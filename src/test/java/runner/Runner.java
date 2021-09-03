package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Hamim\\eclipse-workspace\\CucumberDemoOne\\Features\\searchBox.feature", glue = {
		"step_def" }, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)
public class Runner {

}
