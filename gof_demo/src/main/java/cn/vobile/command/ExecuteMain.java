package cn.vobile.command;

/**
 * @Author: li_zhilei
 * @Date: create in 17:35 17/11/9.
 * @description:
 */
public class ExecuteMain {
    public static void main(String[] args) {
        //产生电灯的命令
        Command lightCommand = new LightCommand();
        //产生电视机的命令
        Command videoCommand = new VideoCommand();
        CommandControl commandControl = new CommandControl();
        commandControl.addCommand(lightCommand);
        commandControl.addCommand(videoCommand);

        commandControl.executeByQueue();
    }
}
