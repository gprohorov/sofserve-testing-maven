/*
  @author   george
  @project   sofserve-testing-maven
  @class  MyUtils
  @version  1.0.0 
  @since 12.03.23 - 21.44
*/

import com.sun.jdi.CharValue;

import java.util.regex.Pattern;

public class MyUtils {
    public static boolean checkEmail(String text) {
        if (!text.contains("@") || text == null) {
            return false;
        }
        var arr1 = text.split("@");

        if (arr1.length > 2) {
            return false;
        }

        String username = arr1[0];
        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }

        boolean test1 = Pattern.matches("[A-Za-z0-9\\.]+", username);

        if (!test1) return false;

        var domains = arr1[1].split("\\.");
        if (domains[0].length() < 2 || domains.length < 2 ) {
            return false;
        }
    for (int i = 0; i < domains.length; i++) {
        if (!Pattern.matches("[A-Za-z0-9]+", domains[i])) {
            return false;
        }
    }

        return true;
    }
}
