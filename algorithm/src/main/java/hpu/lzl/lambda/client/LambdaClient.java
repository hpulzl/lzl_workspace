package hpu.lzl.lambda.client;

import com.google.common.collect.Lists;
import hpu.lzl.lambda.service.IOperation;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambda的表达式的运用
 * Lambda 表达式让你能够将函数作为方法参数，或者将代码作为数据对待
 * @author awo
 * @create 2018-03-15 下午3:18
 **/
public class LambdaClient {
    public static void main(String[] args) {
//        lambdaAsMethod();
//        lambdaList();
        functionDemo();
    }

    /**
     * 创建一个接口，并实现
     */
    public static void lambdaAsMethod(){
        //===============lambda表达式的写法==================
        int ADD_NUM = 1;
        IOperation operation = (param) -> ADD_NUM + param;
        System.out.println("result : " + operation.addOperation(5));
        System.out.println("version is " + IOperation.getVersion());

        //=============创建Thread==========
        Thread thread = new Thread(()->{
            System.out.println("lambda无参 :" + Thread.currentThread().getName());
        });
        thread.start();

    }

    public static void lambdaList(){
        List<Person> arrayList = Lists.newArrayList();
        for (int i=0;i<10;i++){
            arrayList.add(new Person("name_"+i,10+i));
        }

        Collections.sort(arrayList,(s1,s2) -> s1.getAge() >= s2.getAge() ? -1 : 1);

        System.out.println(arrayList);
    }

    /**
     * java.util.function包中提供了很多函数式支持的对象，
     * 有时我们可以使用这写对象来代替函数式接口
     * Predicate<T>  T作为参数，返回boolean类型，作为一个复杂判断逻辑的函数式接口对象。
     * Function<T,R> T作为参数，返回结果R；
     * Consumer<T> T作为参数，不返回结果。
     */
    public static void functionDemo(){
        //过滤集合中的男性
        List<Person> resList = Lists.newArrayList();
        for (int i =0;i<10;i++){
            boolean flag = i % 2 == 0;
            resList.add(new Person("name_"+i,20+i,flag));
        }
        //1. Predicate 函数式接口的具体实现逻辑
        Predicate<Person> isManPredicate = (Person person) -> person.isSex();
        List<Person> manList = Lists.newArrayList();
        resList.forEach(person -> {
            if (isManPredicate.test(person)){
                manList.add(person);
            }
        });

        System.out.println("male is " + manList);

        //===========lambda的其他表达式
        //2. Function
        Function<Integer, String> f2 = (t)->String.valueOf(t);
        String s = f2.apply(2);
        System.out.println("Function apply result " + s);

        //3. Consumer
        Consumer<Person> personConsumer = (Person p) -> {
            System.out.println("my name is " + p.getName() + " age is " + p.getAge()
                    + " sex is " + (p.isSex() ? "男" : "女"));
        };
        personConsumer.accept(resList.get(4));
    }

public static class Person{
        String name;
        int age;
        boolean sex;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
    }
}
