package Implementations

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
  
  def listKeyWords:List[List[String]]= ???
    
  
}