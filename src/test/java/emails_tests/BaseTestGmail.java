package emails_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.GmailAccountPage;
import pages.ProtonAccountPage;
import pages.LogInGmailPage;
import pages.LogInProtonPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTestGmail {
    private WebDriver driver;
    private static final String GMAIL = "https://www.google.com/intl/ru/gmail/about/";

    @BeforeTest
    public void profileSetup() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GMAIL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public LogInGmailPage getLogInGmailPage(){
        return new LogInGmailPage(getDriver());
    }

    public GmailAccountPage getGmailAccountPage(){
        return new GmailAccountPage(getDriver());
    }
}