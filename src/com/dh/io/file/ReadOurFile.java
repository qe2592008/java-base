package com.dh.io.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReadOurFile {
    public static void main(String[] args) throws IOException, ParseException {
        String s = "20180930";
        String e = "20181231";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = sdf.parse(s);
        Date end = sdf.parse(e);
        while(start.before(end)){
            String pp = sdf.format(start);
            String lu = "911101085712787947"+ pp +"24004";
            String file = "C:\\Users\\Administrator\\Desktop\\our\\Feedback\\"+lu+"\\24EXPORTBUSINESSZHAIQ_INV.txt";
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch(FileNotFoundException ee) {
                System.out.println("不存在文件"+file);
                Calendar c = Calendar.getInstance();
                c.setTime(start);
                c.add(Calendar.DAY_OF_MONTH, 1);
                start = c.getTime();
                continue;
            }
            BufferedReader br=new BufferedReader(fr);
            String line="";
            Map<String, Integer> map = new HashMap<>();
            while ((line=br.readLine())!=null) {
                String iteId = line.substring(0,25);
                if(map.get(iteId)!= null){
                    map.put(iteId,map.get(iteId)+1);
                }else
                    map.put(iteId,1);
            }
            map.forEach((k,v)->{
                if(v>1){
                    System.out.println(k+"---"+v);
                }
            });
            br.close();
            fr.close();
            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.add(Calendar.DAY_OF_MONTH, 1);
            start = c.getTime();
        }










    }
}
