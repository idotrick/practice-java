/**
 * Problem Copied from: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 *
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. The game uses Dense Ranking, so its leaderboard works like this:
 *
 *  - The player with the highest score is ranked number 1 on the leaderboard.
 *  - Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 * For example, the four players on the leaderboard have high scores of 100, 90, 90, and 80. Those players will have ranks 1, 2, 2, and 3, respectively. If Alice's scores are 70, 80 and 105, her rankings after each game are 4th, 3rd and 1st.
 *
 * >> Function Description
 *
 * Complete the climbingLeaderboard function. It should return an integer array where each element res[j] represents Alice's rank after the jth game.
 *
 * climbingLeaderboard has the following parameter(s):
 *
 *  - scores: an array of integers that represent leaderboard scores
 *  - alice: an array of integers that represent Alice's scores
 *
 * >> Input Format
 *
 * The first line contains an integer n, the number of players on the leaderboard.
 * The next line contains n space-separated integers scores[i], the leaderboard scores in decreasing order.
 * The next line contains an integer, m, denoting the number games Alice plays.
 * The last line contains m space-separated integers alice[j], the game scores.
 */

package algorithm;

import java.io.*;
import java.util.*;

public class ClimbingLeaderboard {

  private static int[] climbingLeaderboard(int[] scores, int[] alice) {
    if (alice == null || alice.length == 0) {
      return alice;
    } else {
      int[] ranks = new int[alice.length];
      int head = scores.length - 1;
      for (int i = 0; i < alice.length; i++) {
        if (i != 0 && alice[i - 1] == alice[i]) {
          ranks[i] = ranks[i - 1];
          continue;
        }

        if (scores == null || scores.length == 0 || alice[i] >= scores[0]) {
          ranks[i] = 1;
        } else {
          head = getHeadIdx(scores, alice[i], head);

          if (head == -1) {
            ranks[i] = 1;
          } else {
            if (i == 0) {
              Set<Integer> cache = new HashSet<>();
              for (int j = 0, k = 0; k < head + 1; j++) {
                if (cache.contains(scores[j])) {
                  --head;
                } else {
                  cache.add(scores[j]);
                  scores[k] = scores[j];
                  ++k;
                }
              }
            }
            if (alice[i] == scores[head]) {
              ranks[i] = head + 1;
            } else {
              ranks[i] = head + 2;
            }
          }
        }
      }
      return ranks;
    }
  }


  private static int getHeadIdx(int[] arr, int key, int head) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int min = 0;
    int max = head;
    while (min <= max) {
      int mid = (min + max) / 2;

      if (key == arr[mid]) {
        return mid;
      } else if (key > arr[mid]) {
        if (mid == 0) {
          return -1;
        } else {
          max = mid - 1;
        }
      } else {//key<arr[mid]
        if (mid == head || key > arr[mid + 1]) {
          return mid;
        } else {
          min = mid + 1;
        }
      }
    }

    return head;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int scoresCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] scores = new int[scoresCount];

    String[] scoresItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < scoresCount; i++) {
      int scoresItem = Integer.parseInt(scoresItems[i]);
      scores[i] = scoresItem;
    }

    int aliceCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] alice = new int[aliceCount];

    String[] aliceItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < aliceCount; i++) {
      int aliceItem = Integer.parseInt(aliceItems[i]);
      alice[i] = aliceItem;
    }

    int[] result = climbingLeaderboard(scores, alice);

    System.out.println("Alice's Ranks:");
    for (int i = 0; i < result.length; i++) {
      System.out.println(String.valueOf(result[i]));

      if (i != result.length - 1) {
        System.out.println("\n");
      }
    }

    scanner.close();
  }
}