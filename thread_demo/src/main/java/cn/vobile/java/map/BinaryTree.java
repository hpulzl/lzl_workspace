package cn.vobile.java.map;

/**
 * @Author: li_zhilei
 * @Date: create in 17:30 17/9/30.
 * @description:
 */
public class BinaryTree<K extends Integer,V> {

    TreeNode<Integer,V>[] treeNodes;
    private int size;
    private static int CAPACITY = 16;

    BinaryTree(){
        this(CAPACITY);
    }
    BinaryTree(int capacity){
        capacity = capacity;
        treeNodes = new TreeNode[capacity];
    }

    /**
     * 根据i的大小将其v插入到对应的value中
     * @param i
     * @param v
     */
    public void put(Integer i, V v){
        TreeNode<Integer,V> t;

        if (size == 0){
            t = new TreeNode<Integer, V>(i,v,null,null);
        }

    }

    public int size(){
        return size;
    }

    static class TreeNode<K extends Integer,V>{
        Integer k ;
        V v;
        TreeNode<Integer,V> left;
        TreeNode<Integer,V> right;
        TreeNode(){

        }
        TreeNode(Integer k, V v, TreeNode<Integer,V> left, TreeNode<Integer,V> right){
            this.k = k;
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }

}
