package test.java.algorithm;

import algorithm.SumTwoNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SumTwoNumTest {
  SumTwoNum subject = new SumTwoNum();

  @Test
  @DisplayName("Input1={2,7,5}, Input2=9, Expected: {0,1}")
  void test1(){
    int[] input1={2,7,5};
    int input2=9;
    int[] expected={0,1};
    int[] actual=subject.solution(input1,input2);

    assertArrayEquals(expected,actual);
  }

  @Test
  @DisplayName("Input1={1,2,7,5}, Input2=9, Expected: {1,2}")
  void test2(){
    int[] input1={1,2,7,5};
    int input2=9;
    int[] expected={1,2};
    int[] actual=subject.solution(input1,input2);

    assertArrayEquals(expected,actual);
  }

  @Test
  @DisplayName("Input1={1,2,7,5}, Input2=20, Expected: null")
  void test3(){
    int[] input1={1,2,7,5};
    int input2=20;
    int[] expected=null;
    int[] actual=subject.solution(input1,input2);

    assertArrayEquals(expected,actual);
  }

  @Test
  @DisplayName("Input1={2,3,7,4,8}, Input2=7, Expected: {1,3}")
  void test5(){
    int[] input1={2,3,7,4,8};
    int input2=7;
    int[] expected={1,3};
    int[] actual=subject.solution(input1,input2);

    assertArrayEquals(expected,actual);
  }
}
