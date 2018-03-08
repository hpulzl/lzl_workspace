package cn.vobile.akka.other;

import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.transactor.Coordinated;
import akka.util.Timeout;
import cn.vobile.akka.ActorFactory;
import cn.vobile.akka.actor.CompanyActor;
import cn.vobile.akka.actor.EmployeeActor;
import scala.concurrent.Await;

import java.util.concurrent.TimeUnit;

/**
 * akka事务处理的demo类
 *
 * @author awo
 * @create 2018-03-08 上午11:22
 **/
public class StmMainTest {

    public static ActorRef companyActor = null;
    public static ActorRef employeeActor = null;
    public static final String RECEIVE_MESSAGE_TAG = "getCount";

    public static void main(String[] args) throws Exception {
        companyActor = ActorFactory.getInstance().create(CompanyActor.class,"companyActor");
        employeeActor = ActorFactory.getInstance().create(EmployeeActor.class,"employeeActor");
        Timeout timeout = new Timeout(1, TimeUnit.SECONDS);
        for (int i=0;i<25;i++){
            //公司actor调用
            companyActor.tell(new Coordinated(i,timeout),ActorRef.noSender());

            Thread.sleep(200);

            //获取到公司和员工的结果
            int companyResult = (int)Await.result(Patterns.ask(companyActor,RECEIVE_MESSAGE_TAG,timeout),timeout.duration());
            int employeeResult = (int)Await.result(Patterns.ask(employeeActor,RECEIVE_MESSAGE_TAG,timeout),timeout.duration());

            System.out.println("company result " + companyResult + " employee result " + employeeResult);
        }
    }
}
