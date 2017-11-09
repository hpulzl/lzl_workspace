package cn.vobile.command;

/**
 * @Author: li_zhilei
 * @Date: create in 17:35 17/11/9.
 * @description:
 */
public class ExecuteMain {
    public static void main(String[] args) {
        //产生一个命令
        Command command = new LightCommand();
        CommandControl commandControl = new CommandControl();
        //命令交给命令控制中心
        commandControl.setCommand(command);
        //按下命令按钮
        commandControl.buttonWasPressed();
    }
}
