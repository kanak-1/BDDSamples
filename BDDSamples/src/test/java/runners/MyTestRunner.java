package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src//test//resources//features//GooglePageSearch.feature",
		glue= {"stepDefs"},
		//dryRun=true,
		monochrome=true,
		plugin= {"pretty","html:target/reports/HtmlReport.html",
//				"usage:target/reports/UsageReport",
//				"json:target/reports/JsonReport.json",
//				"junit:target/reports/JUnitReport.xml"
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class MyTestRunner extends AbstractTestNGCucumberTests{//extending inbuilt class

	
	
}
