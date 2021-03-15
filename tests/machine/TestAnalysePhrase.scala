package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.AnalysePhraseImpl

class TestAnalysePhrase {
  
  @Test 
  def testHash {
    val s1:String= "Hôtel de Ville"
    val s2:String= "Je cherche l'hôtel de Ville..."
    val s3:String= "B.o,n;j o? !u ...r"
    val s4:String= "Bonj(our"
    val s5:String= "???!!....()()().... ????  !!! ,, ;;; ))) : ::"
    assertEquals(List("Hôtel", "de", "Ville"), AnalysePhraseImpl.hash(s1))
    assertEquals(List("Je", "cherche", "l'hôtel", "de" , "Ville"), AnalysePhraseImpl.hash(s2))
    assertEquals(List("Bonj", "o" , "u" , "r") , AnalysePhraseImpl.hash(s3))
    assertEquals(List("Bonjour") , AnalysePhraseImpl.hash(s4))
    assertEquals(Nil , AnalysePhraseImpl.hash(s5))
  }
  
  @Test 
  def testRecherche {
    val l:List[String] = List("Coucou","Bonjour","Bonsoir","Bonne nuit","Au revoir","")
    assertEquals(None,AnalysePhraseImpl.recherche("Je recherche quelque chose", Nil)) // liste vide
    assertEquals(Some(""),AnalysePhraseImpl.recherche("", l)) // liste non vide avec mot correct
    assertEquals(Some("Bonsoir"),AnalysePhraseImpl.recherche("Bonsoyr", l)) // liste non vide avec mot ayant 1 erreur
    assertEquals(None,AnalysePhraseImpl.recherche("Bonnenuit ", l)) // liste non vide avec mot ayant + d'1 erreur
  }
  
  @Test
  def testCompare {
    val l_keywords:List[List[String]] = List(List("France","Paris","Marseille"),List("Espagne","Madrid","Barcelone"),
                                   List("Allemagne","Berlin","Hambourg"),List("Royaume-Uni","Londres","Birmingham"),
                                   List("Italie","Rome","Milan"))
    assertEquals(None,AnalysePhraseImpl.compare("Liste vide", Nil)) // liste vide
    assertEquals(Some("Berlin"),AnalysePhraseImpl.compare("Berlin", l_keywords)) // liste non vide avec mot correct
    assertEquals(Some("Rome"),AnalysePhraseImpl.compare("Romm", l_keywords)) // liste non vide avec mot ayant 1 erreur
    assertEquals(None,AnalysePhraseImpl.compare("Royaume-nis", l_keywords)) // liste non vide avec mot ayant plusieurs erreurs
  }
  
  @Test
  def testContains{
   val s1 = "Je recherche le TNB"
   val s2 = "Où est la Mairie ?"
   val s3 = "Je cherche la Gare."
   val s4 = "Quelle est l'adresse du Théâtre la Paillette ?"
   val s5 = "Allo ?"

   val s6 = "Je recherche Hôtel de ville."
   val s7 = "Je recherche le Théâtre de Bretagne."
   val s8 = "Je recherche la Gare SNCF."
   val s9 = "Je recherche la Pailette."

   val s10 = "Hotel de ville."
   val s11 = "Theâtre la Paillette." //ne passe si manque 2 accents
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://gitlab.istic.univ-rennes1.fr/nzhang/gen21-1a-avatar-equipe1.git
   val s12 = "mairie de rennes."
   val s13 = "mairie Rennes"

   val s14 = "marie Renes"
   val s15 = "moirie Rènnes"
   
   val s16 = "Maoirie" // test si lettre en trop

   //assertEquals (List ("TNB"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s1)))
   assertEquals (List ("Mairie"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s2)))
   assertEquals (List ("Gare"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s3)))
   assertEquals (List ("Théâtre", "Paillette"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s4)))
   assertEquals (List (), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s5)))
   //assertEquals (List ("Hôtel", "ville"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s6)))
   assertEquals (List ("Théâtre", "Bretagne"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s7)))
   assertEquals (List ("Gare", "SNCF"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s8)))
   assertEquals (List ("Paillette"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s9)))
   //assertEquals (List ("Hôtel", "ville"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s10)))
   assertEquals (List ("Théâtre", "Paillette"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s11)))
   assertEquals (List ("Mairie", "Rennes"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s12)))
   assertEquals (List ("Mairie", "Rennes"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s13)))
   assertEquals (List ("Mairie", "Rennes"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s14)))
   assertEquals (List ("Mairie", "Rennes"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s15)))
   assertEquals (List (), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s16)))
<<<<<<< HEAD
=======
   
>>>>>>> branch 'master' of https://gitlab.istic.univ-rennes1.fr/nzhang/gen21-1a-avatar-equipe1.git
   /*
    * Pour les tests mis en commentaire, il y a des mots clés manquants dans la liste des mots clés
    * par ex : hôtel/ville (pour hôtel de ville) ne sont pas dans la liste des keywords
    */

  }
}