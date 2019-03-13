package com.dh.io.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class IndentityFind {
    public static void main(String[] args) throws ParseException, IOException {
        String s = "20180930";
        String e = "20190101";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = sdf.parse(s);
        Date end = sdf.parse(e);
        Map<String,String> map = new HashMap<>();
        while(start.before(end)){
            String pp = sdf.format(start);
            System.out.print(pp+"：");
            String lu = "911101085712787947"+ pp +"240041";
            String lu2 = "911101085712787947"+ pp +"24004";
            String url = "911101085712787947"+ pp +"240041.txt";
            String url3 = "24EXPORTBUSINESSZHAIQ.txt";
            String url2 = "24EXPORTBUSINESSZHAIQ_BOR.txt";
            String file = "C:\\Users\\Administrator\\Desktop\\Feedback\\"+lu+"\\"+url;
            String file2 = "C:\\Users\\Administrator\\Desktop\\our\\Feedback\\"+lu2+"\\"+url2;
            String file3 = "C:\\Users\\Administrator\\Desktop\\our\\Feedback\\"+lu2+"\\"+url3;
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch(FileNotFoundException ee) {
                System.out.println("不存在文件"+url);
                Calendar c = Calendar.getInstance();
                c.setTime(start);
                c.add(Calendar.DAY_OF_MONTH, 1);
                start = c.getTime();
                continue;
            }
            int num = 0;
            String line="";
            BufferedReader br=new BufferedReader(fr);
            while ((line=br.readLine())!=null) {
                if(line.contains("证件号码不符合标准")){
                    num++;
                    String id = line.substring(42,67);
                    FileReader fr2 = new FileReader(file2);
                    BufferedReader br2=new BufferedReader(fr2);
                    String line2 = "";
                    String identity = "";
                    while((line2=br2.readLine())!=null){
                        if(line2.contains(id)){
                            identity = line2.substring(41,59);
                            break;
                        }
                    }
                    br2.close();
                    fr2.close();
                    FileReader fr3 = new FileReader(file3);
                    BufferedReader br3=new BufferedReader(fr3);
                    String line3 = "";
                    String iteId = "";
                    while((line3=br3.readLine())!=null){
                        if(line3.contains(id)){
                            iteId = line3.substring(47,53);
                            break;
                        }
                    }
                    br3.close();
                    fr3.close();
                    map.put(iteId,identity);
                }
            }
            br.close();
            fr.close();
            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.add(Calendar.DAY_OF_MONTH, 1);
            start = c.getTime();
            System.out.print(num + "\n");
        }
        Set<String> itemSet = new HashSet<>();
        Set<String> indentySet = new HashSet();
        map.forEach((k,v)->{
            itemSet.add(k);
            indentySet.add(v);
//            System.out.println(k + "---" + v);
        });
        System.out.println("对的数量："+map.size());
        System.out.println("项目数量："+itemSet.size());
        System.out.println("用户数量："+indentySet.size());
    }
}
