package Implementations

trait BaseDeDonnée {
  /**La fonction qui renvoit les pair de string associé à un mot clé
   * @param l La liste de mots que contient la requête
   * @result La liste des pair de string associé
   */
  def respond(l:List[String]):List[((String,String))]
  
  /**La fonction qui renvois le contenu du fichier text de la base donnée
   * @result Le contenu du fichier txt conetant les données
   */
  def listKeyWords:List[List[String]]
}