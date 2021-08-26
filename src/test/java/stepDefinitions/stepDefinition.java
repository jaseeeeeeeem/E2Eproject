package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Resources.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class stepDefinition extends base {
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initialiseDriver();
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	    
	}

	@And("^Click on Login link in homepage to land on secure sign in page$")
	public void click_on_Login_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp=new LandingPage(driver);
		int flag=0;
		if(lp.getPopup().isDisplayed())
		{
			lp.getPopup().click();
		}
		else {
		lp.getLogin().click();
		flag=1;
		}
		if(flag!=1)
		{
		lp.getLogin().click();
		}
	    
	}

	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lg=new LoginPage(driver);
		lg.getEmail().sendKeys(username);
		lg.getPassword().sendKeys(password);
		lg.submit().click();
    }

	@Then("^verify that the user is successfully logged in$")
	public void verify_that_the_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage lg=new LoginPage(driver);
	    WebElement alert=lg.getAlert();
	    if(alert.getText().equalsIgnoreCase("Invalid email or password."))
	    {
	    	System.out.println("not successfully logged in");
	    }
	    
	}
	
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	        driver=null;
	    }
}
