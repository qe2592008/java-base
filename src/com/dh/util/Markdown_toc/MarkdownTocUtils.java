package com.dh.util.Markdown_toc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MarkdownTocUtils {
    public static void main(String[] args) throws IOException {
        // 为一个markdown文件生成目录
        // 1-获取文件
        String url = "F:\\GitHub Resource\\knowledgeNetwork\\README.md";
        FileReader fr = new FileReader(url);
        BufferedReader br=new BufferedReader(fr);
        // 2-解析文件
        String line="";
        List<String> list = new ArrayList<>();
        while((line=br.readLine())!=null){
            if (line.startsWith("#")){
                list.add(line);
            }
        }
        // 3-生成目录
        list.forEach(e ->{
            String[] ss = e.split(" ");
            String title = e.substring(e.indexOf(" ") + 1);
            String mulu = "- ["+ title+"](#"+ title +")";
            switch (ss[0].length()) {
                case 1:break;
                case 2:System.out.println(mulu);break;
                case 3:System.out.println("\t"+mulu);break;
                case 4:System.out.println("\t\t"+mulu);break;
                case 5:System.out.println("\t\t\t"+mulu);break;
                case 6:System.out.println("\t\t\t\t"+mulu);break;
            }
        });
    }


}
