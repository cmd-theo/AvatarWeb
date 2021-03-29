package Implementations

import machine._
import scala.io.Source

object MachineImpl extends MachineDialogue{
  
  var francais = false
  var anglais = false;
  var allemand = false;
  var espagnol = false;
  var italien = false;
  var analysePhrase = AnalysePhraseImpl
  
  /**
   * Envoi d'une requête requete et recuperation de sa reponse
   * @param s la requete
   * @return reponse la liste de reponse
   */
  def ask(s:String):List[String]= {
    
    prettyRespond(AnalysePhraseImpl.orientedAnswer(s), AnalysePhraseImpl.languageSelection(s)) 
  }
  //sujet a modifs 
  
  
  /*def listToString (l:List[String]): String = {
    l match {
      case Nil => ""
      case e1 :: Nil => e1
      case e1 :: reste => e1 + " : " + listToString(reste)
    }
  }
  */
  
  def prettyRespond(l:List[(String,String)], s:String) : List[String] = {
    l match {
      case Nil => Nil
      case ("", e2) :: reste => e2 :: prettyRespond(reste, s) 
      case (e1, e2) :: reste => s match {
        case "anglais" => "The adress of " +e1+ " is : " + e2 :: prettyRespond(reste,s) 
        case "espagnol" => "La dirección de " +e1+ " es : " + e2 :: prettyRespond(reste,s) 
        case "allemand" => "Die adresse von " +e1+ " ist : " + e2 :: prettyRespond(reste,s) 
        case "italien" => "Indirizzo di " +e1+ " è : " + e2 :: prettyRespond(reste,s) 
        case _ => "L'adresse de " +e1+ " est : " + e2 :: prettyRespond(reste,s) 
      }
    }
  }
  
  
  // Pour la partie test par le client
  /**
   * Reinitilisation de l'avatar
   * Effacement de la conversation en cliquant sur le bouton reset
   */
  def reinit= {
    francais = true
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
