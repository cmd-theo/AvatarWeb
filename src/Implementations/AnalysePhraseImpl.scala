package Implementations

import machine.AnalysePhrase

object AnalysePhraseImpl extends AnalysePhrase{
  
  
  def hash(s:String) : List[String] = {
    replaceAllPonctuation(s).split(" ").toList.distinct // retire les doublons de la liste également ! 
  }

 /**
   * Reinitialise l'avatar
   */
  def reinit = {
    val bonjour = "AVATAR : Bonjour"
  }
  
  def replaceAllPonctuation(s:String) : String = {
    var res:String = s
    res = res.replace(",", "")
    res = res.replace(";" , "")
    res = res.replace(".", "")
    res = res.replace(":", "")
    res = res.replace("!", "")
    res = res.replace("?", "")
    res = res.replace("(", "")
    res = res.replace(")", "")
    res
  }
  
  def contains(l:List[String]) : List[String] = {
    l match {
      case Nil => Nil
      case chaine :: reste => 
        compare(chaine,BSDImpl.listKeyWords) match {
          case None => contains(reste)
          case Some(chaine) => List(chaine) ++ contains(reste)
        }
    }
  }
  
  def compare(s:String, l_keywords:List[List[String]]) : Option[String] = {
    l_keywords match { 
      case Nil => None
      case debut_liste :: reste_liste => 
        recherche(s,debut_liste) match {
          case None => compare(s,reste_liste)
          case Some(chaine) => Some(chaine)
        }
    }
  }
  
  def recherche(s:String,l:List[String]) : Option[String] = {
    l match {
      case Nil => None
      case chaine :: reste => 
        if(chaine.equalsIgnoreCase(s)) { Some(chaine) }
        else if(Tolerance.correct(s, chaine)) Some(chaine)
        else recherche(s,reste)
    }
  }
  
}
