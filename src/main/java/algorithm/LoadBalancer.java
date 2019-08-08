/**
 * Company: Grab
 * Problem: Write a function solution that, given an array A of N integers representing the time of execution of
 * consecutive tasks, returns true if it is possible for the load balancer to chose two requests that will determine an
 * even distribution of requests among three workers, or false otherwise.
 * <p>
 * Examples:
 * 1. Given A = {1,3,4,2,2,2,1,1,2} function should return TRUE as load balancer by picking up request at index
 * 2 and  4 shall balance the load among other three workers at equal weight of 4.
 * <p>
 * 2. Given A = {1,1,1,1,1,1} function should return FALSE as there is no way the load balancer can balance requests
 * by picking up two arbitrary requests.
 * <p>
 * 3. Given A = {1,2,1,2,..., 1,2} of length 20,000, the function should return true.
 * <p>
 * Solution:
 * - Calculate : totalLoad
 * - Identify set of loads from which load balancer can pick : balancerLoadSetArray[]
 * - Pick two loads from balancerLoadSetArray[] at a time and sum : balancerLoad
 * - If ((totalLoad - balancerLoad) % 3 == 0) then return true
 * - If never return, return false
 */

package algorithm;


import java.util.HashSet;
import java.util.Set;

public class LoadBalancer {
  public boolean solution(int[] A) {

    if (A == null || A.length < 5) {
      return false;
    }

    int totalLoad = 0;
    Set<Integer> balancerLoadSet = new HashSet<>(); // loads from which load balancer can pick

    for (int i = 0; i < A.length; i++) {
      totalLoad += A[i];
      balancerLoadSet.add(A[i]);
    }

    Integer[] balancerLoadSetArray = balancerLoadSet.toArray(new Integer[balancerLoadSet.size()]);
    for (int i = 0; i < balancerLoadSetArray.length; i++) {
      for (int j = 1; j < balancerLoadSetArray.length; j++) {
        int balancerLoad = balancerLoadSetArray[i] + balancerLoadSetArray[j];
        if ((totalLoad - balancerLoad) % 3 == 0) {
          return true;
        }
      }
    }

    return false;
  }
}
