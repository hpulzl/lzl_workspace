package hpu.lzl.recursion;

/**
 * Created by lzl on 2017/10/30.
 * 这里写一些使用递归完成的算法
 */
public class RecursionDemo {

    public static void main(String[] args) {
        int n = 4;
        int sum = recur(n);
        System.out.println(n + " 的阶乘是:" + sum);
        System.out.println(n + " 的斐波那契值是:" + fabonacci(n));
    }

    /**
     * 求n的阶乘
     * n! = n * (n-1) * (n-2) * ... * 1
     * @param n
     */
    public static int recur(int n){
        if (n < 1){
            return 1;
        }
        return n * recur(n-1);
    }

    /**
     * 斐波那契数列
     *
     * f(n) = f(n-1) + f(n-2) + ... + f(1) --->(n >= 2)
     * @param n
     * @return
     */
    public static int fabonacci(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1 || n ==2){
            return 1;
        }
        return fabonacci(n-1) + fabonacci(n-2);
    }
}
