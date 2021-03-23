package Implementations

import machine._
import scala.io.Source

object MachineImpl extends MachineDialogue{
  
  var anglais = false;
  var allemand = false;
  var espagnol = false;
  var italien = false;
  var analysePhrase = AnalysePhraseImpl
  
  /**
   * Envoi d'une requête requete et recuperation de sa reponse
   * @param s la requete
   * @return reponse la liste de reponses
   */
  def ask(s:String):List[String]= {
   
    respond2(BSDImpl.respond((AnalysePhraseImpl.motsClefs(s)))) 
  }
  
  
  
  /*def listToString (l:List[String]): String = {
    l match {
      case Nil => ""
      case e1 :: Nil => e1
      case e1 :: reste => e1 + " : " + listToString(reste)
    }
  }
  */
  
  def respond2(l:List[(String,String)]) : List[String] = {
    l match {
      case Nil => Nil
      case ("", e2) :: reste => e2 :: respond2(reste) 
      case (e1, e2) :: reste => "L'adresse de " +e1+ " est : " + e2 :: respond2(reste) 
    }
  }
  
  
  // Pour la partie test par le client
  /**
   * Reinitilisation de l'avatar
   * Effacement de la conversation en cliquant sur le bouton reset
   */
  def reinit= {
    //ResetButton()
  }
  
  /**
   * Test de l'avatar
   * @param l une liste de requete
   * @return la liste des réponses produites par l'avatar
   */
  def test(l:List[String]):List[String]= {
    var res : List[String] = List()
    for (i <- l) {
      for (j <- ask(i)) {
        res = res :+ j
      }
    }
    return res
  }
}
