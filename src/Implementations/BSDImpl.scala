package Implementations
import scala.io.Source

object BSDImpl extends BaseDeDonnée{
  
  def respond(l:List[String]):List[(String,String)]= ???
  
  def listKeyWords:List[List[String]]={
      var res :List[List[String]] = List()
      val txt =Source.fromFile("doc/DonneesInitiales.txt").getLines
      for(x<-txt){
        val i = x.indexOf(";")
        res = res :+ List(x.slice(0, i),x.slice(i+1,x.length))
      }
      res
  }
  
}