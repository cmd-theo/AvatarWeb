package Implementations
import scala.xml._
import java.io.InputStream
import javax.xml.parsers.SAXParser
import jdk.internal.util.xml.impl.ParserSAX
import java.io.PrintWriter
import scala.xml.Elem
import scala.xml.Node
import scala.collection.mutable.Queue
import scala.xml.Text
import scala.xml.PrettyPrinter
import javax.xml.parsers.SAXParserFactory
import jdk.internal.util.xml.SAXParser
import jdk.internal.util.xml.impl.SAXParserImpl
import com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl
import scala.collection.SortedMap.Default
import org.xml.sax.helpers.DefaultHandler


object OpenData extends App {
  
  val xml = XML.loadFile("doc/vAr.xml")
  //println(xml)
  val orga = xml \\ "organization"
  val names = orga \\ "name"
  val adresses = orga \\ "street"
  //println(names.toList)
  
  def create(): String={
    val xml = XML.loadFile("doc/vAr.xml")
    val orga = xml \\ "organization"
    var addrFile = ""
    for(i <- orga){
      val names = i \ "name"
      val number = i \\ "street" \\ "number"
      val nameAddr = i \\ "street" \\ "name"
      val street = number.text + ", " + nameAddr.text
      val couples = (names.text, street)
      //println(couples._1.replace("	", "") + "; " + couples._2.replace("	", ""))
      addrFile = addrFile ++ "\n" ++ (couples._1.replace("	", "") + "; " + couples._2.replace("	", ""))
    }
    println(addrFile)
    addrFile
  }
  new PrintWriter("doc/vArData.txt") { write(create()); close }
  
  /*Source.fromFile("doc/vAr.xml").getByteStream
  val stream = OpenData.getClass.getClassLoader().getResourceAsStream("doc/vAr.xml")
  println(stream)
 // val xml =    
    val parserFactory = new SAXParserFactoryImpl
    //val parserFactory = new org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
    val parser = parserFactory.newSAXParser()
    //val source = new org.xml.sax.InputSource("http://www.randomurl.com")
    val adapter = parser.parse(stream, new DefaultHandler)
    //print(adapter.getClass())*/
}