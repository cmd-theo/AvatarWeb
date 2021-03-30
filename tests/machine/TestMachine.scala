package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.MachineImpl


class TestIntegration {

  // initialisation des objets sous test
  val m= MachineImpl
  m.reinit
  
  // tests
  @Test
  def testPrettyRespond {
      assertEquals(List("Do you speak English?"), MachineImpl.prettyRespond(List(("","hello")), "anglais"))
      assertEquals(List("Parlez-vous français?"), MachineImpl.prettyRespond(List(("","bonjour")), "français"))
      assertEquals(List("D'accord. Quelle est votre demande ?"), MachineImpl.prettyRespond(List(("","oui")), "français"))
  }  
  
  @Test
  def testAsk {
    assertEquals(MachineImpl.ask("bonjour"), List("bonjour"))
    assertEquals(MachineImpl.ask("hallo"), List("Sprichst du Deutsch?"))
    assertEquals(MachineImpl.ask("ja"), List("Okay. Was ist Deine Anfrage ?"))
  }
}
