package loggigty;
import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyTestNGClass {

    private static final Logger logger = LogManager.getLogger(MyTestNGClass.class);
 
    WebDriver driver = new ChromeDriver();
    ExtentReports reports;
    ExtentTest test;
   
    @BeforeClass
    public void open() {
    	driver.get("https://www.twitch.tv/ariasaki");
    	driver.manage().window().maximize();
    	
    	
    }
    
    @AfterClass
    public void close() {
    	//driver.quit();
    }
    
    @Test
    public void testExample() {
    	By username = By.xpath("/html//input[@id='login-username']");
    	By password = By.xpath("/html//input[@id='password-input']");
    	By loginButton1 = By.xpath("/html//div[@id='root']/div[@class='Layout-sc-1xcs6mc-0 ehcMTF']//nav[@class='InjectLayout-sc-1i43xsx-0 kjjhRA top-nav']//div[@class='Layout-sc-1xcs6mc-0 cQZlhV']/div[1]//button[@class='ScCoreButton-sc-ocjdkq-0 ScCoreButtonSecondary-sc-ocjdkq-2 bTXTVH cegTsp']//div[@class='Layout-sc-1xcs6mc-0 bFxzAY']");
    	By loginButton2 = By.xpath("/html/body/div[@class='ReactModalPortal']/div/div[@role='dialog']/div[@class='Layout-sc-1xcs6mc-0 bjPIuI modal-wrapper__backdrop modal-wrapper__backdrop--info']/div/div//form//button[@class='ScCoreButton-sc-ocjdkq-0 ScCoreButtonPrimary-sc-ocjdkq-1 ccqkQH gmCwLG']//div[@class='Layout-sc-1xcs6mc-0 gzKWOA']");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	driver.findElement(loginButton1).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		
		driver.findElement(username).sendKeys("user1");
		logger.info("entering user");
		driver.findElement(password).sendKeys("pass1");
		logger.info("entering password");
		driver.findElement(loginButton2).click();
		logger.info("logging in");
        
        Assert.fail("Test failed because condition was not met.");
    }
}
