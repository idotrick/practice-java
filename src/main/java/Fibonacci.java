/*
 * 1. Fibonacci series
 * Write a simple Java program which will print Fibonacci series
 * e.g. 1 1 2 3 5 8 13 ... . up to a given number. Be prepare for cross
 * questions like using iteration over recursion and how to optimize the
 * solution using caching and memoization.
 */

import java.util.*;

public class Fibonacci {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    System.out.print("Print Fibonacci Series upto: ");
    int n = in.nextInt();
    printFibSeriesUpTo(n);
  }

  public static void printFibSeriesUpTo(int n) {
    System.out.println("Printing Fibonacci Series Up to " + n);

    List<Integer> fibSeries = new LinkedList<>();
    for(int i=1;i<=n;i++) {
      fibSeries.add(fib(i));
    }

    System.out.print(fibSeries);
  }

  public static int fib(int n) {
    if(n==1 || n==2) {
      return 1;
    } else {
      return fib(n-1) + fib(n-2);
    }
  }
}
