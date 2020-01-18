package corejava;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class ParseStringToInteger {
    public static void main(String[] args) {
        System.out.println(new ParseStringToInteger().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (!isValidInput(num1, num2)) return "";

        if (isContainZeroParam(num1, num2)) return "0";

        StringBuilder answerBuilder = new StringBuilder(num1.length() + num2.length());
/*
    for(int n2Idx=num2.length()-1,pos1=0; n2Idx>=0; n2Idx--,pos1++) {
      int n2Digit = num2.charAt(n2Idx)-'0';

      for(int n1Idx=num1.length()-1,pos=pos1; n1Idx>=0; n1Idx--,pos++) {
        int n1Digit = num1.charAt(n1Idx)-'0';
        int val = n1Digit*n2Digit;

        if(answerBuilder.length()>pos) {
          val += answerBuilder.charAt(pos)-'0';
          answerBuilder.replace(pos, pos+1, String.valueOf(val%10));
        } else {
          answerBuilder.append(val%10);
        }

        int overflow = val/10;
        if(overflow>0) {
          if (answerBuilder.length() > pos + 1) {
            answerBuilder.replace(pos+1, pos+2, String.valueOf(overflow));
          } else {
            answerBuilder.append(overflow);
          }
        }
      }
    }
*/
        return answerBuilder.reverse().toString();
    }

    private boolean isValidInput(String num1, String num2) {
        return !(null == num1 || null == num2);
    }

    private boolean isContainZeroParam(String num1, String num2) {
        return isValidInput(num1, num2) && (num1.charAt(0) == '0' || num2.charAt(0) == '0');
    }
}
