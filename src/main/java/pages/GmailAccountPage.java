package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailAccountPage extends BasePage{
    public GmailAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='1']")
    private WebElement newMessage;

    @FindBy(xpath = "//div[text()=\"Hello, my friend!\"]")
    private WebElement text;

    @FindBy(xpath = "(//tbody)[last()]")
    private WebElement messageButton;

    @FindBy(xpath = "(//span/child::span[text()='first_account22'])[last()]")
    private WebElement sender;

    public void isNewMessageUnread(){
        newMessage.isDisplayed();
    }

    public void clickMessageButton(){
        messageButton.click();
    }

    public String getReceivedMessage(){
        return text.getText();
    }

    public String getDisplayedSender(){
        return sender.getText();
    }
}
