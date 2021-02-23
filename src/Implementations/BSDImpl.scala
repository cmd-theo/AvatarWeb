package Implementations
import scala.io.Source
import machine.BaseDeDonnée

object BSDImpl extends BaseDeDonnée{
  

  def respond(l:List[String]):List[(String,String)]={
    val t = listKeyWords
    var res:List[(String,String)]=List()
    for(x<-l){
     for(y<-t){
        if(y(0).contains(x)) res = res:+(y(0),y(1))
     }
    }
    res
  }
  
  
  
  
  
  
  
  
  
  /** Extracteur de fichier
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(List(nom,adresse)) */
  def listPaireNomAdd:List[List[String]]={
      var res :List[List[String]] = List()
      val txt =Source.fromFile("doc/DonneesInitiales.txt").getLines
      for(x<-txt){
        val i = x.indexOf(";")
        res = res :+ List(x.slice(0, i),x.slice(i+1,x.length))
      }
      res

}
   def listKeyWords:List[List[String]]={
     var res :List[List[String]] = List()
     val list = listPaireNomAdd
     var keyWord :String =""
     for(x<-list){
       res = res :+ KeyWords(x(0))
     }
     res
   }
   def KeyWords(flag:String):List[String]={
     var res:List[String] = List()
     var str = flag
     while(str != ""){
        val i = str.indexOf(" ")
        if (i != -1){ 
          res = res :+ str.slice(0, i)
          str = str.slice(i+1, str.length())  
        }
        else {
          res = res :+ str
          str = ""
        }
     }
     res
   }
}