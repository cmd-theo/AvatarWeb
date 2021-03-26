package Robot_Web.application
import Robot_Web.library._
import Implementations._

object SyntaxAnalyser {
  
  val keywords:List[String]=List("restaurant","creperie","pizzeria","restaurante","ristorante")
  
  def reponse(s:String):Expression={
    String2Exp(motsClefs(s))
  }
  
  def motsClefs(s:String):List[String] = {
    val l:List[String] = AnalysePhraseImpl.hash(s)
    var liste_copie:List[String]= AnalysePhraseImpl.hash(s)
    for(elt1 <- l) {
      for(elt2 <- keywords) {
        if(Tolerance.correct(elt1, elt2)) 
          liste_copie = liste_copie.tail ; 
          //if(liste_copie(0).equalsIgnoreCase("de") || liste_copie(0).equalsIgnoreCase("du")) liste_copie=liste_copie.tail
          liste_copie
      }
      liste_copie = liste_copie.tail
    }
    Nil
  }
  
  /**
   * @param l une liste non vide de strings non vide
   * @return une expression correspondant à la requête
   */
  def String2Exp(l:List[String]):Expression = {
    l match {
      case Nil => Word("")
      case chaine :: Nil => Word(chaine)
      case chaine :: reste => And(Word(chaine),String2Exp(reste))
    }
  }
  
  
  def UrlBuilder(e: Expression): String={
    var UrlSearch: String = ""
    e match{
      case And(a,b) => UrlSearch = UrlSearch + UrlBuilder(a) + "+" + UrlBuilder(b)
      case Or(a, b) => UrlSearch = UrlSearch + UrlBuilder(a) + "&" + UrlBuilder(b)
      case Word(a) => UrlSearch = UrlSearch + a
    }
    UrlSearch
  }
  
   def main(args: Array[String]): Unit = {
     
   }
}