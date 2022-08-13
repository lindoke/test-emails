package emails_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import pages.ProtonAccountPage;
import pages.LogInProtonPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTestProtonMail {
    private WebDriver driver;
    private static final String PROTONMAIL_URL = "https://proton.me";

    @BeforeTest
    public void profileSetup() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PROTONMAIL_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public LogInProtonPage getLogInProtonPage(){
        return new LogInProtonPage(getDriver());
    }

    public ProtonAccountPage getAccountPage(){
        return new ProtonAccountPage(getDriver());
    }


}
