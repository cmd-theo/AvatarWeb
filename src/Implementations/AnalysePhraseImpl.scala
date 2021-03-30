package Implementations

import machine.AnalysePhrase
import Robot_Web.application._

object AnalysePhraseImpl extends AnalysePhrase{
  
  val internaute = List ("restaurant", "restaurante", "ristorante", "creperie", "pizzeria")
  
  //langue courante de l'avatar
  var chosenLang = "français"
  
  def isPresent(l1:List[String], l2:List[String]):Boolean = {
    l1 match {
      case Nil => false
      case a::rest => if(l2.contains(a)) true else isPresent(rest, l2)
    }
  }
  
  def languageSelection(s:String):String = {
    if(containsPolit(hash(s))!="") {
      chosenLang = BSDImpl.MapLangPolit()(containsPolit(hash(s)))
    }
    chosenLang
  }
  
  def orientedAnswer(s:String) : List[(String, String)] = {
    val l = motsClefs(s)
    if(containsPolit(hash(s))!="") ("", BSDImpl.MapLangTrad(containsPolit(hash(s)), languageSelection(s))) :: BSDImpl.respond(l)
    else if (containsRobot(l)) {
      val urlSearch = "https://www.linternaute.com/restaurant/guide/ville-rennes-35000/?name=" + SyntaxAnalyser.UrlBuilder(SyntaxAnalyser.ExpressionResponse(s))
      AnalysePageImp.resultats(urlSearch, SyntaxAnalyser.ExpressionResponse(s))
    }
    else BSDImpl.respond(l)
  }
  
  def containsPolit(l:List[String]) : String = {
    l match {
      case Nil => ""
      case a::rest => if(Tolerance.returnStringCorrect(a, BSDImpl.ListLangPolit)!=List()) Tolerance.returnStringCorrect(a, BSDImpl.ListLangPolit) else containsPolit(rest)
    }
  }
  
  def containsRobot(l:List[String]) : Boolean = {
    l match {
      case Nil => false
      case a::rest => if(internaute.contains(a)) true else containsRobot(rest)
    }
  }
  
  def motsClefs(s:String) : List[String] = {
    contains(hash(s))
  }
  
  def hash(s:String) : List[String] = {
    replaceAllPonctuation(s).split(" ").toList.distinct // retire les occurences multiples de la chaîne ! 
  }

  
  /**
   * @param s une string
   * @return la même chaine à laquelle on a retiré tous les caractères de ponctuation
   */
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
    res = res.replace("'"," ")
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
  
  /**
   * @param s une string
   * @param l_keywords une liste de listes de strings
   * @return un résultat de type Option : Some d'une string si s correspond bien 
   * à une chaine dans une des sous-listes de l_keywords, None dans le cas contraire
   */
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
  
  /**
   * @param s une string
   * @param l une liste de strings
   * @return un résultat de type Option : Some d'une string si s correspond bien 
   * à une chaine dans l (avec ou sans correction), None dans le cas contraire
   */
  def recherche(s:String,l:List[String]) : Option[String] = {
    l match {
      case Nil => None
      case chaine :: reste => 
        if(chaine.equalsIgnoreCase(s)) Some(chaine) 
        else if(Tolerance.correct(s, chaine)) Some(chaine)
        else recherche(s,reste)
    }
  }
}
