package com.isw.java.escape;

import java.util.ArrayList;

@SuppressWarnings("all")
public class BasicUsageNpe {

  private static boolean stringEquals(String x, String y) {
    if (x != null) {
      return x.equals(y);
    }
    throw new RuntimeException("The first string cannot be null");
  }

  public static class User {
    private String name;
  }

  public static void main(String[] args) {
    //
    //    System.out.println(stringEquals("xyz", null));
    //    System.out.println(stringEquals(null, "xyl"));

    //    User[] users = new User[10];
    //    for (int i = 0; i < users.length; i++) {
    //      users[i] = new User();
    //      users[i].name = "'imooc'" + i;
    //    }

    ArrayList<User> userArrayList = new ArrayList<>();
    User user = null;
    ArrayList<User> userArrayList_ = null;
    userArrayList.add(user);
    userArrayList.addAll(userArrayList_);
  }
}
