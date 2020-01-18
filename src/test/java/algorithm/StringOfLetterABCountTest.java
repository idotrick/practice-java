package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringOfLetterABCountTest {
    StringOfLetterABCount testObject = new StringOfLetterABCount();

    @Test
    @DisplayName("Input: A=0, B=0 Expected: <empty>")
    void twoZerors() {
        int A = 0, B = 0;
        String expected = "";
        String actual = testObject.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testA1B1() {
        int A = 1, B = 1;
        String expected = "ab";
        String actual = testObject.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testA5B3() {
        int A = 5, B = 3;
        String expected = "aabaabab";
        String actual = testObject.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testA3B3() {
        int A = 3, B = 3;
        String expected = "aababb";
        String actual = testObject.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testA1B4() {
        int A = 1, B = 4;
        String expected = "bbabb";
        String actual = testObject.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testA4B1() {
        int A = 4, B = 1;
        String expected = "aabaa";
        String actual = testObject.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

}
