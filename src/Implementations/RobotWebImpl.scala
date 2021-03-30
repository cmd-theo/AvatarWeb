package Implementations
import machine.RestaurantQuery
import Robot_Web.application._

object RobotWebImpl extends RestaurantQuery{
  
  val urlSearch : String = "https://www.linternaute.com/restaurant/guide/ville-rennes-35000/?name="
  
  def respond(s:String) : List[(String,String)] = {
  val lien = urlSearch + SyntaxAnalyser.UrlBuilder(SyntaxAnalyser.ExpressionResponse(s)) 
  AnalysePageImp.reponse(lien,SyntaxAnalyser.ExpressionResponse(s))
  }
}