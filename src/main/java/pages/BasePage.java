package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void implicitWait(long timeToWait){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeToWait));
    }
}
