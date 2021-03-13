package Application
import Implementations._

object test extends App{
  val l= List("théâtre","Rennes","Bretagne")
  println(BSDImpl.respond(l))
  println(Tolerance.correct("mairie", "théatre"))
  //println(BSDImpl.hammingDiststr(" ", "de"))
}