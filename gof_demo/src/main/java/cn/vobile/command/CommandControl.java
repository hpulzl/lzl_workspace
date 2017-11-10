package cn.vobile.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: li_zhilei
 * @Date: create in 17:19 17/11/9.
 * @description:命令的指挥站，通过setCommand方法类指定命令的接受者
 */
public class CommandControl {

    private Command command;
    /**
     * 设计一个队列来管理所有提交的命令。
     */
    private Queue<Command> commandLinkedList;
    public CommandControl(){
        commandLinkedList = new LinkedList<Command>();
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void addCommand(Command command){
        commandLinkedList.add(command);
    }

    /**
     * 命令控制中心只是管执行命令的，具体执行者是谁，不需要关注
     */
    public void buttonWasPressed(){
        command.execute();
    }

    /**
     * 按照队列顺序依次执行
     * 先命令先执行
     */
    public void executeByQueue(){
        while (commandLinkedList != null && commandLinkedList.size() > 0){
            Command command = commandLinkedList.poll();
            command.execute();
        }
    }
}
