package Implementations

trait AnalysePage {
   /**
   * @param s une chaîne de caractères correspondant à la phrase rentrée
   * @return une liste de chaînes de caractères correspondant aux mots contenus dans la phrase
   */
  def hash(s:String) : List[String]
  
  /**
   * @param l une liste de chaînes de caractères
   * @return une liste de chaînes de caractères de keywords, sachant qu'un keyword retourné = une référence de ce keyword dans l
   */
  def contains(l:List[String]) : List[String]
}