package machine

trait ToleranceFautes {
  
  /**
   * @param s1 et s2 deux chaines de caractére 
   * @return nb differance entre la chaine s1 et s2
   */
  def hamming(s1: String, s2: String): Int
  
  /**
   * @param s1 et s2 deux chaines de caractére 
   * @return true si il existe pas plus d'une différance et false si non 
   */
  def correct(s1: String, s2: String):Option[String]  
}