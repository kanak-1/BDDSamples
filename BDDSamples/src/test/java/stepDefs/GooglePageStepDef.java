package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GooglePageStepDef {
	WebDriver driver;

	@Given("User is on Google Page")
	public void user_is_on_google_page() {
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");		
		driver.navigate().to("https://www.google.com/");
		
	    
	}
	@When("I search Java Tutorial")
	public void i_search_java_tutorial() {
		WebElement srcBox=driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Java Tutorial");  
		srcBox.submit();
	}
	@Then("Should display Java result page")
	public void should_display_java_result_page() {
		String strTitle=driver.getTitle();
		//Assert.assertEquals(strTitle, "Java Tutorial - Google Search");
		Assert.assertEquals(strTitle, "Java Tutorial - Google Search Page");
	    
	}
	@After //hook
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot screen=(TakesScreenshot)driver;
			byte[] src=screen.getScreenshotAs(OutputType.BYTES); //bytes is used to save screenshot in html report as byte array
			scenario.attach(src, "image/png", "Scenario Screenshot");
		}
		
	}
}
