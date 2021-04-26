package com.isw.java.escape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UnboxingNpe {

  public static int add(int x, int y) {
    return x + y;
  }

  public static boolean compare(long x, long y) {
    return x >= y;
  }

  public static void main(String[] args) {
    //    Long count = null;
    //    long count_ = count;
    //    Integer left = null;
    //    Integer right = null;
    //    System.out.println(add(left, right));
    //    Long left = 10L;
    //    Long right = null;
    //    System.out.println(compare(left, right));
  }
}
