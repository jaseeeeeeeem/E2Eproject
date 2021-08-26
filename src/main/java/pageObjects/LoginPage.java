package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email= By.cssSelector("input[name='email']");
	By password=By.cssSelector("input[name=' password']");
	By submit_button=By.cssSelector("input[value='Log In']");
	By alert =By.cssSelector("div[role='alert']");
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement submit()
	{
		return driver.findElement(submit_button);
	}
	public WebElement getAlert()
	{
		return driver.findElement(alert);
	}
}
