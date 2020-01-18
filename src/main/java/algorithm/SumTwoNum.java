package algorithm;

import java.util.HashMap;
import java.util.Map;

public class SumTwoNum {
    public int[] solution(int[] A, int sum) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int complement = sum - A[i];
            if (i == 0) {
                cache.put(complement, i);
            } else {
                if (cache.containsKey(A[i])) {
                    int[] result = {cache.get(A[i]), i};
                    return result;
                } else {
                    cache.put(complement, i);
                }
            }
        }

        return null;
    }

}