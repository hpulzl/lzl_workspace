package cn.vobile.akka.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.transactor.Coordinated;
import cn.vobile.akka.other.StmMainTest;
import scala.concurrent.stm.Ref;
import scala.concurrent.stm.japi.STM;

/**
 * <p>STM（akka事务相关处理）的例子<p/>
 * <p>例子：1.公司账户减少钱，员工账户增加钱<p/>
 * @author awo
 * @create 2018-03-08 上午10:33
 **/
public class CompanyActor extends UntypedActor{
    /**
     * 定义账户余额
     */
    private Ref.View<Integer> companyCount = STM.newRef(100);


    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Coordinated){
            Coordinated coordinated = (Coordinated) message;
            //减少的金额
            int downCount = (int) coordinated.getMessage();
            //通知员工actor，增加金额
            StmMainTest.employeeActor.tell(coordinated.coordinate(downCount), ActorRef.noSender());
            try{
                //原子操作，减少自身的金额
                coordinated.atomic(() -> {
                    if (companyCount.get() < downCount){
                        throw new RuntimeException("余额不足!" + companyCount.get());
                    }
                    STM.increment(companyCount,-downCount);
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (message.equals(StmMainTest.RECEIVE_MESSAGE_TAG)){
            //返回结果
            getSender().tell(companyCount.get(),getSelf());
        }else{
            unhandled(message);
        }
    }
}
