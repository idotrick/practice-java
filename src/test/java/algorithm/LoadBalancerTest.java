package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class LoadBalancerTest {
  LoadBalancer testObject = new LoadBalancer();

  @Test
  void nullArray(){
    int[] testCase = null;
    boolean expected = false;
    boolean actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void EmptyArray(){
    int[] testCase = new int[0];
    boolean expected = false;
    boolean actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void tooShortArray(){
    int[] testCase = new int[4];
    boolean expected = false;
    boolean actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void sampleTrueCase(){
    int[] testCase = new int[]{1,3,4,2,2,2,1,1,2};
    boolean expected = true;
    boolean actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void sampleFalseCase(){
    int[] testCase = new int[]{1,1,1,1,1,1};
    boolean expected = false;
    boolean actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void sampleTrueCaseBig(){
    int[] testCase = new int[20000];
    for(int i=0;i<testCase.length;i++) {
      if(i%2==0)
        testCase[i] = 2;
      else
        testCase[i] = 1;
    }
    boolean expected = true;
    boolean actual = testObject.solution(testCase);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void sampleTrueCaseBigWithTimeOut(){
    int[] testCase = new int[20000];
    for(int i=0;i<testCase.length;i++) {
      if(i%2==0)
        testCase[i] = 2;
      else
        testCase[i] = 1;
    }
    boolean expected = true;
    boolean actual = Assertions.assertTimeout(Duration.ofSeconds(Long.valueOf(1)), () ->  testObject.solution(testCase));
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void sampleTrueCaseVeryBig(){
    int[] testCase = new int[100000];
    for(int i=0;i<testCase.length;i++) {
      if(i%2==0)
        testCase[i] = 2;
      else
        testCase[i] = 1;
    }
    boolean expected = true;
    boolean actual = Assertions.assertTimeout(Duration.ofSeconds(1), () -> testObject.solution(testCase));
    Assertions.assertEquals(expected, actual);
  }
}
