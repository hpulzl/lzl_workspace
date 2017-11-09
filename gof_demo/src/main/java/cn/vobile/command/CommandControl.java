package cn.vobile.command;

/**
 * @Author: li_zhilei
 * @Date: create in 17:19 17/11/9.
 * @description:命令的指挥站，通过setCommand方法类指定命令的接受者
 */
public class CommandControl {

    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    /**
     * 命令控制中心只是管执行命令的，具体执行者是谁，不需要关注
     */
    public void buttonWasPressed(){
        command.execute();
    }
}
