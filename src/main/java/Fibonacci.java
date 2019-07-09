/*
 * 1. Fibonacci series
 * Write a simple Java program which will print Fibonacci series
 * e.g. 1 1 2 3 5 8 13 ... . up to a given number. Be prepare for cross
 * questions like using iteration over recursion and how to optimize the
 * solution using caching and memoization.
 */

import java.util.*;

public class Fibonacci {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Print Fibonacci Series upto: ");
    int n = in.nextInt();
    printFibSeriesUpTo(n);
  }

  public static void printFibSeriesUpTo(int n) {
    List<Integer> fibSeries = new LinkedList<>();

    System.out.println("Printing Fibonacci Series using recursion upto " + n);
    for(int i=1;i<=n;i++) {
      fibSeries.add(fibonacciRecursion(i));
    }
    System.out.println(fibSeries);
    fibSeries.clear();

    System.out.println("Printing Fibonacci Series using iteration upto " + n);
    for(int i=1;i<=n;i++) {
      fibSeries.add(fibonacciIteration(i));
    }
    System.out.println(fibSeries);
  }

  // Return nth fibonacci using tail recursion
  public static int fibonacciRecursion(int n) {
    if(n==1 || n==2)
      return 1;
    else
      return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
  }

  // Return nth fibonacci using iteration
  public static int fibonacciIteration(int n) {
    if(n==1 || n==2)
      return 1;

    int fib1=1, fib2=1, fibonacci=-1;

    for(int i=3;i<=n;i++) {
      fibonacci = fib1 + fib2;
      fib1 = fib2;
      fib2 = fibonacci;
    }

    return fibonacci;
  }
}
