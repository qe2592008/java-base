package com.dh.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaTest {
  public static void main1(String[] args) {
    List<Integer> list = new ArrayList<>();
//    Integer[] s1 = {7,9};
//    Integer[] s2 = {0,2,4,5,6,8};
    Integer[] s1 = {1,2};
    Integer[] s2 = {0,2,4,5,6,8};
    List<Integer> list1 = Arrays.asList(s1);
    List<Integer> list2 = Arrays.asList(s2);
    int size = list1.size();
    int otherSize = list2.size();
    int j = 0;
    int i = 0;
    for(;i<size;) {
      int i1 = list1.get(i);//7--9
      if(j < otherSize) {//6
        for(;j < otherSize;) {
          int i2 = list2.get(j);
          if(i1 < i2) {
            list.add(i1);
            i++;
            break;
          } else {
            list.add(i2);
            j++;
          }
        }
      } else {
        list.add(i1);
        i++;
      }
    }
    if(i < list1.size()) {
      for(int m = i;m<list1.size();m++) {
        list.add(list1.get(m));
      }
    }
    if(j < list2.size()) {
      for(int n = j;n<list2.size();n++) {
        list.add(list2.get(n));
      }
    }
    for(int m = 0;m < list.size(); m++) {
      System.out.println(list.get(m));
    }
  }
  public static void main2(String[] args) {
    int i = Integer.valueOf("01");
    System.out.println(i);
  }
public static void main(String[] args) {
  List<String> ss = new ArrayList<>();
  ss.add("111");
  ss.toArray(new String[0]);

  Arrays.asList(new String[0]);
}
}
