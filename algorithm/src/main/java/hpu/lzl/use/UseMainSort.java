package hpu.lzl.use;

import hpu.lzl.sort.MySort;

import java.util.Random;

/**
 * @Author: li_zhilei
 * @Date: create in 14:48 17/10/27.
 * @description:各种排序算法的测试类
 */
public class UseMainSort {

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

    public static void quickSortTest(){
        int[] a = new int[20];
        Random random = new Random();
        for (int i=0;i<a.length;i++){
            a[i] = random.nextInt(100);
        }
        print(a);
        MySort mySort = new MySort();
        mySort.quickSort(a,0,a.length - 1);
        System.out.println("=========");
        print(a);
    }

    public static void binaryInsertionSortTest(){
//        int[] integers = new int[5];
//        Random random = new Random();
//        for (int i=0;i<integers.length;i++){
//            integers[i] = random.nextInt(100);
//        }
        int[] a = new int[]{2,4,5,6,3,7,8,9,10};
        print(a);
        MySort mySort = new MySort();
        mySort.binaryInsertionSort(a);
        System.out.println("=========");
        print(a);
    }
    public static void insertionSortTest(){
        int[] integers = new int[10];
        Random random = new Random();
        for (int i=0;i<integers.length;i++){
            integers[i] = random.nextInt(100);
        }
        print(integers);
        System.out.println("=========");
        MySort mySort = new MySort();
        mySort.insertionSort(integers);
        print(integers);
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
        quickSortTest();
        long end = System.currentTimeMillis();
        System.out.println("sort use time " + (end - start));
//        bobbleSortTest();
    }
}
