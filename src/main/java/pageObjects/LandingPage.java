package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By signin= By.cssSelector("a[href*='sign_in']");
	By head=By.xpath("//*[@id='content']/div/div/h2");
	By contact=By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[8]/a");
	By popup=By.xpath("//*[@id='homepage']/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button");
	
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement heading()
	{
		return driver.findElement(head);
	}
	
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}
}
