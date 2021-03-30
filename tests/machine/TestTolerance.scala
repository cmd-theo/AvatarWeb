package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.Tolerance

class TestTolerance {
  
    @Test
  def testTolHam{
    assertEquals(1, Tolerance.hamming("Bonjou ", "Bonjour"))
    //assertEquals(2, Tolerance.hamming("Bonjour", "Bonjo"))
    //assertEquals(1, Tolerance.hamming("Bonjour", "Bonjoure"))
    //assertEquals(7, Tolerance.hamming("Bonjour", ""))
    assertEquals(0, Tolerance.hamming("Bonjour", "Bonjour"))
  }
  
  @Test
  def testTol{
    assertEquals(true, Tolerance.correct("Bonjour", "Bonjour"))
    assertEquals(false, Tolerance.correct("Bonjour", "Bonjo"))
    assertEquals(true, Tolerance.correct("Bonjour", "Bonjoure"))
    assertEquals(false, Tolerance.correct("Bonjour", ""))
    assertEquals(true, Tolerance.correct("Bonjou", "Bonjour"))
    assertEquals(false, Tolerance.correct("Mairie", "Theatre"))
    assertEquals(true, Tolerance.correct("Theâtre", "Théâtre"))
    assertEquals(false, Tolerance.correct("gar", "garde"))
  }
}