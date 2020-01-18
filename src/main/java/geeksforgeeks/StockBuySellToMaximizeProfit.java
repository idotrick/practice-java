package geeksforgeeks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Stock Buy Sell to Maximize Profit
 *
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in
 * those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by
 * buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in
 * decreasing order, then profit cannot be earned at all.
 *
 * @Input: Array A of stock values. e.g. {100, 180, 260, 310, 40, 535, 695}
 * @Output: Array R of sequence in which makes maximum profit. e.g. {0, 3, 4, 6}
 */

public class StockBuySellToMaximizeProfit {
    enum State {
        BUY, SELL;
    }

    int[] solution(int[] A) {
        if (null == A || A.length == 0) return null;

        List<Integer> result = new ArrayList<>();
        State state = State.BUY;

        for(int i=0;i < A.length;i++) {
            if(state == State.BUY) {
                while(A.length > i+1 && A[i]>A[i+1]) {
                    ++i;
                }
                state = State.SELL;
            } else {
                while(A.length > i+1 && A[i]<A[i+1]) {
                    ++i;
                }
                state = State.BUY;
            }

            result.add(i);
        }

        if(state == State.SELL) {
            result.remove(result.size()-1);
        }

        return result.stream().mapToInt(i->i).toArray();

    }

    @Test
    void t1(){
        int[] input = null;
        int[] expected = null;

        assertEquals(null,solution(null));
    }

    @Test
    void t2(){
        int[] input = {100, 180, 260, 310, 40, 535, 695};
        int[] expected = {0, 3, 4, 6};

        assertArrayEquals(expected,solution(input));
    }

    @Test
    void t3(){
        int[] input = {100, 180, 260, 310, 40, 535};
        int[] expected = {0, 3, 4, 5};

        assertArrayEquals(expected,solution(input));
    }

    @Test
    void t4(){
        int[] input = {100, 180, 260, 310, 40};
        int[] expected = {0, 3};

        assertArrayEquals(expected,solution(input));
    }

}
