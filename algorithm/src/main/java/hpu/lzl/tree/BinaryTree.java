package hpu.lzl.tree;


import hpu.lzl.util.SequenceStack;
import hpu.lzl.util.Stack;

/**
 * Created by lzl on 2017/11/1.
 * 实现二叉树实例
 * 完成树的先序遍历、中序遍历、后序遍历、深度优先遍历、广度优先遍历等
 */
public class BinaryTree<E> {
    TreeNode parent;
    TreeNode leaf;
    TreeNode nodes;
    int size;
    public BinaryTree(){
        parent = leaf = new TreeNode(null);
    }
    public BinaryTree(TreeNode n){
       nodes =  n;
    }

    public static void main(String[] args) {
        //先序遍历
        System.out.println("======先序遍历======");
        preOrder(create());
        //中序遍历
        System.out.println("======中序遍历======");
        inOrder(create());
        //后序遍历
        System.out.println("======后序遍历======");
        afterOrder(create());
    }

    /**                  a
     *                 b   c
     *               d  e f g
     *              h i
     * @return
     */
    public static TreeNode create(){
        TreeNode a,b,c,d,e,f,g,h,i;
        i = new TreeNode("i");
        h = new TreeNode("h");
        g = new TreeNode("g");
        f = new TreeNode("f");
        e = new TreeNode("e");
        d = new TreeNode("d",h,i);
        c = new TreeNode("c",f,g);
        b = new TreeNode("b",d,e);
        a = new TreeNode("a",b,c);
        return a;
    }

    /**
     * 前序遍历
     * 根节点-->左节点-->右节点
     */
    public static void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归的前序遍历
     * @param node
     */
    public static void preOrderNoRecursion(TreeNode node){
        Stack<TreeNode> stack  = new SequenceStack<>();
        stack.push(node);
        //从根节点划分，分别遍历左子树、又子树
        while (stack != null && stack.size() > 0){
            if (node != null){
                System.out.print(node.data + " ");
                node = node.left;
                stack.push(node);
            }else {
                TreeNode node1 = stack.pop();
            }
        }
    }
    /**
     * 中序遍历
     * 左节点-->根节点-->右节点
     */
    public static void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * 左节点-->右节点-->根节点
     */
    public static void afterOrder(TreeNode node){
        if (node == null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.print(node.data + " ");
    }
    public int size(){
        return size;
    }

    static class TreeNode<E>{
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}
        public TreeNode(E data,TreeNode left,TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public TreeNode(E data){
            this.data = data;
        }

        /**
         * 广度优先遍历，按层遍历
         * @return
         */
        public String printTreeFromTop(TreeNode node) {
            if (node ==  null){
                return "";
            }
            StringBuffer sb = new StringBuffer();
            sb.append(node.toString());
            while (node.left != null && node.right !=null){

            }
            return sb.toString();
        }

        @Override
        public String toString() {
            if (data == null)
                return "";
            StringBuffer sb = new StringBuffer();
            sb.append(" 中间节点:" + data);
            if (left != null)
                sb.append(" 左节点是:" + left.data);
            if (right != null)
                sb.append(" 右节点是:" + right.data);
            return sb.toString();
        }
    }
}
