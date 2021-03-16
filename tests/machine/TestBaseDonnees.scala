package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.Tolerance
import Implementations.BSDImpl

class TestBaseDonnees {
  
    @Test
  def testKeyWords{
    assertEquals(List(),BSDImpl.KeyWords(""))
    assertEquals(List("Mairie"),BSDImpl.KeyWords("Mairie"))
    assertEquals(List("Mairie","Rennes"),BSDImpl.KeyWords("Mairie de Rennes"))
  }
  
    @Test
  def testListKeyWords{
      assertEquals(List(List("Mairie", "Rennes"), List("Théâtre", "Paillette"), List("Théâtre", "National", "Bretagne"), List("Gare", "SNCF")), 
          BSDImpl.listKeyWords)
    }
    
    @Test
  def TestRespond{
       val l1= List("Rennes","Mairie")
       assertEquals(List(("Mairie de Rennes","Place de la Mairie")), BSDImpl.respond(l1))
       val l2= List("Rennes","Mairie","Bretagne","Théâtre")
       assertEquals(List(("Mairie de Rennes","Place de la Mairie"),("Théâtre National de Bretagne","1, Rue Saint-Hélier")), BSDImpl.respond(l2))

    }
    
}