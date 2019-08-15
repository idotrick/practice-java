package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindLongestPrefixTest {
  FindLongestPrefix testObject = new FindLongestPrefix();

  @Test
  void nullArray(){
    String[] testCase = null;
    String expected = "";
    String actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void EmptyArray(){
    String[] testCase = new String[0];
    String expected = "";
    String actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void successCaseWithMixCase() {
    String[] input = {"APpCKTTb", "APPLE", "APPCE", "APPTTEME"};
    String expected = "AP";
    String actual = testObject.solution(input);
    assertEquals(expected, actual);
  }

  @Test
  void validCaseWithUpperCase() {
    String[] input = {"APPCKTTB", "APPLE", "APPCE", "APPTTEME"};
    String expected = "APP";
    String actual = testObject.solution(input);
    assertEquals(expected, actual);
  }

  @Test
  void validCaseWithLowerCase() {
    String[] input = {"appckttb", "apple", "appce", "apptteme"};
    String expected = "app";
    String actual = testObject.solution(input);
    assertEquals(expected, actual);
  }
}
