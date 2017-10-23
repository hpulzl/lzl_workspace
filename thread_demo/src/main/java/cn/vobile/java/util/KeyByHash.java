package cn.vobile.java.util;

/**
 * @Author: li_zhilei
 * @Date: create in 10:42 17/10/23.
 * @description:通过hash求得所分配的区间
 *
 * 如果用hash算法来确定表的分配区间的话，后一个弊端。
 * 就是当表再次扩容（从16到32）时，之前分配的hash将不准确。
 */
public class KeyByHash {
    private final int size = 16;
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     hash = 96355
     hash = 97364
     hash = 3078446
     hash = 95429332
     hash = 93520497
     * @param args
     */

    public static void main(String[] args) {
//        String str[] = new String[]{"abc","bcv","dddd","ddddd","bbbbb"};
//        KeyByHash keyByHash = new KeyByHash();
//        for (String s : str){
//            System.out.println("hash = " + keyByHash.hash(s));
//        }
        System.out.println("args = " + tableSizeFor(16));
    }

    public int hash(int hash){
        return hash & (size - 1);
    }

    public final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println("n = " + n);
        n |= n >>> 2;
        System.out.println("n = " + n);

        n |= n >>> 4;
        System.out.println("n = " + n);

        n |= n >>> 8;
        System.out.println("n = " + n);

        n |= n >>> 16;
        System.out.println("n = " + n);

        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY ) ? MAXIMUM_CAPACITY : n + 1;
    }
}
