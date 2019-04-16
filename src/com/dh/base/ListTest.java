package com.dh.base;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
  public static void main(String[] args) {
    List<String> ss = new ArrayList<>();
    System.out.println(ss.get(-1));// Error
  }
}
