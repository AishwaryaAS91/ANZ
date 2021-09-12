package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features/newUserRegister.feature",
				"src/test/resources/Features/payment.feature"},
glue= "StepDefinitions",
monochrome=true,
plugin={"pretty","html:target/HtmlReports",
		"json:target/JSONReports/report.json",
"junit:target/JUNITReports/report.xml"}
		)
public class TestRunner {

}
