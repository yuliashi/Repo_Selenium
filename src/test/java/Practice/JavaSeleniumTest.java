package Practice;

import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaSeleniumTest {


//     Ques-1:
//     Create a method to return factorial value of input-int-value
//     points: 10
//     eg:
//     input -> 5
//     returned value -> (5*4*3*2*1) = 120

    public static int factorialAnswer (int input) {

        int factorial = 1;
        for (int i=1; i<=input; i++) {
            factorial *= i;
        }
        return factorial;
    }


    @Test

    /**
     * Ques-2:
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */

    public static void darkskyTempConversion () {

        MyDriver.launchUrlOnNewWindow("https://darksky.net/");

        WebElement feelsLike = MyDriver.getDriver().findElement(By.xpath("//span[@class = 'feels-like-text']"));
        String feelsLikeString = feelsLike.getText();
        String[] tempArray = feelsLikeString.split("˚");
        String feelsLikeTemp = tempArray[0];
        int feelsLikeInt = Integer.parseInt(feelsLikeTemp);

        WebElement lowTempElement = MyDriver.getDriver().findElement(By.xpath("//span[@class = 'low-temp-text']"));
        String lowTempString = lowTempElement.getText();
        String[] tempArray2 = lowTempString.split("˚");
        String lowTemp = tempArray2[0];
        int lowTempInt = Integer.parseInt(lowTemp);

        WebElement highTempElement = MyDriver.getDriver().findElement(By.xpath("//span[@class = 'high-temp-text']"));
        String highTempString = highTempElement.getText();
        String[] tempArray3 = highTempString.split("˚");
        String highTemp = tempArray3[0];
        int highTempInt = Integer.parseInt(highTemp);

        boolean isFeelsLikeTempHigher = feelsLikeInt > lowTempInt;
        boolean isFeelsLikeTempLower = feelsLikeInt < highTempInt;

        Assert.assertTrue(isFeelsLikeTempHigher,"Error: feels like temperature is lower then all-timme lowest");
        Assert.assertTrue(isFeelsLikeTempLower,"Error: feels like temperature is higher then all-time high");
    }

/**
 * Ques-3:
 * Create a method to return the common Strings values in two input-String-arrays
 * points: 30
 * Note: two input-String-arrays can be of same size or different size
 * eg: input -> {"happY", "king", "peace", "living standard"} , {"king kong", "Happy", "PEACE"}
 * returned value -> [happy, peace]
 */

    public static List<String> commonValues (String[] input1, String[] input2) {
        

        List<String> dupValues = new ArrayList<>();
        for (int i=0; i< input1.length; i++) {
            for (int y=0; y< input2.length; y++) {
                if (input1[i].equalsIgnoreCase(input2[y])){
                    dupValues.add(input1[i]);
                }
            }

        }

        return dupValues;

    }

/**
 * Ques-4:
 * Create a method to return missing smallest positive integer (greater than 0) from given int-array.
 * points: 40
 * eg:
 * input -> : {3, 5, 1, 4, 2, 7}
 * returned value : 6
 */
    public static int findMissingValue (int[] InputArray) {

        int i = 0;

        while (i < InputArray.length) {
            if (InputArray[i] > 0 && InputArray[i] < InputArray.length+1 && InputArray[i] != InputArray[InputArray[i - 1]]) {
                int y = InputArray[i] - 1;
                int x = InputArray[i];
                InputArray[i] = InputArray[y];
                InputArray[y] = x;
            } else {
                i++;
            }
        }

        for (int p = 0; p < InputArray.length; p++) {
            if (InputArray[p] != p + 1) {

                return InputArray[p];
            }
        }

        return InputArray.length + 1;

    }

}
