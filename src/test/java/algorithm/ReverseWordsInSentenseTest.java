package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseWordsInSentenseTest {
    private static final ReverseWordsInSentense testObject = new ReverseWordsInSentense();

    @Test
    void nullString() {
        String testCase = null;
        String expected = null;
        String actual = testObject.solution(testCase);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void emptyString() {
        String testCase = "";
        String expected = "";
        String actual = testObject.solution(testCase);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void oneWord() {
        String testCase = "one";
        String expected = "one";
        String actual = testObject.solution(testCase);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void oddNumberOfWords() {
        String testCase = "Big Bad Wolf";
        String expected = "Wolf Bad Big";
        String actual = testObject.solution(testCase);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void twoWords() {
        String testCase = "Big Bad";
        String expected = "Bad Big";
        String actual = testObject.solution(testCase);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void evenNumberOfWords() {
        String testCase = "Big Bad Wolf Chase";
        String expected = "Chase Wolf Bad Big";
        String actual = testObject.solution(testCase);
        Assertions.assertEquals(expected, actual);
    }


}
