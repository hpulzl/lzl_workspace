package cn.vobile.akka.actor;

import akka.actor.UntypedActor;
import akka.transactor.Coordinated;
import cn.vobile.akka.other.StmMainTest;
import scala.concurrent.stm.Ref;
import scala.concurrent.stm.japi.STM;

/**
 * 员工actor
 *
 * @author awo
 * @create 2018-03-08 上午11:04
 **/
public class EmployeeActor extends UntypedActor{
    /**
     * 定义账户余额
     */
    private Ref.View<Integer> employeeCount = STM.newRef(10);


    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Coordinated){
            Coordinated coordinated = (Coordinated) message;
            //增加的金额
            int downCount = (int) coordinated.getMessage();
            try{
                //原子操作，增加自身的金额
                coordinated.atomic(() -> {
                    STM.increment(employeeCount,downCount);
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (message.equals(StmMainTest.RECEIVE_MESSAGE_TAG)){
            getSender().tell(employeeCount.get(),getSelf());
        }else{
            unhandled(message);
        }
    }
}
