package com.dh.arithmetic;

/**
 * 堆排序
 *
 * @author donghao
 * @date 2019/3/28
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] ints = {3,9,5,1,10,7,2,4,6,8,2,3,4,11,23,54,33,9,100,50,44,23,43,56,90};
        // 构造大顶堆
        for(int i = 0; i < ints.length; i++) {
            int parent = -1;
            if(i > 0){
                int temp = i;
                do{
                    parent = (temp-1)/2;
                    if(ints[temp] > ints[parent]) {
                        int s = ints[parent];
                        ints[parent] = ints[temp];
                        ints[temp] = s;
                    }
                    temp = parent;
                } while (parent > 0);
            }
        }
        for(int i :ints) {
            System.out.print(i+ "_");
        }
        System.out.println();
        // 排序
        for (int j = ints.length-1;j > 0;j--) {
            int ding = 0;
            int m = ints[j];
            ints[j]= ints[ding];
            ints[ding] = m;
            int left, right = -1;
            String flag = "";
            do{
                flag = "";
                if((left = 2 * ding + 1) >= j) break;
                if((right = 2 * ding + 2) >= j && left < j) {
                    if (ints[ding] < ints[left]) flag = "left";
                } else {
                    if(ints[ding]<ints[left] && ints[ding]>=ints[right]) flag = "left";
                    else if(ints[ding]>=ints[left] && ints[ding] < ints[right]) flag = "right";
                    else if(ints[ding]<ints[left] && ints[ding]<ints[right]) flag = ints[left] >= ints[right] ? "left" : "right";
                }
                if(flag.equals("")) break;
                int temp = flag.equals("left") ? left : right;
                int ss = ints[ding];
                ints[ding] = ints[temp];
                ints[temp] = ss;
                ding = temp;
            }while(true);
        }
        // 遍历输出
        for(int i :ints) {
            System.out.print(i+ "_");
        }
    }
}
