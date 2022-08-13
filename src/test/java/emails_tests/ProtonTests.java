package emails_tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProtonTests extends BaseTestProtonMail{

    public static final String PROTON_USERNAME = "first_account22";
    public static final String PROTON_PASSWORD = "epamisthebest";
    public static final String INVALID_USERNAME = "somerandomusername";
    public static final String INVALID_PASSWORD = "wrongpassword";
    public static final String GMAIL_USERNAME = "testaccepam123";
    public static final String THEME = "Hello!";
    public static final String MESSAGE = "Hello, my friend!";

    public void logIn(String username, String password){
        getLogInProtonPage().clickLogInButton();
        getLogInProtonPage().implicitWait(15);
        getLogInProtonPage().enterUsername(username);
        getLogInProtonPage().enterPassword(password);
        getLogInProtonPage().clickSubmitButton();
        getLogInProtonPage().implicitWait(15);
    }



    @Test
    public void testLogInWithValidCredentials() {
        logIn(PROTON_USERNAME, PROTON_PASSWORD);
        getAccountPage().isMailsButtonVisible();
        assertTrue(getAccountPage().doesMailsButtonExist());
        assertTrue(getAccountPage().getTitle().contains(PROTON_USERNAME + "@protonmail.com"));
    }

    @Test
    public void testLogInWithInvalidCredentials(){
        logIn(INVALID_USERNAME, INVALID_PASSWORD);
        assertFalse(getAccountPage().doesMailsButtonExist());
    }

    @Test
    public void testLogInWithEmptyCredentials(){
        getLogInProtonPage().clickLogInButton();
        getLogInProtonPage().implicitWait(5);
        getLogInProtonPage().clickSubmitButton();
        assertEquals(getLogInProtonPage().countOfEmptyFieldWarningMessages(),2);
    }

    @Test
    public void sendMessageProton() throws InterruptedException {
        getLogInProtonPage().clickLogInButton();
        getLogInProtonPage().implicitWait(5);
        getLogInProtonPage().enterUsername(PROTON_USERNAME);
        getLogInProtonPage().enterPassword(PROTON_PASSWORD);
        getLogInProtonPage().clickSubmitButton();
        getLogInProtonPage().implicitWait(10);
        getAccountPage().clickNewMessageButton();
        Thread.sleep(1000);
        getAccountPage().typeReceiverAddress(GMAIL_USERNAME+"@gmail.com");
        getAccountPage().enterTheme(THEME);
        getAccountPage().enterMessage(MESSAGE);
        Thread.sleep(1000);
        getAccountPage().clickSendButton();
        getLogInProtonPage().implicitWait(10);
    }



}
