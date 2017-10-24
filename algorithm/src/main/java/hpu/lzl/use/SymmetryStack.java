package hpu.lzl.use;

import hpu.lzl.util.SequenceStack;

import java.util.EmptyStackException;

/**
 * @Author: li_zhilei
 * @Date: create in 09:02 17/10/24.
 * @description:判断符号是否对称
 */
public class SymmetryStack {

    /**
     * 判断符号是否对称
     * 遍历符号字符串，如果出现左边括号让其进栈，如果出现右边括号让其出栈。
     * 判断栈中元素如果为空，是平衡字符串；不为空，不是平衡字符串。
     * @param args
     */
    public static boolean symmetry(String args){
        int length = args.length();
        if (length < 1)
            return true;
        SequenceStack<String> stack = new SequenceStack();
        for (int i = 0; i < length; i++) {
            char c = args.charAt(i);
            try {
                switchChar(c,stack);
            }catch (Exception e){
                if (e instanceof EmptyStackException){
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    private static void switchChar(char c,SequenceStack sequenceStack) {
        switch (c){
            case '{':
                sequenceStack.push("{");
                break;
            case '[':
                sequenceStack.push("[");
                break;
            case '(':
                sequenceStack.push("(");
                break;
            case '}':
                sequenceStack.pop();
                break;
            case ']':
                sequenceStack.pop();
                break;
            case ')':
                sequenceStack.pop();
                break;
        }
    }

    public static void main(String[] args) {
        String str = "{[{}]}{[()]}{[()()]}";
        boolean flag = SymmetryStack.symmetry(str);
        if (flag){
            System.out.println(str + "是对称串");
        }else {
            System.out.println(str + "不是对称串");
        }
    }
}
