package Implementations

import machine.AnalysePage

object AnalysePhraseImpl extends AnalysePage {
  
  
  def hash(s:String) : List[String] = {
    s.split(" ").toList.distinct // retire les doublons de la liste également ! 
  }

 /**
   * Reinitialise l'avatar
   */
  def reinit = {
    val bonjour = "AVATAR : Bonjour"
  }
  
  def contains(l:List[String]) : List[String] = ???
  
}
