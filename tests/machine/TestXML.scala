package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.OpenData

class TestXML {
  
  
  @Test
  def testCreate{
    val vAr = OpenData.create()
    assertEquals(true, vAr.contains("Accueil de jour Kerélys"))
    assertEquals(true, vAr.contains("Piscine Villejean"))
    assertEquals(true, vAr.contains("BOULEVARD ALBERT 1ER,BOULEVARD ALBERT 1ER"))
  }
}