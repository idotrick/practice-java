/*
 * 1. Fibonacci series
 * Write a simple Java program which will print Fibonacci series
 * e.g. 1 1 2 3 5 8 13 ... . up to a given number. Be prepare for cross
 * questions like using iteration over recursion and how to optimize the
 * solution using caching and memoization.
 */

package main.java.algorithm;

import java.util.*;

public class Fibonacci {

  private static Map<Integer, Long> fibCache = new TreeMap<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Print Fibonacci Series upto: ");
    int n = in.nextInt();
    printFibSeriesUpTo(n);
  }

  public static void printFibSeriesUpTo(int n) {
    List<Long> fibSeries = new LinkedList<>();

    System.out.println("Printing Fibonacci Series using iteration upto " + n);
    for(int i=1;i<=n;i++) {
      fibSeries.add(fibonacciIteration(i));
    }
    System.out.println(fibSeries);

    System.out.println("Printing Fibonacci Series using improved recursion upto " + n);
    fibCache.put(1,Long.valueOf(1));
    fibCache.put(2,Long.valueOf(1));
    fibCache.put(n,fibonacciRecursionImproved(n));

    System.out.println(fibCache.values());

    System.out.println("Printing Fibonacci Series using recursion upto " + n);
    fibSeries.clear();
    for(int i=1;i<=n;i++) {
      fibSeries.add(fibonacciRecursion(i));
    }
    System.out.println(fibSeries);
  }

  // Return nth fibonacci using tail recursion
  public static long fibonacciRecursion(int n) {
    if(n==1 || n==2)
      return Long.valueOf(1);
    else
      return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
  }

  // Return nth fibonacci using tail recursion - improved
  public static long fibonacciRecursionImproved(int n) {
    if(n==1 || n==2)
      return Long.valueOf(1);

    if(!fibCache.containsKey(n)) {
      fibCache.put(n, (fibonacciRecursionImproved(n - 1) + fibonacciRecursionImproved(n - 2)));
    }

    return fibCache.get(n);
  }

  // Return nth fibonacci using iteration
  public static long fibonacciIteration(int n) {
    if(n==1 || n==2)
      return Long.valueOf(1);

    Long fib1=Long.valueOf(1), fib2=Long.valueOf(1), fibonacci=Long.valueOf(-1);

    for(int i=3;i<=n;i++) {
      fibonacci = fib1 + fib2;
      fib1 = fib2;
      fib2 = fibonacci;
    }

    return fibonacci;
  }
}
