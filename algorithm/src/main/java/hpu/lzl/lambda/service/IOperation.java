package hpu.lzl.lambda.service;

/**
 * 用于计算的接口
 * 函数时表达式接口只支持一个抽象方法
 * @FunctionalInterface 声明函数式的注解，在编译时期检测接口的写法。（我用idea编译器，不写这个注解也行）
 * @author awo
 * @create 2018-03-15 下午3:16
 **/
public interface IOperation {
    /**
     * 加法计算
     * @param a
     * @return
     */
    int addOperation(int a);

    default int getCount(){
        return 1;
    }

    boolean equals(Object o);

    static String getVersion(){
        return "1.1";
    }
}
