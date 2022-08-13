package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInGmailPage extends BasePage{

    public LogInGmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Войти')]")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@aria-label='Введите пароль']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(text(), 'Войти')]")
    private WebElement submitButton;

    @FindBy(xpath = "//span[text()='Далее']")
    private WebElement nextButton;

    public void clickLogInButton(){
        logInButton.click();
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickNextButton(){
        nextButton.click();
    }


}
