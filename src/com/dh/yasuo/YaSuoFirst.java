package com.dh.yasuo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 第一步压缩：将文件夹中的pdf书籍加密压缩，需要随机生成压缩密码，并将压缩完成的文件名称和密码输出到excel中
 *
 * @author donghao
 * @date 2019/9/1
 */
public class YaSuoFirst {

  public static void main(String[] args) {
    String basePath = "G:/Books/ceshi";
    File baseFile = new File(basePath);
    File[] pdfFiles = baseFile.listFiles();
    System.out.println("该目录下对象个数："+pdfFiles.length);
    List<RecordFirst> recordFirsts = new ArrayList<>();
    for(File file : pdfFiles) {
      if(file.isDirectory()) {
        continue;
      }
      String fileName = file.getName();
      fileName = fileName.substring(0,fileName.length()-4);
      // 针对每个pdf进行加密处理
      // 首先生成密码
      String password = createPassword();
      StringBuffer cmd = new StringBuffer("C:/Program Files/WinRAR/WinRAR.exe");
      cmd.append("  a -p");
      cmd.append(password);//压缩密码
      cmd.append(" -ibck -ep ");//-ibck命令为后台压缩
      cmd.append("G:/Books/ceshirar/"+fileName);//压缩后zip文件的路径
      cmd.append(" ");
      cmd.append(file.getAbsolutePath());
      try{
        Process proc = Runtime.getRuntime().exec(cmd.toString());
        if (proc.waitFor() != 0)//waitFor将返回exitValue的值0表示正常结束
          return;
        System.out.println(fileName + "--" + password);
      }catch(Exception e){

      }
      recordFirsts.add(new RecordFirst(fileName,password));
    }
    System.out.println("完毕");
    // 将list中内容写入excel

  }

  /**
   * 生成10位随机密码
   *
   * @author donghao
   * @date 2019/9/1 13:13
   * @param
   * @return java.lang.String
   * @throws
   */
  private static String createPassword() {
    String base = "DONGHAODEWANGZHUANMIMA2";
    String batchBase = "PILIANGSHENGCHENGMIMA";
    String totalBase = base+batchBase;
    String[] totalBaseArray = totalBase.split("");
    StringBuilder sb = new StringBuilder();
    for(int j = 0;j< 10;j++) {
      int m = (int)(Math.random()*totalBase.length());
      String b = totalBaseArray[m];
      sb.append(b);
    }
    String mima = sb.toString();
    return mima;
  }

  static class RecordFirst{
    private String fileName;
    private String password;

    public RecordFirst() {
    }

    public RecordFirst(String fileName, String password) {
      this.fileName = fileName;
      this.password = password;
    }

    public String getFileName() {
      return fileName;
    }

    public void setFileName(String fileName) {
      this.fileName = fileName;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
}
