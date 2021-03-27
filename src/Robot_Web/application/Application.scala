package Robot_Web.application

import Robot_Web.library._
import java.io.FileWriter

object Application extends App {
  
  println("Entrez votre requête")
  //val requete: Expression = ExpressionParser.readExp
  val requete:String = readLine()
  val urlSearch = "https://www.linternaute.com/restaurant/guide/ville-rennes-35000/?name=" + SyntaxAnalyser.UrlBuilder(SyntaxAnalyser.reponse(requete)) 
 
 
  println(urlSearch)
 
  val couplesUrls: List[(String, String)] = AnalysePageImp.resultats(urlSearch, SyntaxAnalyser.reponse(requete)) // prend 2.5 secondes à s'éxecuter
  val temps_debut = System.currentTimeMillis()
  val triplets:List[(String,String,String)] = AnalysePageImp.tripletReponses(urlSearch,SyntaxAnalyser.reponse(requete))
  val temps_analyse = System.currentTimeMillis()
  println("temps analyse triplets = " + (temps_analyse - temps_debut) + "ms")
  println("Les couples: " + couplesUrls)
  println("Les triplets: " + triplets)
 
  val stringResultat = Html2StringImplem.process(produitHtml.resultat2html(couplesUrls))
  
  /**val file=new FileWriter("resultats_recherche.txt")
  try {
    file.write(UrlProcessor.fetch(couplesUrls(0)._2).toString())
  } finally file.close()**/
  
  //temps analyse page -> 135 secondes
  
}
