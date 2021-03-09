package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.AnalysePhraseImpl

class TestAnalysePhrase {
  
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