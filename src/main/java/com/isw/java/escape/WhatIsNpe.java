package com.isw.java.escape;

public class WhatIsNpe {

  public static class User {
    private String name;
    private String[] addresses;

    public void print() {
      System.out.println("This is User class");
    }

    public String readBookString() {
      System.out.println("User read Imooc Escape");
      //      we should try to not return null in order to avoid NullPointerException
      return null;
    }
  }

  public static class CustomException extends RuntimeException {}

  public static void main(String[] args) {

    // User user = new User();
    // System.out.println(user.addresses.length);

    CustomException customException = null;
  }
}
