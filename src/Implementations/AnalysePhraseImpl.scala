package Implementations

import machine.AnalysePhrase

object AnalysePhraseImpl extends AnalysePhrase{
  
  
  def hash(s:String) : List[String] = {
    replaceAllPonctuation(s).split(" ").toList.distinct // retire les doublons de la liste également ! 
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
  
  // A RECTIFIER 
  
  def contains(l:List[String]) : List[String] = {
    var res:List[String]=Nil
    l match {
      case Nil => Nil
      case elt :: reste => if(!searchIn(elt,BSDImpl.listKeyWords).equals("")) {
                           val recherche : List[String] = hash(searchIn(elt,BSDImpl.listKeyWords))
                           for(elt <- recherche) {
                             if(!elt.equals("") && elt.charAt(0).isUpper) {res = res ++ List(elt)}
                           } 
                           res }
                           else {contains(reste)}
    }
  }
  
  def searchIn(s:String,list_keywords : List[List[String]]) : String = {
    list_keywords match {
      case Nil => ""
      case a :: reste => searchInList(s,a) + searchIn(s,reste)
    }
  }
  
  def searchInList(s:String,list:List[String]) : String = {
    list match {
      case Nil => ""
      case chaine :: reste => val temp:String=chaine
                              if((temp.toLowerCase()).contains(s.toLowerCase())) {chaine} 
                              else {searchInList(s,reste)}
    }
  }
  
}