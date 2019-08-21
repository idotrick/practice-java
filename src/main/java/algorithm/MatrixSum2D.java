/**
 * Given inputs U, L & S[] find one possible matrix that fulfils following criteria.
 * • Matrix shall hold 0 or 1 only
 * • Matrix shall have two rows only
 * • Matrix shall have S.length number of columns
 * • Upper row values sum should equals to U
 * • Lower row values sum should equals to L
 * • Each column sum should equals to corresponding element of S
 * • If such a matrix found return the matrix as a string of two integers separated by comma
 * • If no such matrix is found return IMPOSSIBLE
 * <p>
 * e.g. 1: U=3, L=2, S=[2,1,1,0,1] expected 11100,10001
 * e.g. 2: U=2, L=3, S=[0,0,1,1,2] expected IMPOSSIBLE
 * e.g. 3: U=2, L=2, S=[2,0,2,0] expected 1010,1010
 */
package algorithm;

import java.security.PublicKey;
import java.util.Arrays;

public class MatrixSum2D {
  public static String IMPOSSIBLE = "IMPOSSIBLE";

  public String solution(int U, int L, int[] S) {
    if (null == S || S.length == 0) {
      return IMPOSSIBLE;
    }

    int[][] M = new int[2][S.length];
    int UBal = U;
    int LBal = L;

    for (int i = 0; i < S.length; i++) {
      // Find possible values for the matrix column
      int possibleValues;
      switch (S[i]) {
        case 0:
          possibleValues = 0;
          break;
        case 1:
          possibleValues = 10;
          break;
        case 2:
          possibleValues = 1;
          break;
        default:
          return IMPOSSIBLE;
      }

      // Assign values to matrix column based on possible values and row sum (U/L)
      switch (possibleValues) {
        case 0:
          M[0][i] = 0;
          M[1][i] = 0;
          break;
        case 1:
          if (UBal > 0 && LBal > 0) {
            M[0][i] = 1;
            M[1][i] = 1;
            --UBal;
            --LBal;
          } else {
            return IMPOSSIBLE;
          }
          break;
        case 10:
          if (UBal > 0) {
            M[0][i] = 1;
            M[1][i] = 0;
            --UBal;
          } else if (LBal > 0) {
            M[0][i] = 0;
            M[1][i] = 1;
            --LBal;
          } else {
            return IMPOSSIBLE;
          }
          break;
        default:
          return IMPOSSIBLE;
      }
    }

    if (UBal == 0 && LBal == 0) {
      return Arrays
          .deepToString(M)
          .replaceAll(",|\\s|\\[\\[|\\]\\]", "")
          .replace("][", ",");
    } else {
      return IMPOSSIBLE;
    }
  }
}
