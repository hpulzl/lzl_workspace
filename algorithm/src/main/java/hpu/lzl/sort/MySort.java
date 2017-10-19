package hpu.lzl.sort;

import java.util.Random;

/**
 * @Author: li_zhilei
 * @Date: create in 11:18 17/10/19.
 * @description:
 */
public class MySort {

    /**
     * 冒泡排序，复杂度为O(n2)
     * @param integers
     */
    public void bubbleSort(int[] integers){
        int length = integers.length;
        for (int i=0;i<length-1;i++){
            for (int j=i+1;j<length;j++){
                if (integers[j] < integers[i]){
                    swap(integers,i,j);
                }
            }
        }
    }

    private void swap(int[] integers,int i,int j){
        int temp;
        temp = integers[j];
        integers[j] = integers[i];
        integers[i] = temp;
    }
    /**
     * 选择排序，复杂度为O(n)
     * 每次只比较出N中的最小值放在数组元素的最前面。
     * @param arrs
     */
    public void selectorSort(int[] arrs){
        int length = arrs.length;
        int i,j,min;
        for (i=0;i<length-1;i++){
            //最小值从min开始
            min = i;
            for (j=i+1;j<length;j++){
                if (arrs[j] < arrs[i]) {
                    //重新设置最小值
                    min = j;
                    swap(arrs, i, min);
                }
            }
        }
    }

    public static void print(int[] arrs){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i=0;i<arrs.length;i++){
            sb.append(arrs[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void bobbleSortTest(){
        int[] integers = new int[10];
        Random random = new Random();
        for (int i=0;i<integers.length;i++){
            integers[i] = random.nextInt(100);
        }
        print(integers);
        System.out.println("=========");
        MySort mySort = new MySort();
        mySort.bubbleSort(integers);
       print(integers);
    }

    public static void selectorSortTest(){
        int[] integers = new int[10];
        Random random = new Random();
        for (int i=0;i<integers.length;i++){
            integers[i] = random.nextInt(100);
        }
        print(integers);
        System.out.println("=========");
        MySort mySort = new MySort();
        mySort.selectorSort(integers);
        print(integers);
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        selectorSortTest();
        long end = System.currentTimeMillis();
        System.out.println("sort use time " + (end - start));
//        bobbleSortTest();
    }
}
