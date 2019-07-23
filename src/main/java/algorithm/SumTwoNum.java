package main.java.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SumTwoNum {
    int[] solution(int[] A, int sum) {
        Map<Integer,Integer> cache = new HashMap<>();

        for(int i=0;i<A.length;i++) {
            int complement=sum-A[i];
            if(i==0) {
                cache.put(complement,i);
            } else {
                if(cache.containsKey(A[i])) {
                    int[] result = {cache.get(A[i]),i};
                    return result;
                } else {
                    cache.put(complement,i);
                }
            }
        }

        return null;
    }

}

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
