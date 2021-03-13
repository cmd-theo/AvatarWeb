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
    assertEquals(None,AnalysePhraseImpl.recherche("Je recherche quelque chose", Nil))
    assertEquals(Some("Bonsoir") , AnalysePhraseImpl.recherche("Bonsoir", l))
    assertEquals(Some("Bonne nuit") , AnalysePhraseImpl.recherche("Bonnenuit", l))
  }
  
  @Test
  def testMotsClés{
    val s1 = "Mairie de Rennes"
    val s2 = "Bonjour, théâtre de Bretagne"
    val s3 = "Théotre du Brtagne"
    assertEquals (List ("Mairie", "Rennes"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s1)))
    assertEquals (List ("Théâtre", "Bretagne"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s2)))
    assertEquals (List ("Théâtre", "Bretagne"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s3)))
  }
}