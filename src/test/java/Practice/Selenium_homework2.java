package Practice;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_homework2 {

    //Testcase - 1

    @Test

    public static void testMessenger () {
        MyDriver.launchUrlOnNewWindow("https://messenger.com/");

        //Verify tha "keep me signed in" box is not pre-selected
        String checkBoxXpath = "//label[@class = 'uiInputLabelInput']";
        By keepMeSignedCheckBoxLocator = By.xpath(checkBoxXpath);
        WebElement keepMeSignedCheckBox = MyDriver.getDriver().findElement(keepMeSignedCheckBoxLocator);
        boolean isCheckBoxSelected = keepMeSignedCheckBox.isSelected();
        Assert.assertFalse(isCheckBoxSelected, "Error: the check box should not be pre-selected");

        //click on Log In button
        By loginButtonLocator = By.name("login");
        WebElement loginButton = MyDriver.getDriver().findElement(loginButtonLocator);
        loginButton.click();

        Misc.pause(5);


        //Verify error message is displayed
        WebElement errorMessage = MyDriver.getDriver().findElement(By.xpath("//form[@id='login_form']/div/div[contains(text(), 'ncorrect')]"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed when user skips the Email and Password fields and clicks Log In button");

        Misc.pause(3);


        //Verify "Continue" button is enabled
        String continueBtnXpath = "//button[contains(text(), 'ontinue')]";
        By continueBtnLocator = By.xpath(continueBtnXpath);
        WebElement continueBtn = MyDriver.getDriver().findElement(continueBtnLocator);
        boolean isConBtnEnabled = continueBtn.isEnabled();
        Assert.assertTrue(isConBtnEnabled, "Error: Continue button is disabled when error message is displayed.");

        MyDriver.quitWindows();


        }

        @Test
        //Testcase - 2

        public static void checkFacebookSignUpForm () {
        MyDriver.launchUrlOnNewWindow("https://facebook.com/");

        //Verify Sign Up button is enabled
        WebElement createAccount = MyDriver.getDriver().findElement(By.xpath("//a[@rel = 'async']"));
        createAccount.click();

        Misc.pause(4);

        WebElement signUpBtn = MyDriver.getDriver().findElement(By.name("websubmit"));
        boolean isSignUpBtnEnabled = signUpBtn.isEnabled();
        Assert.assertTrue(isSignUpBtnEnabled,"Error: sign up button is not enabled when the page is launched");

        //Fill out the form
        WebElement firstName = MyDriver.getDriver().findElement(By.name("firstname"));
        firstName.sendKeys("Jason");
        WebElement lastName = MyDriver.getDriver().findElement(By.name("lastname"));
        lastName.sendKeys("Blackman");
        WebElement email = MyDriver.getDriver().findElement(By.name("reg_email__"));
        email.sendKeys("alex.akunin@protonmail.com");
        Misc.pause(1);
        WebElement emailConfirmation = MyDriver.getDriver().findElement(By.name("reg_email_confirmation__"));
        emailConfirmation.sendKeys("alex.akunin@protonmail.com");
        WebElement pass = MyDriver.getDriver().findElement(By.xpath("//input[@data-type = 'password']"));
        pass.sendKeys("123@ABC");
        signUpBtn.click();

        Misc.pause(4);

        //Verify if error message displayed when entry is not finished
        WebElement errorMsgGender = MyDriver.getDriver().findElement(By.xpath("//div[@id = 'js_2fl']"));
        boolean errorMsgGenderIsDisplayed = errorMsgGender.isDisplayed();
        Assert.assertTrue(errorMsgGenderIsDisplayed, "Error message is not displayed properly");

        MyDriver.quitWindows();


        }










}
