package Practice;

import java.util.Arrays;
import java.util.List;

public class Test_check {

    public static void main(String[] args) {

        int fact = 5;
        int answer = JavaSeleniumTest.factorialAnswer(fact);
        System.out.println(answer);

        String[] one = {"happY", "king", "peace", "living standard"};
        String[] two = {"king kong", "Happy", "PEACE"};
        List<String> dupes = JavaSeleniumTest.commonValues(one,two);
        System.out.println(dupes);

        int[] intArray = {3,5,1,4,2,7};
        int output = JavaSeleniumTest.findMissingValue(intArray);
        System.out.println(output);

    }
}
