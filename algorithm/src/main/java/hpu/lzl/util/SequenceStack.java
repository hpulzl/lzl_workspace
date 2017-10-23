package hpu.lzl.util;

import java.util.EmptyStackException;

/**
 * Created by lzl on 2017/10/23.
 */
public class SequenceStack<E> extends ListContainer<E> implements Stack<E>{

    public SequenceStack(){
        super();
    }
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E e) {
        //从栈顶添加一个元素
        add(e);
    }

    @Override
    public E pop() {
        //从栈顶移除元素
        int var2 = this.size();
        E old = this.peek();
        this.remove(var2 - 1);
        return old;
    }

    @Override
    public E peek() {
        int var = this.size();
        if (var == 0){
            throw new EmptyStackException();
        }
        return this.get(var - 1);
    }

    public static void main(String[] args) {
        Stack<String> stack = new SequenceStack<>();
        stack.push("ABC");
        stack.push("DEF");
        stack.push("GHI");
        stack.push("OPQ");
        stack.push("RST");
        stack.push("UVW");

        System.out.println(" last is " + stack.peek());
        System.out.println(" last is " + stack.pop());
        System.out.println(" last is " + stack.pop());
        System.out.println(" last is " + stack.pop());
        System.out.println(" last is " + stack.pop());
        System.out.println(" last is " + stack.pop());
        System.out.println(" last is " + stack.pop());
        System.out.println(" last is " + stack.peek());

//        java.util.Stack<String> strings = new java.util.Stack<>();
//        strings.push("AAAA");
//        strings.push("BBBB");
//        strings.push("CCCC");
//        strings.push("DDDD");
//        strings.push("EEEE");
//        System.out.println(" pop is " + strings.pop());
//        System.out.println(" pop is " + strings.pop());
//        System.out.println(" pop is " + strings.pop());
//        System.out.println(" pop is " + strings.pop());
//        System.out.println(" pop is " + strings.pop());
//        System.out.println(" peek is " + strings.peek());
    }
}
