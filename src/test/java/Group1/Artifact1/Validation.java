package Group1.Artifact1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class Validation extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	@Test
	public void Trial2() throws IOException {
		
//		FileInputStream fis=new FileInputStream("C:\\Users\\User\\Desktop\\eclipse workspace\\Artifact1\\src\\main\\java\\Resources\\data.properties");
//		Properties p= new Properties();
//		p.load(fis);
//		driver=initialiseDriver();
//		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.heading().getText(),"FEATURED COURSES");
		Assert.assertTrue(lp.getContact().isDisplayed());
		log.info("Title and contact validated");
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
	
}
