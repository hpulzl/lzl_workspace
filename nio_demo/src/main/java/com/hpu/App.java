package com.hpu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        moveLeft(16);
        moveRight(16);
       // andT(3,2);
    }
    public static void moveLeft(Integer d){
        //向右补0
        int a = d << 3;
        System.out.println("a = " + a );
    }
    public static void moveRight(Integer d){
        int a = d >>> 4;
        int c = d >> 4;
        int b = d ^ 2;
        System.out.println("a = " + a + " b = " + b + " c = " + c);
    }
    public static void andT(Integer a, Integer b){
        int x = a & b;
        System.out.println(" result: " + x);
    }
}
