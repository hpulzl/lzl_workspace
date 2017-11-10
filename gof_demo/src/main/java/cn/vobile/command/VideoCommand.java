package cn.vobile.command;

/**
 * @Author: li_zhilei
 * @Date: create in 16:56 17/11/9.
 * @description:命令模式的具体执行类
 */
public class VideoCommand implements Command {

    private Video video = new Video();

    /**
     * 实例化到具体的执行者，
     */
    public void execute() {
        video.on();
    }
}
