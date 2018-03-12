package hpu.lzl.jvm;

/**
 * java虚拟机堆栈信息分配详解
 * 1. jvm启动后， 会从类路径中找到包含main方法的入口JvmHeapStackDistribute
 * 2. 找到JvmHeapStackDistribute后，读取二进制数据和类的信息，放入到method区域中，并开始执行main方法中的程序
 *     Program program = new Program("java");
 * 创建Program对象实例的过程如下
 * step1: 在method区域中没有找到Program类信息，会通过类加载器加载指定路径的Program，并将类信息放入到method区域中
 * step2: jvm在method区域中找到Program类信息后，会在heap区域中为Program实例对象分配内存，并在Program的实例对象中
 *        持有指向method区域中的Program类的内存地址
 * step3: jvm实例完成后会在当前线程的stack中的reference建立实际的应用关系，此时student赋值完成
 *
 * 在jvm中，方法的调用属于线程的行为，即方法调用本身会发生在调用线程的方法调用栈中：
 * 线程的方法调用栈(method preference frame)：每个方法的调用就是方法调用栈中的一个frame，该frame包含了方法的参数、局部变量、临时数据等
 *    program.sayHello()
 * @author awo
 * @create 2018-03-10 上午11:58
 **/
public class JvmHeapStackDistribute {
    /**
     * main方法是放在jvm的方法区域中
     *
     * 在jvm运行的时候会通过反射的方式到方法区域中找到入口类的入口方法main
     */
    public static void main(String[] args) {
        /**
         * program是放在主线程中的stack区域中
         * program对象实例是放在所有线程共享的heap区域中
         */
        Program program = new Program("java");
        /**
         * 方法执行过程：
         * 1. 首先会通过program指针找program对象，
         * 2. 当找到对象后,会通过对象内部指向方法区域中的指针来调用具体的方法去执行程序
         */
        program.sayHello();
    }
}

/**
 * 对象是放在heap中的
 */
class Program{
    /**
     * name作为声明变量是存放在stack中的
     * 但是name指向的String对象是放在heap中的
     */
    private String name;

    public Program(String name) {
        this.name = name;
    }

    /**
     * sayHello这个方法是放在方法区域中的
     */
    public void sayHello(){
        System.out.println("hello this is "+ name );
    }
}
