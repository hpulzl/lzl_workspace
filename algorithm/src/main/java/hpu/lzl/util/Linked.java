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

    public Node revert(Node head){
        Node pre = null;
        Node temp;
        while (head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;

        }
        return pre;
    }

    public int size(){
        return size;
    }

    public void printLinked(Node cur){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (cur != null){
            sb.append(cur.data).append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length() -1);
        sb.append("]");
        System.out.println("linked is " + sb.toString());
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
//        linked.add("B");
//        linked.add("C");
//        linked.add("D");
        linked.printLinked(linked.first);
        Node node = linked.revert(linked.first);
        linked.printLinked(node);
    }
}
