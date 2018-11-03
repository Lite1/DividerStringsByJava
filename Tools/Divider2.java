package Tools;

import java.util.ArrayList;
import java.util.List;

public class Divider2 {

    public static List<String> divisionStrAtSubStr(String str, int n) {
        List<String> list = new ArrayList<>();
        final int LENGTH_MIN_PREFIX = 6;

        if (LENGTH_MIN_PREFIX >= n) {
            throw new IllegalArgumentException("Размер подстроки меньше или равен минимальному размеру строки");
        }

        int amountSubStrings = 1;
        int numSubString = 0;
        int residueString = str.length();

        while (true) {
            numSubString++;

            int lengthOfPrefix = 4 + getNumLength(numSubString) + getNumLength(amountSubStrings);

            if (lengthOfPrefix >= n) {
                throw new RuntimeException("Невозможно разложить строку");
            }

            int endIndexForSubstring;
            if (residueString <= n - lengthOfPrefix) {
                endIndexForSubstring = residueString;
                residueString = 0;
            } else {
                endIndexForSubstring = n - lengthOfPrefix;
                residueString -= endIndexForSubstring;
            }
            list.add("[" + numSubString + "/" + amountSubStrings + "] " + str.substring((numSubString - 1) *  (n - lengthOfPrefix), (numSubString - 1) * ( n - lengthOfPrefix) + endIndexForSubstring));


            if (residueString == 0) {
                break;
            }

            if (numSubString == amountSubStrings) {
                amountSubStrings++;
                numSubString = 0;
                residueString = str.length();
                list.clear();
            }
        }
        return list;
    }

    private static int getNumLength(int num) {
        return (int) Math.log10(num) + 1;
    }
}