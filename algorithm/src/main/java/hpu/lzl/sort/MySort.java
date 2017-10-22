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
                if (arrs[j] < arrs[min]) {
                    //重新设置最小值
                    min = j;
                }
            }
            //内循环结束，选出最小的数组并交换。
            if (min != i){
                swap(arrs, i, min);
            }
        }
    }

    /**
     * 快速排序
     * 采用递归的思想。
     * 每次取目标元素，设置他的左边的值一定小于该目标值，右边的值一定大于该目标值
     * @param a
     * @param left
     * @param right
     */
    public void quickSort(int[]a,int left,int right){
        if (left < right){
            int target = a[left];
            int low = left;
            int high = right;
            while (low < high){
                //从右向左遍历,直到遇到小于target的值时候停止
                while (low < high && a[high] >= target){
                    high--;
                }
                swap(a,low,high);
                //小于目标值放到左边
                while (low < high && a[low] <= target){
                    low++;
                }
                //交换位置
                swap(a,low,high);
            }
            //将基数设置到左小右大的位置
            a[low] = target;
            quickSort(a,left,low-1);
            quickSort(a,low+1,right);
        }
    }

    /**
     * 插入排序
     * 从a[1]开始，遍历最小的数据，插入到前排合适的位置。
     * @param arrs
     */
    public void insertionSort(int[] arrs){
        int length = arrs.length;
        //outer从左向右遍历
        for (int i=1;i<length;i++){
            //取出标记的元素
            int temp = arrs[i];
            int j = i-1;
            //inner从标记的元素开始从右向左遍历
            while (j>=0 && temp < arrs[j]){
                arrs[j+1] = arrs[j];
                j--;
            }
            //每次比较完之后，目标位置-1的位置，所以要加上去
            arrs[j+1] = temp;
        }
    }

    /**
     折半插入排序
     1. 将已有排序序列折半，从而判断出目标值的小范围。
     */
    public void binaryInsertionSort(int[] arrs){
        int length = arrs.length;
        for (int i=1;i<length;i++){
            //目标元素
            int temp = arrs[i];
            //左元素，从左向右
            int left=0;
            //右元素，从右向左
            int right = i-1;
            int mid;
            //折半
            while (left <= right){
                mid = (right + left) / 2;
                if (temp < arrs[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            //插入
            int j=i-1;
            //找到插入的位置，将其余元素向后移动
            while (j>=left && temp<arrs[j]){
                arrs[j+1] = arrs[j];
                j--;
                System.out.println("j = " + j);
            }
            arrs[j+1] = temp;
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
