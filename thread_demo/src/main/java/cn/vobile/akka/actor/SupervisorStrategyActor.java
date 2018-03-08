package cn.vobile.akka.actor;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * 监督者
 *
 * @author awo
 * @create 2018-03-06 下午2:30
 **/
public class SupervisorStrategyActor extends UntypedActor {

    /**
     * 监督者有两种模式：
     * OneForOneStrategy 只针对出异常的actor进行处理，默认的策略
     * AllForOneStrategy 对出问题的actor和兄弟actor做处理
     * @return
     */
    @Override
    public SupervisorStrategy supervisorStrategy() {
        //1分钟内重试3次
        return new OneForOneStrategy(3, Duration.create(1, TimeUnit.MINUTES),
                //对
                new Function<Throwable, SupervisorStrategy.Directive>() {
                    @Override
                    public SupervisorStrategy.Directive apply(Throwable throwable) throws Exception {
                        if(throwable instanceof ArithmeticException){
                            //ArithmeticException是出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例。
                            System.out.println("meet ArithmeticException ,just resume.");
                            return  SupervisorStrategy.resume();
                        }else if(throwable instanceof NullPointerException){
                            //继续; 重新开始; 恢复职位;
                            System.out.println("meet NullPointerException , restart.");
                            return SupervisorStrategy.restart();
                        }else if(throwable instanceof IllegalArgumentException){
                            System.out.println("meet IllegalArgumentException ,stop.");
                            return SupervisorStrategy.stop();
                        }else{
                            System.out.println("escalate.");
                            //使逐步升级; 使逐步上升; 乘自动梯上升;也就是交给更上层的actor处理。抛出异常
                            return SupervisorStrategy.escalate();
                        }
                    }
                });
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Props){
            getContext().actorOf((Props) message,"restartActor");
        }else{
            unhandled(message);
        }
    }
}
