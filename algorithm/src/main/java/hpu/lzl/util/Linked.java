package hpu.lzl.util;

/**
 * @Author: li_zhilei
 * @Date: create in 09:04 17/10/19.
 * @description:单向链表的一般特征
 */
public class Linked<E> {

    int size;
    Linked.Node first;

    /**
     * @param e
     * @return
     */
    public boolean add(E e){
        Linked.Node var = new Node(e,null);
        var.next = first;
        first = var;
        size++;
        return true;
    }

    public void revert(){
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = first;
        sb.append("[");
        while (cur != null){
            sb.append(cur.data).append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length() -1);
        sb.append("]");
        return sb.toString();
    }

    static class Node<E>{
        E data;
        Node next;

        public Node(E data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Linked<String> linked = new Linked<>();
        linked.add("A");
        linked.add("B");
        linked.add("C");
        linked.add("D");
        System.out.println("linked = " + linked.toString() + " linked size = " + linked.size());
        linked.revert();
        System.out.println("linked = " + linked.toString());
    }
}
