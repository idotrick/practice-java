package codility;

import java.util.HashSet;
import java.util.Set;

public class Solution3Recursion {

    Set<Integer> onSet = new HashSet<>();
    Set<Integer> shiningSet = new HashSet<>();

    public int solution(int[] A){
        if(!isValidInput(A)){
            return 0;
        }

        //Input is valid
        int result=0;

        for(int i=0;i<A.length;i++){
            if(!isValidInputItem(A,A[i])) {
                return 0;
            }

            //Input item is valid
            onSet.add(A[i]);
            if(isShining(A[i],onSet)){
                shiningSet.add(A[i]);
                ++result;
            }
        }
        return result;
    }

    boolean isShining(int id, Set<Integer> onSet){
        if(id==1){
            if(onSet.contains(id)) {
                return true;
            } else {
                return false;
            }
        } else {
            int previousId = id - 1;
            if (!onSet.contains(previousId)) {
                return false;
            } else {
                if (shiningSet.contains(previousId)) {
                    return true;
                } else {
                    if (isShining(previousId, onSet)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    boolean isValidInput(int[] input){
        if(input==null || input.length==0){
            return false;
        }
        return true;
    }

    boolean isValidInputItem(int[] input, int inputItem){
        if(inputItem>input.length || inputItem<1){
            return false;
        }
        return true;
    }
}
