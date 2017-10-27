package hpu.lzl.util;

/**
 * @Author: li_zhilei
 * @Date: create in 09:04 17/10/19.
 * @description:单向链表的一般特征
 * 1. 当链表为空时，首和尾都指向null first = last = new Node(null);
 * 2. 首节点为空，first = null
 * 3. 尾节点会随着元素的增加而向后移动(last = last.next = n)
 *
 */
public class Linked<E> implements Container<E>{
    int size;
    Node first;
    Node last;

    public Linked(){
        //初始化链表,first始终是null
        first = last = new Node(null);
    }

    @Override
    public boolean add(E e) {
        if (size > Integer.MAX_VALUE){
            throw new ArrayIndexOutOfBoundsException(" 超出int值");
        }
        if (e == null){
            throw new NullPointerException("元素不能为空");
        }
        Node n = new Node(e);
        dequeue(n);
        size++;
        return true;
    }

    /**
     * 从尾部插入一个元素
     * @param n
     */
    private void dequeue(Node n){
        //将n放到last.next指针中
        last.next = n;
        //将last指针指向last.next
        last = last.next;
    }
    @Override
    public void add(int index, E e) {
        checkSize(index);
        Node p = first;
        int current = 0;
        while (p != null){
            if (current == index){
                //插入到第index个位置
                Node n = new Node(e);
                n.next = p.next;
                p.next = n;
                size++;
                break;
            }
            current++;
            p = p.next;
        }
    }

    private void checkSize(int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(" index = " + index);
    }

    @Override
    public boolean remove(E e) {
        if (e == null){
            throw new NullPointerException();
        }
        Node p = first;
        while (p != null){
            Node cur = p;
            p = p.next;
            if (p == null)
                return false;
            //每次只删除一个元素
            if (p.data == e){
                cur.next = p.next;
                //let jvm recover
                p = null;
                size--;
                break;
            }
        }
        return true;
    }

    @Override
    public E remove(int index) {
        checkSize(index);
        Node p = first;
        int current=0;
        E e = null;
        while (p != null){
            //每次从first.next开始
            p = p.next;
            if (index == current){
                e = (E) p.data;
                //如果已经删除一个元素，就执行完毕
                if(this.remove(e))
                    break;
            }
            current++;
        }
        return e;
    }

    private void notNulle(E e){
        if (e == null){
            throw new NullPointerException();
        }
    }
    @Override
    public void set(int index, E e) {
        notNulle(e);
        checkSize(index);
        //将第index位置的数据替换
        Node p = first;
        int current = 0;
        while (p.next != null){
            if (current == index){
                p.data = e;
                break;
            }
            p = p.next;
            current++;
        }
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkSize(index);
        int current = 0;
        Node p = first;
        E e = null;
        while (p != null){
            //第0个元素应该是第一个插入的数据
            p = p.next;
            if (index == current){
                e = (E) p.data;
                break;
            }
            current++;
        }
        return e;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (first == null){
            return "[]";
        }
        Node p = first.next;
        if (p == null){
            return "[]";
        }
        sb.append("[");
        while (p != null){
            String s = (String) p.data;
            sb.append(s + " ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    static class Node<E>{
        E data;
        Node next;

        public Node(E data){
            this.data = data;
        }
    }
}
