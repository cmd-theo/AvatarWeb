package machine

trait AnalysePhrase {
   /**
   * @param s une chaîne de caractères correspondant à la phrase rentrée
   * @return une liste de chaînes de caractères correspondant aux mots contenus dans la phrase
   * @note les espaces sont supprimés ainsi que les caractères de poncutation
   */
  def hash(s:String) : List[String]
  
  /**
   * @param l une liste de mots clés dans la phrase requête
   * @return une liste de mots clés, à la fois dans la phrase requête et dans la bdd
   */
  def contains(l:List[String]) : List[String]
}