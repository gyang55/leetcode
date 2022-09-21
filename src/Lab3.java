import java.util.ArrayList;

/**
 * <p>
 * Lab3 Generate strings with different patterns. Each character of the string is chosen from '0','1','2'.
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class Lab3 {
    /**
     * Patterns contains the final string patterns
     */
    ArrayList<String> patterns = new ArrayList<>();

    /**
     * <p>
     * generateAllPatterns create all string patterns with input length n.
     * </p>
     *
     * @param n the string length
     */
    private void generateAllPatterns(int n) {
        if (n == 1) {
            patterns.add("0");
            patterns.add("1");
            patterns.add("2");
        }
        if (n > 1) {
            generateAllPatterns(n - 1);
            ArrayList<String> patternsCopy = new ArrayList<>(patterns);
            patterns.clear();
            for (String pattern : patternsCopy
            ) {
                String patternVariable1 = pattern.concat("0");
                patterns.add(patternVariable1);
                String patternVariable2 = pattern.concat("1");
                patterns.add(patternVariable2);
                String patternVariable3 = pattern.concat("2");
                patterns.add(patternVariable3);
            }
        }
    }

    /**
     * <p>
     * generatePatternsWithNoDoubleDigits create all string patterns without any same consecutive characters
     * with input length n.
     * </p>
     *
     * @param n the string length
     */
    private void generatePatternsWithNoDoubleDigits(int n) {
        if (n == 1) {
            patterns.add("0");
            patterns.add("1");
            patterns.add("2");
        }
        if (n > 1) {
            generatePatternsWithNoDoubleDigits(n - 1);
            // Copy the patterns to patternCopy, which would be iterated in foreach.
            ArrayList<String> patternsCopy = new ArrayList<>(patterns);
            // clear() patterns, and prepare to add patternVariables.
            patterns.clear();
            for (String pattern : patternsCopy
            ) {
                String patternVariable1 = pattern.concat("0");    // concatenate "0"
                if (!stringMatch(patternVariable1, "00")) { /*checks whether the new string contains "00", if
                                                                    false, add this patternVariable to patterns*/
                    patterns.add(patternVariable1);
                }

                String patternVariable2 = pattern.concat("1");   // concatenate "1"
                if (!stringMatch(patternVariable2, "11")) { /*checks whether the new string contains "11", if
                                                                    false, add this patternVariable to patterns*/
                    patterns.add(patternVariable2);
                }

                String patternVariable3 = pattern.concat("2");    // concatenate "2"
                if (!stringMatch(patternVariable3, "22")) {/*checks whether the new string contains "22", if
                                                                    false, add this patternVariable to patterns*/
                    patterns.add(patternVariable3);
                }
            }
        }
    }

    /**
     * <p>
     * stringMatch checks whether the target string contains a substring.
     * </p>
     *
     * @param text  the target string to be checked.
     * @param match the substring to be checked.
     * @return true if text contains match, otherwise return false.
     */
    private boolean stringMatch(String text, String match) {
        int textLength = text.length();
        int matchLength = match.length();
        for (int i = 0; i <= textLength - matchLength; i++) { /* iterate from first char to (textLength-matchLength)th
                                                                char of text*/
            int matchStartIndex = 0;
            //If the first char of match matches the first char of text, compare the next chars of the two strings
            while (matchStartIndex < matchLength && text.charAt(i + matchStartIndex) == match.charAt(matchStartIndex)) {
                matchStartIndex += 1;
            }
            // if all the characters of match have been compared and matched, return true
            if (matchStartIndex == matchLength) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int num = 5;
        Lab3 lab3 = new Lab3();
        lab3.generateAllPatterns(num);
        System.out.println(lab3.patterns);
        System.out.println();
        Lab3 lab3Two = new Lab3();
        lab3Two.generatePatternsWithNoDoubleDigits(num);
        System.out.println(lab3Two.patterns);
    }


}
