package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.AnalysePhraseImpl

class TestAnalysePhrase {
  
<<<<<<< HEAD
  @Test 
  def testHash {
    val s1 = "Hôtel de Ville"
    val s2 = "Je cherche l'hôtel de Ville..."
    val s3 = "B.o,n;j o? !u ...r"
    val s4 = "Bonj(our"
    val s5 = "???!!....()()().... ????  !!! ,, ;;; ))) : ::"
    assertEquals(List("Hôtel", "de", "Ville"), AnalysePhraseImpl.hash(s1))
    assertEquals(List("Je", "cherche", "l'hôtel", "de" , "Ville"), AnalysePhraseImpl.hash(s2))
    assertEquals(List("Bonj", "o" , "u" , "r") , AnalysePhraseImpl.hash(s3))
    assertEquals(List("Bonjour") , AnalysePhraseImpl.hash(s4))
    assertEquals(Nil , AnalysePhraseImpl.hash(s5))
=======
  @Test
  def testMotsClés{
    val s1 = "Mairie de Rennes"
    val s2 = "Bonjour, théâtre de Bretagne"
    val s3 = "Théotre du Brtagne"
    assertEquals (List ("Mairie", "Rennes"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s1)))
    assertEquals (List ("Théâtre", "Bretagne"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s2)))
    assertEquals (List ("Théâtre", "Bretagne"), AnalysePhraseImpl.contains(AnalysePhraseImpl.hash(s3)))
>>>>>>> branch 'master' of https://gitlab.istic.univ-rennes1.fr/nzhang/gen21-1a-avatar-equipe1.git
  }
}