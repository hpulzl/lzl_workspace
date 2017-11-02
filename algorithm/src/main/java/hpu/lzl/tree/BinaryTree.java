package hpu.lzl.tree;



/**
 * Created by lzl on 2017/11/1.
 * 实现二叉树实例
 * 完成树的先序遍历、中序遍历、后序遍历等
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
       nodes =  new TreeNode<>(n);
    }

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<String>();
//        binaryTree.puTree("A");
//        binaryTree.puTree("B");
//        binaryTree.puTree("C");
//        binaryTree.puTree("D");
//        binaryTree.puTree("E");
//        binaryTree.puTree("F");

//        System.out.println(binaryTree);

        BinaryTree bt = create();
        System.out.println(bt.toString());
    }

    /**                  a
     *                 b   c
     *               d  e f g
     *              h i
     * @return
     */
    public static BinaryTree create(){
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
        return new BinaryTree(a);
    }

    /**
     * 生成的策略，
     * 默认是从中，左，右的顺序
     * 即
     * @param e
     */
    public void puTree(E e){
        if (e == null){
            throw new NullPointerException();
        }

    }

    /**
     * 左序遍历
     */
    public void leftOrder(){

    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return nodes.toString();
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


        @Override
        public String toString() {
            if (data ==  null){
                return "";
            }
            StringBuffer sb = new StringBuffer();
            sb.append("节点是:" + data);
            sb.append(" 左节点是:" + left.data);
            sb.append(" 右节点是:" + right.data);
            return sb.toString();
        }
    }
}
