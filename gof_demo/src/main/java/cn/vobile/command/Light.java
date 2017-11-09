package cn.vobile.command;

/**
 * @Author: li_zhilei
 * @Date: create in 17:02 17/11/9.
 * @description:具体命令的接收者。主要封装有那些命令方法
 * 例如:点灯的开方法和关方法
 */
public class Light {

    public void on(){
        System.out.println("电灯打开....");
    }
    public void off(){
        System.out.println("电灯关闭...." );
    }
}
