package com.solutions.Chapter1;

import java.util.Arrays;

/***
 *
 * Simple StringBuilder Implementation in Java
 ***/

public class StringBuilder{

  private char[] strBuffer;
  private int capacity;
  private int length;

  public StringBuilder() {
    this.strBuffer = new char[16];
    this.length = 0;
  }

  public void append(String string) {
    if(string == null) string = "null";
    char[] newStringBuffer = string.toCharArray();
    int newStringLength = newStringBuffer.length;
    if(overFlow(newStringLength)){
      this.strBuffer = Arrays.copyOf(strBuffer , 2*strBuffer.length + newStringLength);
    }
    for (final char aNewStringBuffer : newStringBuffer) {
      this.strBuffer[length++] = aNewStringBuffer;
    }
  }

  private boolean overFlow(final int sizeOfNewString) {
    return length + sizeOfNewString > this.strBuffer.length;
  }

  public String getString() {
    return new String(strBuffer);
  }
}