package emails_tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import static emails_tests.ProtonTests.MESSAGE;
import static emails_tests.ProtonTests.PROTON_USERNAME;

public class ReceiveMessageTest extends BaseTestGmail {

    public static final String GMAIL_USERNAME = "testaccepam123";
    public static final String GMAIL_PASSWORD = "111abrakadabra111";


    @Test
    public void checkMessageGmail() throws InterruptedException {
        getLogInGmailPage().clickLogInButton();
        getLogInGmailPage().implicitWait(5);
        getLogInGmailPage().enterEmail(GMAIL_USERNAME);
        getLogInGmailPage().clickNextButton();
        Thread.sleep(1000);
        getLogInGmailPage().enterPassword(GMAIL_PASSWORD);
        getLogInGmailPage().clickNextButton();
        Thread.sleep(1000);
        getGmailAccountPage().isNewMessageUnread();
        getGmailAccountPage().clickMessageButton();
        getGmailAccountPage().implicitWait(5);
        Thread.sleep(1000);
        Assert.assertEquals(getGmailAccountPage().getReceivedMessage(), MESSAGE);
        Assert.assertEquals(getGmailAccountPage().getDisplayedSender(), PROTON_USERNAME);
    }
}
