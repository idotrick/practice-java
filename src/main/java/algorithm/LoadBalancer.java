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
    Set<Integer> uniqueBalancerLoadSet = new HashSet<>();

    for (int i = 0; i < A.length; i++) {
      totalLoad += A[i];
      uniqueBalancerLoadSet.add(A[i]);
    }

    Object[] uniqueBalancerLoadSetArray = uniqueBalancerLoadSet.toArray();
    for (int i = 0; i < uniqueBalancerLoadSetArray.length; i++) {
      for (int j = 1; j < uniqueBalancerLoadSetArray.length; j++) {
        int balancerLoad = (Integer) uniqueBalancerLoadSetArray[i] + (Integer) uniqueBalancerLoadSetArray[j];
        if ((totalLoad - balancerLoad) % 3 == 0) {
          return true;
        }
      }
    }

    return false;
  }
}
