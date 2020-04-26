import akka.actor.AbstractActor

class CleanupActor extends AbstractActor {
  override def createReceive(): AbstractActor.Receive = {
    receiveBuilder().matchAny(msg -> {print(msg)})
      .build();
  }
}
