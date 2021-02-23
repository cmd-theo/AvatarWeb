package machine

trait BaseDeDonnée {
  
  
  /**
   * @param l La liste de mots que contient la requête
   * @result La liste indiquant si le mot est présent et la pair de string associé
   */
  def respond(l:List[String]):List[(Boolean,(String,String))]
  /**
   * @result Le contenu du fichier txt conetant les données
   */
  def listKeyWords:List[List[String]]
}