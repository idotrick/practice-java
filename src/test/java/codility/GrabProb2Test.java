package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GrabProb2Test {
    GrabProb2 testObject = new GrabProb2();

    @Test
    @DisplayName("Input: A=0, B=0 Expected: <empty>")
    void twoZerors() {
        int A[] = new int[0];
        int expected = 2;
        int actual = testObject.solution(A);
        Assertions.assertEquals(expected, actual);
    }
}
