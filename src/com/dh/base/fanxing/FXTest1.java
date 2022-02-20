package com.dh.base.fanxing;

import java.util.ArrayList;
import java.util.List;

public class FXTest1 {
  public static void main(String[] args) {
    List list = new ArrayList();
    List<?> list1 = new ArrayList<>();
    List<Object> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    List<? extends Object> list4 = new ArrayList<>();
    list3.add("hua");
    list3.add("cao");
    list1 = list3;
    list = list1;
    System.out.println(list.get(1));
    list1.add(null);
    list4 = list3;
    Object s = list1.get(1);


    List<father> fathers = new ArrayList<>();
    fathers.add(new son());
//    son ss = fathers.get(0);
  }
}
  class father{

  }
  class son extends father{

  }

