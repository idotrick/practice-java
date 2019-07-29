package util;
/*
  * This program shows how to take input from console to the java program.
  * There are 3 ways to take input.
  *   1. java.io.BufferredReader
  *   2. java.util.Scanner
  *   3. java.io.Console
  *
  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.Console;

class ConsoleReader {
  public static void main(String[] args) throws IOException {
      // BufferredReader example
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Read string from BufferredReader: ");
      String name = br.readLine();
      System.out.println("Value read by BufferredReader: "+name);

      // Scanner example. Pros: easy parsing (nextInt(), nextFloat())
      Scanner sc = new Scanner(System.in);
      System.out.print("Read string from Scanner: ");
      name = sc.next();
      System.out.println("Value read by Scanner: "+name);

      // Scanner example Pros: read password strings (console.readPassword)
      Console cncl = System.console();
      System.out.print("Read string from ConsoleReader: ");
      char[] nameArr = cncl.readPassword();
      System.out.println("Value read by ConsoleReader: "+String.valueOf(nameArr));
  }
}
