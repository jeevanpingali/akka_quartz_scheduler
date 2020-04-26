import akka.actor.{ActorSystem, Props}
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension

object MyApp extends App {
  implicit val system = ActorSystem("QuickStart")
  val scheduler = QuartzSchedulerExtension(system)

  case object Tick

  val cleaner = system.actorOf(Props[CleanupActor])
  QuartzSchedulerExtension(system).schedule("Every30Seconds", cleaner, Tick)
}
