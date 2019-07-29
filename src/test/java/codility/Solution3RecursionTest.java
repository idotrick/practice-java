package test.java.codility;

import main.java.codility.Solution3Recursion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution3RecursionTest {
    @Test
    @DisplayName("input: {1}, expected:1")
    public void test1A() {
        Solution3Recursion subject = new Solution3Recursion();
        int[] input = {1};
        int expected = 1;
        int actual = subject.solution(input);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input: {2, 1, 3, 5, 4}, expected:3")
    public void test1() {
        int expected, actual;
        int[] input = {2, 1, 3, 5, 4};
        expected = 3;
        actual = new Solution3Recursion().solution(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int expected, actual;
        int[] input = {2, 3, 4, 1, 5};
        expected = 2;
        actual = new Solution3Recursion().solution(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int expected, actual;
        int[] input = {1, 3, 4, 2, 5};
        expected = 3;
        actual = new Solution3Recursion().solution(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Input: Null")
    public void test4Null() {
        int expected, actual;
        int[] input = null;
        expected = 0;
        actual = new Solution3Recursion().solution(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Input: Empty")
    public void test4Empty() {
        int expected, actual;
        int[] input = {};
        expected = 0;
        actual = new Solution3Recursion().solution(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Input: Input[i] > Input.length")
    public void test5() {
        int expected, actual;
        int[] input = {1, 3, 4, 2, 6};
        expected = 0;
        actual = new Solution3Recursion().solution(input);
        assertEquals(expected, actual);
    }
}
