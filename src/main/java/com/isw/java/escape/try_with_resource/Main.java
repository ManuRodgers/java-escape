package com.isw.java.escape.try_with_resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 *
 * <h1>try to solve the problem of resource leak caused by try catch finally</h1>
 */
public class Main {
  /**
   *
   *
   * <h2>traditional method to deal with the resource leak caused by try catch and finally</h2>
   *
   * @return
   * @throws IOException
   */
  private String traditionalTryCatchFinally() throws IOException {
    //   1. single resource
    //    BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
    //    String line = null;
    //    try {
    //      line = bufferedReader.readLine();
    //    } finally {
    //      bufferedReader.close();
    //    }
    //    return line;
    // 2. multiple resources close
    //    first resource
    try (FileInputStream fileInputStream = new FileInputStream("");
        FileOutputStream fileOutputStream = new FileOutputStream("")) {
      //      second resource
      byte[] buffer = new byte[100];
      int n;
      while ((n = fileInputStream.read(buffer)) > -1) {
        fileOutputStream.write(buffer, 0, n);
      }
    }
    return null;
  }

  public static void main(String[] args) throws Exception {

    try (AutoClose close = new AutoClose(); ) {
      close.work();
    }
  }
}
