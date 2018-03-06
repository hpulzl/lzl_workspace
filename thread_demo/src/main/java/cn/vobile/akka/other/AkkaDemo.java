package cn.vobile.akka.other;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * akka的一些基本demo
 *
 * @author awo
 * @create 2018-01-14 下午4:17
 **/
public class AkkaDemo {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo-java");
        ActorRef bob = system.actorOf(Greeter.props("Bob", "Howya doing"));
        ActorRef alice = system.actorOf(Greeter.props("Alice", "Happy to meet you"));
        bob.tell(new Greet(alice), ActorRef.noSender());
        alice.tell(new Greet(bob), ActorRef.noSender());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { /* ignore */ }
        system.shutdown();
    }

    // messages
    private static class Greet {
        public final ActorRef target;

        public Greet(ActorRef actor) {
            target = actor;
        }
    }

    private static Object AskName = new Object();

    private static class TellName {
        public final String name;

        public TellName(String name) {
            this.name = name;
        }
    }

    // actor implementation
    private static class Greeter extends UntypedActor {
        private final String myName;
        private final String greeting;

        Greeter(String name, String greeting) {
            myName = name;
            this.greeting = greeting;
        }

        public static Props props(String name, String greeting) {
            return Props.create(Greeter.class, name, greeting);
        }

        public void onReceive(Object message) throws Exception {
            if (message instanceof Greet) {
                ((Greet)message).target.tell(AskName, self());
            } else if (message == AskName) {
                sender().tell(new TellName(myName), self());
            } else if (message instanceof TellName) {
                System.out.println(greeting + ", " + ((TellName)message).name);
            }
        }
    }
}
