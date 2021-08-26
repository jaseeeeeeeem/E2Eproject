package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver=null;
	
	public Properties prop=null;

	public WebDriver initialiseDriver() throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\User\\Desktop\\eclipse workspace\\Artifact1\\src\\main\\java\\Resources\\data.properties");
		prop= new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		System.out.println("Chrome");
//		return driver;
		}
		else {
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Firefox");
//			return driver;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void Screenshot(String name) throws IOException {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("C:\\Users\\User\\Desktop\\eclipse workspace\\Artifact1\\screenshots\\screenshot"+name+".png"));
	}

	
}
