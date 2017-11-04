package hpu.lzl.graph;

/**
 * Created by lzl on 2017/11/4.
 * 实现将图转换成邻接矩阵
 */
public class Graph {
    private Node[] nodes; //顶点集合
    private Border[] borders; //边的集合
    private int[][] graphs; //图的二维矩阵
    int size;
    int border_size;

    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String>[] nodes = new Node[]{a,b,c,d,e};
        Border ae = new Border(a,e);
        Border ab = new Border(a,b);
        Border bc = new Border(b,c);
        Border ed = new Border(e,d);
        Border cd = new Border(c,d);
        Border[] borders = new Border[]{ae,ab,bc,ed,cd};
        Graph graph = new Graph(nodes,borders);
        int[][] matrix = graph.createGraph();
        graph.revertMatrix(matrix);
    }

    public Graph(Node[] nodes,Border[] borders){
        this.nodes = nodes;
        this.borders = borders;
        checkNull();
        size = nodes.length;
        border_size = borders.length;
        //初始化时候，图的大小是顶点数组的大小
        graphs = new int[nodes.length][nodes.length];

    }

    /**
     * 创建一个图
     */
    public int[][] createGraph(){
        checkNull();
        for (int i =0; i<size;i++){
            for (int j=0;j<size;j++){
                graphs[i][j] = hasNode(nodes[i],nodes[j]);
//                System.out.println("i = " + i + " j = " + j + " graphs = " + graphs[i][j]);
            }
        }
        return graphs;
    }

    private void checkNull(){
        if (nodes == null || borders == null
                || nodes.length == 0 || borders.length == 0){
            throw new NullPointerException();
        }
    }

    /**
     * 边的指向的顶点是否包含传入的顶点
     * @param n1
     * @param n2
     * @return 0 没有 1 有
     */
    public int hasNode(Node n1,Node n2){
        for (int i=0;i<border_size;i++){
            Border b = borders[i];
            //如果AB == AB 或者 BA == AB都返回1
            if ((b.fNode.equals(n1) && b.lNode.equals(n2))
                    || (b.fNode.equals(n2) && b.lNode.equals(n1))){
                return 1;
            }
        }
        return 0;
    }
    /**
     * 将图转换成邻接矩阵并打印
     */
    public void revertMatrix(int[][] graphs){
        for (int in=0;in<size;in++){
            if (in ==0){
                System.out.print("  ");
            }
            System.out.print(" " + nodes[in]);
        }
        System.out.println();
        for (int i=0;i<graphs.length;i++){
            System.out.print(" " + nodes[i]);
            for (int j=0;j<graphs[i].length;j++){
                System.out.print(" " + graphs[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 图的顶点
     */
    static class Node<E>{
        E data;
        public Node(){}
        public Node (E e){
            this.data = e;
        }

        @Override
        public String toString() {
            return (String) data;
        }
    }

    /**
     * 图的边
     * 一个边可以指向两个顶点
     */
    static class Border{
        Node fNode; //前顶点
        Node lNode; //后顶点

        public Border(Node fNode,Node lNode){
            this.fNode = fNode;
            this.lNode = lNode;
        }
    }
}
