package hackerrank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Prob1 {

    public static void main(String[] args) {
        System.out.println(1);
    }

    Map<Integer, Long> cache;

    long solution(int n) {
        if (n < 0) return -1;

        if (cache == null) {
            cache = new HashMap<>();
            cache.put(0, 0L);
            cache.put(1, 1L);
            cache.put(2, 1L);
        }

        if (!cache.containsKey(n)) {
            cache.put(n, solution(n - 1) + solution(n - 2));
        }

        return cache.get(n);
    }

    Prob1 subject;

    @BeforeEach
    void before() {
        subject = new Prob1();
    }

    @Test
    void test_fib0() {
        assertEquals(0, subject.solution(0));
    }

    @Test
    void test_fib1() {
        assertEquals(1, subject.solution(1));
    }

    @Test
    void test_fib2() {
        assertEquals(1, subject.solution(2));
    }

    @Test
    void test_fib3() {
        assertEquals(2, subject.solution(3));
    }

    @Test
    void test_fib4() {
        assertEquals(3, subject.solution(4));
    }

    @Test
    void test_fib5() {
        assertEquals(5, subject.solution(5));
    }

    @Test
    void test_fib6() {
        assertEquals(8, subject.solution(6));
    }

    @Test
    void test_fib49() {
        assertEquals(7778742049L, subject.solution(49));
    }


}
