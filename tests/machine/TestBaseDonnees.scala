package machine
import org.junit.Test
import org.junit.Assert._
import Implementations.Tolerance
import Implementations.BSDImpl

class TestBaseDonnees {
  //test
    @Test
  def testKeyWords{
    assertEquals(List(),BSDImpl.KeyWords(""))
    assertEquals(List("mairie"),BSDImpl.KeyWords("Mairie"))
    assertEquals(List("mairie","rennes"),BSDImpl.KeyWords("Mairie de Rennes"))
  }
  
    @Test
  def testListKeyWords{
      assertEquals(List(List("mairie","rennes","hotel","ville"), List("théâtre", "paillette"), List("théâtre", "national", "bretagne","tnb"), List("gare", "sncf")), 
          BSDImpl.listKeyWords)
    }
    
    @Test
  def TestRespond{
       val l1= List("rennes","mairie")
       assertEquals(List(("Mairie de Rennes","Place de la Mairie")), BSDImpl.respond(l1))
       val l2= List("rennes","mairie","bretagne","théâtre")
       assertEquals(List(("Mairie de Rennes","Place de la Mairie"),("Théâtre National de Bretagne","1, Rue Saint-Hélier")), BSDImpl.respond(l2))
        val l3= List("hotel","ville")
       assertEquals(List(("Mairie de Rennes","Place de la Mairie")), BSDImpl.respond(l3))
       val l4= List("tnb")
       assertEquals(List(("Théâtre National de Bretagne","1, Rue Saint-Hélier")), BSDImpl.respond(l4))

    }
     @Test
  def TestMapLang{
       
     }
}
