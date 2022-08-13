package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogInProtonPage extends BasePage{

    @FindBy(xpath = "//a[contains (@href, 'login')]")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@autocomplete='current-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    List<WebElement> emptyFieldWarningMessages =
            driver.findElements(By.xpath("//span[contains(text(), 'This field is required')]"));

    public LogInProtonPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogInButton(){
        logInButton.click();
    }

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public int countOfEmptyFieldWarningMessages(){
        return emptyFieldWarningMessages.size();
    }


}
