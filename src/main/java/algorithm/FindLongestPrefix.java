/**
 * Given an array of strings as input, write a function to return longest common prefix to all of its elements.
 */
package algorithm;

public class FindLongestPrefix {
    public String solution(String[] input) {
        if (null == input || input.length == 0) {
            return "";
        }

        boolean isFound = false;
        int prefixIndex = -1;

        while (!isFound) {
            int tempPrefixIndex = prefixIndex + 1;
            if (null == input[0] || input[0].length() <= tempPrefixIndex) {
                // No more chars in first word
                isFound = true;
            }

            char letter = input[0].charAt(tempPrefixIndex);
            for (String word : input) {
                if (null == word || word.length() <= tempPrefixIndex || letter != word.charAt(tempPrefixIndex)) {
                    // Letter doest not match with word letter
                    isFound = true;
                }
            }

            ++prefixIndex;
        }

        return prefixIndex < 0 ? "" : input[0].substring(0, prefixIndex);
    }

}
