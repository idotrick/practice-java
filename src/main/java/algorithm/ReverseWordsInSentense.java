/*
 * Copyrights (c) 2019 IDoTrick. All rights reserved.
 */

package algorithm;

import java.util.Arrays;

/**
 * Type: Algorithmic Interview Question
 * Company: Grab Singapore
 * Problem: Reverse a sentence of words.
 */

public class ReverseWordsInSentense {

  public String solution(String s) {
    if(null == s || s.isEmpty()) {
      return s;
    }

    String[] splitArr = s.split(" ");
    String temp;
    for(int head=0,tail=splitArr.length-1; head<tail;head++,tail--) {
      temp = splitArr[head];
      splitArr[head] = splitArr[tail];
      splitArr[tail] = temp;
    }

    return String.join(" ", splitArr);
  }
}
