package Group1.Artifact1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());

	@Test(dataProvider="getData")
	public void Trial1(String uname,String pass,String msg) throws IOException {
//		FileInputStream fis=new FileInputStream("C:\\Users\\User\\Desktop\\eclipse workspace\\Artifact1\\src\\main\\java\\Resources\\data.properties");
//		Properties p= new Properties();
//		p.load(fis);
//		driver=initialiseDriver();
//		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		log.info("Entered home page");
		LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
		log.info("Entered login page");
		LoginPage lg=new LoginPage(driver);
		lg.getEmail().sendKeys(uname);
		lg.getPassword().sendKeys(pass);
		System.out.println();
		lg.submit().click();
		log.info("Testing login");
//		Assert.assertEquals("FEATURED COURSES", lp.heading().getText());
//		System.out.println("Done");
//		driver.quit();
	}
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver=initialiseDriver();
	}
	
	
	
	@AfterTest
	public void terminate()
	{
		driver.quit();
		driver=null;
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0]="email1@qw.com";
		obj[1][0]="email2@qww.com";
		obj[0][1]="password1";
		obj[1][1]="password2";
		obj[0][2]="Restricted User";
		obj[1][2]="Unrestricted User";
	return obj;
	}

}
