package Implementations

import machine._
import scala.io.Source

object MachineImpl extends MachineDialogue{
  
  var francais = false
  var anglais = false;
  var allemand = false;
  var espagnol = false;
  var italien = false;
  var analysePhrase = AnalysePhraseImpl
  var index = 0
  var langDef = "français"
  var ModeSwitch = false
  
  /**
   * Envoi d'une requête requete et recuperation de sa reponse
   * @param s la requete
   * @return reponse la liste de reponse
   */
  def ask(s:String):List[String]= {
    println(s)
    prettyRespond(AnalysePhraseImpl.orientedAnswer(s), AnalysePhraseImpl.languageSelection(s)) 
  }
 
  
  /**
   * Fonction qui demande dans quelle langue parle l utilisateur
   * Change la langue si l utilisateur reponds oui
   * Fonction qui enumere les reponses possibles
   * @param l une liste de couples de String
   * @param s la langue fr, eng, deu, it, esp
   * @return une liste de String qui va bien présenter les réponses dans l'interface
   */  
  def prettyRespond(l:List[(String,String)], s:String) : List[String] = {
    println(l.toString())
      if (langDef!=s | ModeSwitch==true){
         if ( l.contains(("",BSDImpl.MapLangTrad("oui", s))) && langDef==s ){
           ModeSwitch=false
           return List(BSDImpl.MapLangTrad("D'accord. Quelle est votre demande ?", s))
           
         } else {
           langDef=s
           ModeSwitch=true
           return List(BSDImpl.MapLangTrad("Parlez-vous français?", s))
         }
      }
      
      l match {
      case Nil => {index=0
                   Nil
                   }
      case ("", e2) :: reste => e2 :: prettyRespond(reste, s)
      case (e1, e2) :: reste => 
        var temp =List("")
        var temppuce=""
        if (index==0){
          index+=1
          temp= List(BSDImpl.MapLangTrad("J'ai",AnalysePhraseImpl.chosenLang)+" "+(reste.size+1)+" "+BSDImpl.MapLangTrad("réponses possibles", AnalysePhraseImpl.chosenLang))
        }
        if(index>0){
          temppuce= index + ") "
          index +=1
        }
        (s match {
        case "anglais" => temp ++ (temppuce+"The adress of " +e1+ " is : " + e2 :: prettyRespond(reste,s)) 
        case "espagnol" => temp ++ (temppuce+"La dirección de " +e1+ " es : " + e2 :: prettyRespond(reste,s)) 
        case "allemand" => temp++ (temppuce+"Die adresse von " +e1+ " ist : " + e2 :: prettyRespond(reste,s)) 
        case "italien" => temp++  (temppuce+"Indirizzo di " +e1+ " è : " + e2 :: prettyRespond(reste,s)) 
        case _ => temp++ (temppuce+"L'adresse de " +e1+ " est : " + e2 :: prettyRespond(reste,s)) 
      })
    }
    }
  
  
  // Pour la partie test par le client
  /**
   * Reinitilisation de l'avatar
   * Effacement de la conversation en cliquant sur le bouton reset
   */
  def reinit= {
    AnalysePhraseImpl.chosenLang = "français"
  }
  
  /**
   * Test de l'avatar
   * @param l une liste de requete
   * @return la liste des réponses produites par l'avatar
   */
  def test(l:List[String]):List[String]= {
    var res : List[String] = List()
    for (i <- l) {
      for (j <- ask(i)) {
        res = res :+ j
      }
    }
    return res
  }
}
