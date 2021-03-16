package Implementations

import machine._

object MachineImpl extends MachineDialogue{
  
  var analysePhrase = AnalysePhraseImpl
  
  /**
   * Envoi d'une requête requete et recuperation de sa reponse
   * @param s la requete
   * @return reponse la liste de reponses
   */
  def ask(s:String):List[String]= {
    
    respond2(BSDImpl.respond((AnalysePhraseImpl.motsClefs(s)))) 
  }
  
  def respond2(l:List[(String,String)]) : List[String] = {
    l match {
      case Nil => Nil
      case (e1, e2) :: reste => e2 :: respond2(reste) 
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
