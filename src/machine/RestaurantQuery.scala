package machine

trait RestaurantQuery {
  
  /**
   * @param s une string
   * @return une liste de couples de strings (nom,adresse) répondant à la requête
   */
  def respond(s:String):List[(String,String)]
}