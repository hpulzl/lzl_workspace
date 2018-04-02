package hpu.lzl.jvm;

/**
 * 内存溢出的mat工具分析
 *
 * @author awo
 * @create 2018-03-31 下午12:32
 **/
public class OomMat {
    public static void main(String[] args) {
        int size = 512 * 1024 * 1024;
        Byte[] bytes1 = new Byte[size];
        Byte[] bytes2 = new Byte[size];
        Byte[] bytes3 = new Byte[size];
        Byte[] bytes4 = new Byte[size];
        Byte[] bytes5 = new Byte[size];
        Byte[] bytes6 = new Byte[size];

        System.out.println("==============");
    }
}
