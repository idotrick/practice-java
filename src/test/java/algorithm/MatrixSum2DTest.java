package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatrixSum2DTest {
    MatrixSum2D testObject = new MatrixSum2D();

    @Test
    @DisplayName("Input: U=3, L=2, S={2,1,1,0,1} Expected: 11100,10001")
    void case1() {
        int S[] = {2, 1, 1, 0, 1};
        String expected = "11100,10001";
        String actual = testObject.solution(3, 2, S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Input: U=2, L=3, S={0,0,1,1,2} Expected: IMPOSSIBLE")
    void case2() {
        int S[] = {0, 0, 1, 1, 2};
        String expected = "IMPOSSIBLE";
        String actual = testObject.solution(2, 3, S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Input: U=2, L=2, S={2,0,2,0} Expected: 1010,1010")
    void case3() {
        int S[] = {2, 0, 2, 0};
        String expected = "1010,1010";
        String actual = testObject.solution(2, 2, S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Input: U=2, L=2, S={0,0,0,0} Expected: IMPOSSIBLE")
    void case4() {
        int S[] = {0, 0, 0, 0};
        String expected = "IMPOSSIBLE";
        String actual = testObject.solution(2, 2, S);
        Assertions.assertEquals(expected, actual);
    }
}
