package codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution2Test {
    @Test
    public void test1() {
        int expected, actual;
        int input = 955;
        expected = 4;
        actual = new Solution2().solution(input);
        assertEquals(expected, actual);
    }
}
