package Implementations
import scala.io.Source
import java.io.PrintWriter
import machine.BaseDeDonnée

object BSDImpl extends BaseDeDonnée{
  
  private var MapLangTradM        :Map[String,Map[String,String]]= Map()  // Map qui traduit un mot dans une autre choisie
  private var MapLangTotal        :Map[String,String]            = Map()  // Map qui fournit la langue d'un mot
  private var ListeLangPolit      :List[String]                  = List() // List de tous les mots de language dans toutes langue 
  
  private var ListPaireNomAdresse :List[List[String]]            = List() // List de paire nom adresse
  private var ListKeyWords        :List[List[String]]            = List() // List de mots-clés en parallèles des noms de la liste ListPaireNomadresse
  
  /**Retoure les noms et adresse associé aux mots clé
 	* @param l liste des mots cl de la requête
 	* @return la liste des nom et adresse associé aux mots clé de la requête
 	*/
  
   def respond(l:List[String]):List[(String,String)]={
    val t = listKeyWords
    var res:List[(String,String)]=List()
    var count:Int = 0
    val tol = new Array[Int](t.size)
    for(x<-0 to t.size-1){
      tol(x)=0
    }
    for(y<-l){
      for(z<-0 to t.size-1){
        for(w<-t(z)){
          if(w.toLowerCase().contains(y.toLowerCase())) tol(z)+=1
        }
      }
    }
   
    for(v<-0 to tol.size-1){
      if(tol(v)==tol.max && tol.max>0){
        res = res:+(listPaireNomAdd(v)(0),listPaireNomAdd(v)(1))
      }
    }
    res
  }
  
  /** Creation du fichier texte correspondant au fichier xml de OpenData 
   * 	
   */
   
  def createData() : Unit = {
    new PrintWriter("doc/vArData.txt") { write(OpenData.create()); close }
  }
   
  /** Extracteur de fichier
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(List(nom,adresse,mot_clé)) */
  
  def listPaireNomAdd:List[List[String]]={
      
      if(ListPaireNomAdresse!=List()) {ListPaireNomAdresse}
      
      else{
      println("Creation")
      var res :List[List[String]] = List()
      //var txt =Source.fromFile("doc/DonneesInitiales.txt").getLines  //demo F1, F2, F3, F4
      var txt =Source.fromFile("doc/vArData.txt").getLines    //demo F5+ 
      for(x<-txt){
        var i      = x.indexOf(";")
        var part1  = x.slice(0, i)
        var part2  = x.slice(i+1,x.length)
        var part3  = ""
        i          = part2.indexOf(";")
        if (i != -1){
          part3  = part2.slice(i+1,part2.length)
          part2  = part2.slice(0,i)
        }
        res = res :+ List(part1,part2,part3)
      }
      ListPaireNomAdresse=res
      res
      }

} 
  /**Génère et retourne une liste Mot Bannit
 	* @param Aucun parametre, Assurez l'existence de "doc/banwords.txt"
 	* @return Liste Mot Bannit (List[String])
 	*/
  private def listBanWord:List[String]={
      var res :List[String] = List()
      val txt =Source.fromFile("doc/banwords.txt").getLines
      for(x<-txt){
        res = res ++ List(x)
      }
      res

}
    /** Creer une liste de liste de mots-clés des nom à partir de listPaireNomAdd. 
     *  La liste a une indexation egale a listPaireNomAdd pour retrouvrer la paire nom Adresse à partir des mots clé
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(List(mots_cle1,mots_cle3....)) */
  
   def listKeyWords:List[List[String]]={
     if(ListKeyWords!=List()) { ListKeyWords }
     else{
     var res :List[List[String]] = List()
     val list = listPaireNomAdd
     for(x<-list){
         var key = KeyWords(x(0))
         if (x(2) != ""){
           key = key ++ KeyWords(x(2))
         }
         res = res :+ key
     }
     ListKeyWords =res
     res
     }
   }
   
   /** Creer une liste de mots-clés en "LOWERCASE" à partir d'une string
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(mots_cle1,mots_cle3....)) */
   
   def KeyWords(flag:String):List[String]={
     var res:List[String] = List()
     var str = flag
     val ban = listBanWord
     while(str != "" & str!=" "){
        val i = str.indexOf(" ")
        if (i != -1){
          var y =str.slice(0, i).toLowerCase()
          if(!ban.contains(y)) res= res :+ y
          str = str.slice(i+1, str.length())  
        }
        else {
          if (!ban.contains(str)) res = res :+ str.toLowerCase()
          str = ""
        }
     }
     res
   }
   
   /** Retourne la traducation d'un mot dans une langue choisie
   *  @param mot: le mot à traduire, lang: la langue choisie: ["français","anglais","espagnol","allemand","italien"]
   *  @return Le mot traduit dans la langue voulut si il exisite sinon une string vide */
   
   def MapLangTrad(mot_ori:String,lang_choix:String):String={
       
       if (MapLangTradM!=Map()) {
         if(MapLangTradM.contains(lang_choix) && MapLangTradM(lang_choix).contains(mot_ori)){
           MapLangTradM(lang_choix)(mot_ori)}
         else ""
       }
       else{
       var map :Map[String,Map[String,String]] = Map()
       val Langue = List("français","anglais","espagnol","allemand","italien")
       
       var txt=Source.fromFile("doc/TradLang.txt").getLines
       var mot_traduit:String = ""
       
       for(x<-txt){
         
         var liste:List[String] = List()
         var y = x
         
         
         while (y!=""){
          val i = y.indexOf(",")
          if(i != -1){
            liste = liste ++ List(y.slice(0, i))
            y = y.slice(i+1 , y.length())
          }
          else{  liste = liste ++ List(y)
            y = ""
          }
         }
         
         for(index <- 0 to Langue.size-1){
           val lang     = Langue(index)
           val mot_trad = liste(index)
           
           if(!map.contains(lang)){
             
             var vierge :Map[String,String] = Map()
             map = map + (lang -> vierge)
             
           }
           
           if(Langue.size==liste.size){
             
             for(mot<- liste){
               val tempo = map(lang) + (mot -> mot_trad)
               map = map + (lang -> tempo)

             }  
           }
         }
       }
       
       if(map.contains(lang_choix) && map(lang_choix).contains(mot_ori)) mot_traduit = map(lang_choix)(mot_ori)
        
       mot_traduit
       }
   }
         
       
   /** Retourne la langue d'un mot
   *  @param mot: le mot dont on voudrait connaître ça langue
   *  @return langue du mot: ["français","anglais","espagnol","allemand","italien"] ou rien si il n'est pas recoonnue */
   
   def MapLangPolit():Map[String,String]={
    
   if (MapLangTotal!=Map()) {MapLangTotal}
   else{
      var txt =Source.fromFile("doc/ListLang.txt").getLines
      var mappa:Map[String,String] = Map() 
      for(x<-txt){
        var i      = x.indexOf(":")
        val lang  = x.slice(0, i).toLowerCase()
        var KeyW  = x.slice(i+1,x.length).toLowerCase()
        while (KeyW!=""){
          i = KeyW.indexOf(",")
          if(i != -1){
            mappa = mappa+(CleanEspLow(KeyW.slice(0, i))->lang)
            KeyW  = KeyW.slice( i+1, KeyW.length() )
          }
          else{  mappa = mappa + (CleanEspLow(KeyW)->lang)
                 KeyW= ""
          }
        }
        }
      val MapLangTotal = mappa
      mappa
   }
   }
   
   /** Retourne la liste de tous les mots de language dans toutes langue
   *  @param Aucun parametre, Assurez l'existence de "doc/ListLang.txt"
   *  @return la liste de tous les mots de language dans toutes langue*/
   
   def ListLangPolit():List[String]={
     
     if(ListeLangPolit!=List()) {ListeLangPolit}
     
     else{
     var ListLangPolit:List[String] = List()
     val MaptoList = MapLangPolit().toList
     for(index <- 0 to MaptoList.size-1){
       ListLangPolit = ListLangPolit ++ List(MaptoList(index)_1)
     }
     ListeLangPolit = ListLangPolit
     ListLangPolit
     }
   }
  
   private def CleanEspLow(sal:String):String={
     val esp = " "
     var res = sal
     res.replaceAll(esp, "").toLowerCase()
    
   }
   
}
