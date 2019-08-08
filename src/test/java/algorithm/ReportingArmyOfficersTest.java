package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReportingArmyOfficersTest {

  private ReportingArmyOfficers testObject = new ReportingArmyOfficers();

  @Test
  void nullArray(){
    int[] testCase = null;
    int expected = 0;
    int actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void EmptyArray(){
    int[] testCase = new int[0];
    int expected = 0;
    int actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("TestCase: {1} expected: 0")
  void onlyOneOfficer(){
    int[] testCase = new int[]{1};
    int expected = 0;
    int actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("TestCase: {1,4,6,8} expected: 0")
  void noOfficer(){
    int[] testCase = new int[]{1,4,6,8};
    int expected = 0;
    int actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("TestCase: {3, 4, 3, 0, 2, 2, 3, 0, 0} expected: 5")
  void validSmall(){
    int[] testCase = new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0};
    int expected = 5;
    int actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }
}
