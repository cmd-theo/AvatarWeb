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
  def test1_1{    
    assertEquals(List("Place de la Mairie"), m.test(List("Où est donc la Mairie de Rennes?")))
  }
  
  @Test
  def test1_2{
    assertEquals(List("19, Place de la Gare"), m.test(List("et la Gare?")))
  }
  
  @Test
  def test1_3{
    assertEquals(List(), m.test(List("je cherche")))
  }
  
}
