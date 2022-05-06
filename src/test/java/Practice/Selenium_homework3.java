package Practice;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Selenium_homework3 {

    //Testcase - 1
    //darksky.net - Verify correct temperature value is displayed after changing temperature units

    @Test

    public static void darkskyTempConversion () {

        MyDriver.launchUrlOnNewWindow("https://darksky.net/");

        //form[@id = 'searchForm']/following-sibling::div[@class = 'options']/div[contains(@class, 'units')]/div[contains(@class, 'hide')]/following-sibling::div[@class = 'selectric']/b[@class = 'button']
        //div[contains(@class, 'selectric-below')]//b
        WebElement arrowDown = MyDriver.getDriver().findElement(By.xpath("//form[@id = 'searchForm']/following-sibling::div[@class = 'options']/div[contains(@class, 'units')]/div[contains(@class, 'hide')]/following-sibling::div[@class = 'selectric']/b[@class = 'button']"));
        arrowDown.click();

        Misc.pause(2);

        //Selecting temperature UoM as Fahrenheit from the dropdown
        WebElement tempUnitOfMeasureF = MyDriver.getDriver().findElement(By.xpath("//div[contains(@class, 'selectric-below')]//ul/li[@data-index = '0'] "));
        tempUnitOfMeasureF.click();

        Misc.pause(2);

        //Getting temperature value from the display
        WebElement display = MyDriver.getDriver().findElement(By.xpath("//span[@class  = 'summary swap']"));
        String getTempTextF = display.getText();
        String[] tempArrayF = getTempTextF.split("˚");
        String actualTempF = tempArrayF[1];
        int tempFInt = Integer.parseInt(actualTempF);

        //Selecting temperature UoM as Celsius
        arrowDown.click();
        Misc.pause(2);

        WebElement tempUnitOfMeasureC = MyDriver.getDriver().findElement(By.xpath("//div[contains(@class, 'selectric-below')]//ul/li[@data-index = '1'] "));
        tempUnitOfMeasureC.click();

        Misc.pause(2);

        String getTempTextC = display.getText();
        String[] tempArrayC = getTempTextC.split("˚");
        String actualTempC = tempArrayC[1];
        int tempCInt = Integer.parseInt(actualTempC);

        int expectedTempC = (tempFInt - 32) * 5/9;

        Assert.assertEquals(tempCInt,expectedTempC, "Incorrect temperature conversion");


    }

    //Testcase - 2
    // facebook.com - Verify current date is selected in the dropdown when user lands on the Create new account form

    @Test

    public static void verifyCurrentDate () {

        //finding today's date
        Date today = new Date();
        SimpleDateFormat month = new SimpleDateFormat("MMM");
        String expectedMonth = month.format(today);
        SimpleDateFormat day = new SimpleDateFormat("d");
        String expectedDay = day.format(today);
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        String expectedYear = year.format(today);

        //clicking on "Create Account" button on facebook.com
        MyDriver.launchUrlOnNewWindow("https://facebook.com/");
        WebElement createAccount = MyDriver.getDriver().findElement(By.xpath("//a[@rel = 'async']"));
        createAccount.click();

        Misc.pause(4);

        //finding locators and text for the birthday fields
        WebElement monthField = MyDriver.getDriver().findElement(By.id("month"));
        Select todaysMonthDd = new Select (monthField);
        String todaysMonth = String.valueOf(todaysMonthDd.getFirstSelectedOption().getText());

        WebElement dayField = MyDriver.getDriver().findElement(By.id("day"));
        Select todaysDayDd = new Select (dayField);
        String todaysDay = String.valueOf(todaysDayDd.getFirstSelectedOption().getText());

        WebElement yearField = MyDriver.getDriver().findElement(By.id("year"));
        Select todaysYearDd = new Select (yearField);
        String todaysYear = String.valueOf(todaysYearDd.getFirstSelectedOption().getText());

        //comparing today's date to the text in the birthday fields
        Assert.assertEquals(todaysMonth, expectedMonth, "Incorrect data in the Month field");
        Assert.assertEquals(todaysDay,expectedDay,"Incorrect data in the Day field");
        Assert.assertEquals(todaysYear, expectedYear,"Incorrect data in the Year field");


    }

    //Testcase -3
    //https://classroomessentialsonline.com/ - Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs

    @Test

    public static void verifyOptionSelection () {

        MyDriver.launchUrlOnNewWindow("https://classroomessentialsonline.com/");

        WebElement churchChairsMenuItem = MyDriver.getDriver().findElement(By.xpath("//a[@href = '/church-chairs/']"));
        Actions action = new Actions(MyDriver.getDriver());
        action.moveToElement(churchChairsMenuItem).build().perform();

        Misc.pause(2);

        WebElement economyChurchChairsMenuItem = MyDriver.getDriver().findElement(By.xpath("//a[@href = '/economy-church-chairs/']"));
        economyChurchChairsMenuItem.click();

        Misc.pause(2);

        String economyChurchChairsUrl = "https://classroomessentialsonline.com/economy-church-chairs/";
        String urlAfterClick = MyDriver.getDriver().getCurrentUrl();

        Assert.assertEquals(economyChurchChairsUrl, urlAfterClick, "User lands on the wrong URL");


    }




}
