package Implementations

object AnalysePhraseImpl extends AnalysePage {
  
  
  def hash(s:String) : List[String] = {
    s.split("").toList
  }
  
  def contains(l:List[String]) : List[String] = ???
  
}