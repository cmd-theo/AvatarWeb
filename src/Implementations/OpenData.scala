package Implementations
import scala.xml._
import java.io.InputStream
import javax.xml.parsers.SAXParser
import jdk.internal.util.xml.impl.ParserSAX

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
  
  Source.fromFile("doc/vAr.xml").getByteStream
  val stream = OpenData.getClass.getClassLoader().getResourceAsStream("doc/vAr.xml")
  println(stream)
 // val xml =    
    val parserFactory = new SAXParserFactoryImpl
    //val parserFactory = new org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
    val parser = parserFactory.newSAXParser()
    //val source = new org.xml.sax.InputSource("http://www.randomurl.com")
    val adapter = parser.parse(stream, new DefaultHandler)
}