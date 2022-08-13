package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProtonAccountPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(), 'Входящие')]")
    private WebElement mailsButton;

    @FindBy(xpath = "//button[contains(text(), 'сообщение')]")
    private WebElement newMessageButton;

    @FindBy(xpath = "//input[contains(@class, 'field w100')]")
    private WebElement receiverAddressField;


    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendButton;

    @FindBy(xpath = "//input[@placeholder='Тема']")
    private WebElement themeField;

    List<WebElement> mails = driver.findElements(By.xpath("//span[contains(text(), 'Входящие')]"));

    public ProtonAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void isMailsButtonVisible(){
        mailsButton.isDisplayed();
    }

    public boolean doesMailsButtonExist(){
        return !mails.isEmpty();
    }

    public void clickNewMessageButton(){
        newMessageButton.click();
    }

    public void typeReceiverAddress(String receiverAddress){
        receiverAddressField.sendKeys(receiverAddress);
    }

    public void enterMessage(String message){
        WebElement iFrame=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
        WebElement messageField = driver.findElement(By.xpath("//div[contains(@style, 'font-family')][1]"));
        messageField.sendKeys(message);
        driver.switchTo().defaultContent();
    }

    public void enterTheme(String theme){
        themeField.sendKeys(theme);
    }

    public void clickSendButton(){
        sendButton.click();
    }
}
