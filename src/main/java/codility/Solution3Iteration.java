package codility;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution3Iteration {

    SortedSet<Integer> shiningSet = new TreeSet<>();

    public int solution(int[] A) {
        if (!isValidInput(A)) {
            return 0;
        }

        //Input is valid
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (!isValidInputItem(A, A[i])) {
                return 0;
            }

            if (A[i] == 1 || (shiningSet.size() == shiningSet.last() && shiningSet.size() == A[i] - 1)) {
                shiningSet.add(A[i]);
                ++result;
            }
        }
        return result;
    }

    boolean isValidInput(int[] input) {
        if (input == null || input.length == 0) {
            return false;
        }
        return true;
    }

    boolean isValidInputItem(int[] input, int inputItem) {
        if (inputItem > input.length || inputItem < 1) {
            return false;
        }
        return true;
    }
}
