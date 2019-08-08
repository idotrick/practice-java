/**
 * Company: Grab
 * Problem: Rank of army officers given in an array. Ex {3, 4, 3, 0, 2, 2, 3, 0, 0}. Any officer can report to a
 * superior officer with exactly one rank above his rank. multiple officers can report to same superior officer.
 * <p>
 * Find the number of officers who have a superior officer. Ex Answer = 5. because (2, 2, 3, 3, 3) have superior officer.
 *
 * Solution: Complexity O(NLog(N))
 */

package algorithm;

import java.util.*;

public class ReportingArmyOfficers {
  public int solution(int[] A) {
    if (null == A || A.length < 2) {
      return 0;
    }

    int reportingOfficerCnt = 0;
    Set<Integer> officerCache = new HashSet<>();
    Arrays.sort(A);

    for (int i = 1; i < A.length; i++) {
      int officer = A[i];
      int superior = officer + 1;
      if (officerCache.contains(superior)) {
        ++reportingOfficerCnt;
      } else {
        if (Arrays.binarySearch(A, superior) >= 0) {
          ++reportingOfficerCnt;
          officerCache.add(superior);
        }
      }
    }

    return reportingOfficerCnt;
  }
}
