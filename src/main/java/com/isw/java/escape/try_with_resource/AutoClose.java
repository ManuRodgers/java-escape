package com.isw.java.escape.try_with_resource;

public class AutoClose implements AutoCloseable {

  @Override
  public void close() throws Exception {
    System.out.println(">>> in close()");
    throw new Exception("Exception in close");
  }

  public void work() throws MyException {
    System.out.println(">>> in work()");
    throw new MyException("Exception in work method");
  }
}
