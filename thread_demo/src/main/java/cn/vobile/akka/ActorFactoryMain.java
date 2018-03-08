package cn.vobile.akka;

import akka.actor.*;
import akka.pattern.Patterns;
import cn.vobile.akka.actor.*;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * 主函数
 *
 * @author awo
 * @create 2018-03-06 上午11:52
 **/
public class ActorFactoryMain {

    public static void main(String[] args) throws InterruptedException {
//        akkaWatcherDemo();
//        akkaSupervisorDemo();
//        akkaInboxDemo();
//        akkaRouterDemo();
        futureDemo();
    }

    /**
     * akka的监听者
     */
    public static void akkaWatcherDemo(){
        ActorRef workActor =  ActorFactory.getInstance().create(WorkActor.class,"workActor");
        ActorRef watcherActor =  ActorFactory.getInstance().create(WatcherActor.class,workActor,"watcherActor");

        workActor.tell(WorkActor.MsgEnum.WORKING,ActorRef.noSender());
        workActor.tell(WorkActor.MsgEnum.DONE,ActorRef.noSender());

        //中断workActor
        workActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
    }

    /**
     * akka监督者
     */
    public static void akkaSupervisorDemo(){
        ActorRef supervisorStrategyActor =  ActorFactory.getInstance().create(SupervisorStrategyActor.class,"supervisorStrategyActor");
        supervisorStrategyActor.tell(Props.create(RestartActor.class),ActorRef.noSender());

        //选择一个actor，路径使用akka的路径
        ActorSelection actorSelection = ActorFactory.getInstance().actorSelection("akka://messageSystem/user/supervisorStrategyActor/restartActor");

        for (int i=0;i<10;i++) {
            actorSelection.tell(RestartActor.RestartMsg.RESTART,ActorRef.noSender());
        }
    }

    /**
     * inbox消息收件箱
     */
    public static void akkaInboxDemo(){
        ActorSystem actorSystem = ActorSystem.create("inbox", ConfigFactory.load("akka.conf"));
        ActorRef inboxActorRef = actorSystem.actorOf(Props.create(InboxActor.class),"inboxActor");

        //创建消息收件箱
        Inbox inbox = Inbox.create(actorSystem);
        //监听一个actor
        inbox.watch(inboxActorRef);


        //发送消息
        inbox.send(inboxActorRef,InboxActor.InboxMsg.WORKING);
        inbox.send(inboxActorRef,InboxActor.InboxMsg.DONE);
        inbox.send(inboxActorRef,InboxActor.InboxMsg.CLOSE);

        while (true){
            try {
                Object receive = inbox.receive(Duration.create(1, TimeUnit.SECONDS));
                if (InboxActor.InboxMsg.CLOSE.equals(receive)){
                    System.out.println("inbox is closing");
                }else if (receive instanceof Terminated){
                    System.out.println("inbox is closed");
                    actorSystem.shutdown();
                    break;
                }else{
                    System.out.println("receive:" + receive);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void akkaRouterDemo() throws InterruptedException {
        ActorRef routerActorRef = ActorFactory.getInstance().create(RouterActor.class,"routerActor");
        int i = 1;
        while(RouterActor.FLAG.get()){
            routerActorRef.tell(InboxActor.InboxMsg.WORKING,ActorRef.noSender());
            if (i % 10 == 0){
                routerActorRef.tell(InboxActor.InboxMsg.CLOSE,ActorRef.noSender());
            }

            Thread.sleep(500);
            i++;
        }
    }

    /**
     * procedure实时替换的例子
     */
    public static void procedureDemo(){
        ActorRef procedureRef = ActorFactory.getInstance().create(ProcedureActor.class,"procedureActor");

        //通知
        procedureRef.tell(ProcedureActor.ProcedureMsg.WORK,ActorRef.noSender());
        procedureRef.tell(ProcedureActor.ProcedureMsg.WORK,ActorRef.noSender());
        procedureRef.tell(ProcedureActor.ProcedureMsg.SLEEP,ActorRef.noSender());
        procedureRef.tell(ProcedureActor.ProcedureMsg.WORK,ActorRef.noSender());

        //终止actor
        procedureRef.tell(PoisonPill.getInstance(),ActorRef.noSender());
    }

    /**
     * future的应用
     * 1.主actor无需等待，重定向到其他actor
     */
    public static void futureDemo(){
        ActorRef mainActorRef = ActorFactory.getInstance().create(MainActor.class,"mainActor");
        ActorRef printActorRef = ActorFactory.getInstance().create(PrintActor.class,"printActor");


        //加上watcher
        ActorFactory.getInstance().create(WatcherActor.class,mainActorRef,"watcherActor");

        //等待future的返回
        Future<Object> waitResultFuture = Patterns.ask(mainActorRef,25,2000);
        try {
            int result = (int)Await.result(waitResultFuture,Duration.create(3,TimeUnit.SECONDS));
            System.out.println("result is " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //不等待future的返回,如果返回结果，将重定向到PrintActor来处理
        Future<Object> unWaitResultFuture = Patterns.ask(mainActorRef,18,2000);
        Patterns.pipe(unWaitResultFuture,ActorFactory.getSYSTEM().dispatcher()).to(printActorRef);

        // 终止actor的执行
        mainActorRef.tell(PoisonPill.getInstance(),ActorRef.noSender());
    }
}
