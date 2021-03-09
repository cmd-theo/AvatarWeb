package Implementations

import machine._

object MachineImpl extends MachineDialogue{
  
  var analysePhrase = AnalysePhraseImpl
  
  val repTNB : String = "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"
  val repGare : String = "L'adresse de Gare SNCF est : 19, Place de la Gare"
  val repMairie : String = "L'adresse de Mairie de Rennes est : Place de la Mairie"
	val repTheatre : String = "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"
	
  val donnees : Map[String,String] = Map(("bonjour", "bonjour"),
      ("salut", "salut"),
      ("théâtre national de bretagne", repTNB),
			("theatre national de bretagne", repTNB),
			("théâtre de bretagne", repTNB),
			("theatre de bretagne", repTNB),
			("tnb", repTNB),
			("gare", repGare),
      ("sncf", repGare),
      ("mairie", repMairie),
      ("mairie de rennes", repMairie),
      ("hôtel de ville", repMairie),
      ("hotel de ville", repMairie),
      ("paillette", repTheatre),
			("théâtre la paillette", repTheatre),
			("theatre la paillette", repTheatre),
			("merci", "merci"),
			("merci aurevoir", "merci aurevoir"),
			("aurevoir", "aurevoir"))
			

  
  /**
   * Envoi d'une requête requete et recuperation de sa reponse
   * @param s la requete
   * @return reponse la liste de reponses
   */
  def ask(s:String):List[String]= {
    val requete = s
    val reponse = AnalysePhraseImpl.hash(requete)
    reponse
  }
  
  // Pour la partie test par le client
  /**
   * Reinitilisation de l'avatar
   */
  def reinit= {
    
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
