package com.dh.wangzhuanmima;

import java.util.Random;

public class MimaCreater {


  public static void main(String[] args) {
    String base = "DONGHAODEWANGZHUANMIMA2";
    batchCreate(100, base);
  }

  // 批量生成16位密码
  private static void batchCreate(int count, String base) {
    String batchBase = "PILIANGSHENGCHENGMIMA";
    String totalBase = base+batchBase;
    String[] totalBaseArray = totalBase.split("");
    for(int i = 0;i<count;i++) {
      StringBuilder sb = new StringBuilder();
      for(int j = 0;j< 10;j++) {
        int m = (int)(Math.random()*totalBase.length());
        String b = totalBaseArray[m];
        sb.append(b);
      }
      String mima = sb.toString();
      System.out.println(mima);
    }
  }
}
