package algorithm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RecursiveSteps {

    private static Map<Integer, Integer> permsMap = new HashMap<>();
    private static Map<Integer, Integer> resultMap = new LinkedHashMap<>();

    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        if (!permsMap.containsKey(n)) {
            permsMap.put(n, stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3));
        }

        return permsMap.get(n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            permsMap.clear();
            permsMap.put(1, 1);
            permsMap.put(2, 2);
            permsMap.put(3, 4);
            int res = stepPerms(n);

            resultMap.put(n, res);
        }

        System.out.println("output: " + resultMap);

        scanner.close();
    }
}

/*
Problem:

Davis has a number of staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase, module  on a new line.

For example, there is  staircase in the house that is  steps high. Davis can step on the following sequences of steps:

1 1 1 1 1
1 1 1 2
1 1 2 1
1 2 1 1
2 1 1 1
1 2 2
2 2 1
2 1 2
1 1 3
1 3 1
3 1 1
2 3
3 2

There are  possible ways he can take these  steps.

Function Description

Complete the stepPerms function in the editor below. It should recursively calculate and return the integer number of ways Davis can climb the staircase, modulo 10000000007.

stepPerms has the following parameter(s):

n: an integer, the number of stairs in the staircase
Input Format

The first line contains a single integer, , the number of staircases in his house.
Each of the following  lines contains a single integer, , the height of staircase .

Constraints

Subtasks

 for  of the maximum score.
Output Format

For each staircase, return the number of ways Davis can climb it as an integer.

Sample Input

3
1
3
7
Sample Output

1
4
44
Explanation

Let's calculate the number of ways of climbing the first two of the Davis'  staircases:

The first staircase only has  step, so there is only one way for him to climb it (i.e., by jumping  step). Thus, we print on a new line.
The second staircase has  steps and he can climb it in any of the four following ways:
Thus, we print  on a new line.

Solution:

First find out the pattern of output against the Input

1 -> 	1		->1
2 -> 	1,1		->2
		2
3 ->	1,1,1	->4
		1,2
		2,1
		3
4 ->	1,1,1,1	->7
		1,1,2
		1,2,1
		2,1,1
		2,2
		1,3
		3,1
5 ->	1,1,1,1,1->13
		1,1,1,2
		1,2,1,1
		2,1,1,1
		1,2,2
		2,2,1
		1,1,3
		3,1,1
		2,3
		3,2
6 ->24

7 ->44

It forms a series as follows.
1, 2, 4, 7, 13, 24, 44...

Hence, following formula can be derived.
T(n) = T(n-1) + T(n-2) + T(n-3) where T(1) = 1, T(2) = 2 & T(3) = 4
*/
