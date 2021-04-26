package com.isw.java.escape;

@SuppressWarnings("all")
public class ExceptionProcess {
  private static class User {}

  private void throwException() {
    User user = null;
    if (user == null) {
      throw new NullPointerException();
    }
  }

  private void cannotCatchNpeException() {
    try {
      throwException();
    } catch (ClassCastException classCastException) {
      System.out.println(classCastException.getMessage());
      System.out.println(classCastException.getClass().getName());
    }
  }

  private void canCatchNpeException() {
    try {
      throwException();
    } catch (ClassCastException classCastException) {
      System.out.println(classCastException.getMessage());
      System.out.println(classCastException.getClass().getName());
    } catch (NullPointerException nullPointerException) {
      System.out.println(nullPointerException.getMessage());
      System.out.println(nullPointerException.getClass().getName());
    }
  }

  public static void main(String[] args) {
    ExceptionProcess exceptionProcess = new ExceptionProcess();
    exceptionProcess.canCatchNpeException();
    exceptionProcess.cannotCatchNpeException();
  }
}
