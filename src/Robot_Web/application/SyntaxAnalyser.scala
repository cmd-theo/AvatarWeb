package Robot_Web.application
import Robot_Web.library._

object SyntaxAnalyser {
  
  def String2Exp(s:String):Expression = ???
  
  
  def UrlBuilder(e: Expression): String={
    var UrlSearch: String = ""
    e match{
      case And(a,b) => UrlSearch = UrlSearch + UrlBuilder(a) + "+" + UrlBuilder(b)
      case Or(a, b) => UrlSearch = UrlSearch + UrlBuilder(a) + "&" + UrlBuilder(b)
      case Word(a) => UrlSearch = UrlSearch + a
    }
    UrlSearch
  }
}