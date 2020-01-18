package algorithm;

public class StringOfLetterABCount {
    public String solution(int A, int B) {
        if ((A == 0 && B == 0) || (A == 0 && B > 2) || (B == 0 && A > 2)) {
            return "";
        }

        StringBuilder sb = new StringBuilder(A + B);

        if (A >= B) {
            return findWord(sb, A, B, 0, 0, true);
        } else {
            return findWord(sb, A, B, 0, 0, false);
        }
    }

    public String findWord(StringBuilder sb, int ACntLeft, int BCntLeft, int APrevCnt, int BPrevCnt, boolean isAMajor) {

        // Base case: String found
        if (ACntLeft == 0 && BCntLeft == 0) {
            return sb.toString();
        }

        if (isAMajor) {
            if (ACntLeft > 0 && APrevCnt < 2) {
                return findWord(new StringBuilder(sb).append("a"), --ACntLeft, BCntLeft, ++APrevCnt, 0, isAMajor);
            }

            if (BCntLeft > 0 && BPrevCnt < 2) {
                return findWord(new StringBuilder(sb).append("b"), ACntLeft, --BCntLeft, 0, ++BPrevCnt, isAMajor);
            }
        } else {
            if (BCntLeft > 0 && BPrevCnt < 2) {
                return findWord(new StringBuilder(sb).append("b"), ACntLeft, --BCntLeft, 0, ++BPrevCnt, isAMajor);
            }

            if (ACntLeft > 0 && APrevCnt < 2) {
                return findWord(new StringBuilder(sb).append("a"), --ACntLeft, BCntLeft, ++APrevCnt, 0, isAMajor);
            }
        }

        return "";
    }
}
