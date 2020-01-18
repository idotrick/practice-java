package codility;

import java.util.ArrayList;
import java.util.List;

public class GrabProb1 {

    public String solution(int U, int L, int[] C) {

        int[][] matrix1 = new int[2][C.length];
        int[][] matrix2 = new int[2][C.length];

        for (int i = 0; i < C.length; i++) {
            switch (C[i]) {
                case 1:
                    matrix1[0][i] = 1;
                    matrix1[1][i] = 0;
                    matrix2[1][i] = 1;
                    matrix2[0][i] = 0;
                    break;
                case 2:
                    matrix1[0][i] = 1;
                    matrix1[1][i] = 1;
                    matrix2[1][i] = 1;
                    matrix2[0][i] = 1;
                    break;
                case 0:
                    matrix1[0][i] = 0;
                    matrix1[1][i] = 0;
                    matrix2[1][i] = 0;
                    matrix2[0][i] = 0;
                    break;
            }
        }

        int matrix1U = 0;
        int matrix1L = 0;
        int matrix2U = 0;
        int matrix2L = 0;
        for (int i = 0; i < C.length; i++) {
            matrix1U += matrix1[0][i];
            matrix1L += matrix1[1][i];
            matrix2U += matrix2[0][i];
            matrix2L += matrix2[1][i];
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (matrix1U == U && matrix1L == L) {
            for (int i = 0; i < C.length; i++) {
                sb1.append(matrix1[0][i]);
                sb2.append(matrix1[1][i]);
            }
            sb1.append(",").append(sb2);
            return sb1.toString();
        } else if (matrix2U == U && matrix2L == L) {
            for (int i = 0; i < C.length; i++) {
                sb1.append(matrix2[0][i]);
                sb2.append(matrix2[1][i]);
            }
            sb1.append(",").append(sb2);
            return sb1.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}
