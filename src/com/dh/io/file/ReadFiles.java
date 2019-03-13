package com.dh.io.file;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReadFiles {
    public static void main(String[] args) throws IOException, ParseException {
        String s = "20180930";
        String e = "20181231";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = sdf.parse(s);
        Date end = sdf.parse(e);
        int zhengjiannum=0;
        while(start.before(end)){
            String pp = sdf.format(start);
            String lu = "911101085712787947"+ pp +"240041";
            String url = "911101085712787947"+ pp +"240041.txt";
            String file = "C:\\Users\\Administrator\\Desktop\\Feedback\\"+lu+"\\"+url;
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

            BufferedReader br=new BufferedReader(fr);
            int total = 0;
            int jishu1 = 0;
            int jishu2 = 0;
            int jishu3 = 0;
            int jishu4 = 0;
            int jishu5 = 0;
            int jishu6 = 0;
            String text1 = "借款合同约定的起息日期，格式为yyyyMMdd";
            String text2 = "借款人和出借人债权债务关系的成立日期，格式为yyyyMMdd";
            String text3 = "借款合同约定的到期日期，格式为yyyyMMdd";
            String text4 = "证件号码不符合标准";
            String text5 = "实际还款记录不符合规则";
            String text6 = "借款剩余应付利息整数不超过15位，保留小数点后4位";
            String line="";
            String[] arrs=null;
            System.out.println("文件："+ lu+"\\"+ url);
            while ((line=br.readLine())!=null) {
                if(line.contains("错误信息列表")) continue;
                total++;
                if(line.contains(text1)) jishu1++;
                if(line.contains(text2)) jishu2++;
                if(line.contains(text3)) jishu3++;
                if(line.contains(text4)) jishu4++;
                if(line.contains(text5)) jishu5++;
                if(line.contains(text6)) jishu6++;
                if(!line.contains(text1) && !line.contains(text2) && !line.contains(text3) && !line.contains(text4) && !line.contains(text5) && !line.contains(text6)){
                    System.out.println(total+"--------"+line);
                }
            }
            System.out.println("总共"+ total +"行，不满足条件的有"+(total-jishu1-jishu2-jishu3-jishu4-jishu5-jishu6)+"行");
            br.close();
            fr.close();
            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.add(Calendar.DAY_OF_MONTH, 1);
            start = c.getTime();
        }
    }

}
