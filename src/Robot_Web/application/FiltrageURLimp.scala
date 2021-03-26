package Robot_Web.application

import Robot_Web.library._

object FiltrageURLimp extends FiltrageURLs {

    val racine:String = "https://www.linternaute.com"
    def listeUrl(l: List[(String, String)]): List[String] = {
        l match {
            case Nil        => Nil
            case x :: suite => if (x._1 == "href") x._2 :: listeUrl(suite) else listeUrl(suite)
        }
    }

    def filtrage(l: List[String]): List[String] = {
        l match {
            case Nil    => Nil
            case x :: y => if (x.contains("/restaurant/restaurant")  && contientDesChiffres(x)) { racine+x :: filtrage(y) } else { filtrage(y) }

        }

    }
    
     def contientDesChiffres(s: String): Boolean = {
        var number_check:String = s.replace("/restaurant/restaurant/" , "")
        number_check = number_check.split("/")(0)
        toIntToBool(number_check)
    }
    
    def toIntToBool(s: String): Boolean = {
    try {
      s.toInt.isValidInt
    } catch {
      case e: Exception => false
      }
    }

    def filtreAnnonce(h: Html): List[String] = {
        h match {
            case Text(_)      => Nil
            case Tag(_, x, y) => filtrage(listeUrl(x)) ++ filtreAnnonceBis(y)
        }
    }

    def filtreAnnonceBis(h: List[Html]): List[String] = {
        h match {
            case Nil    => Nil
            case x :: r => filtreAnnonce(x) ++ filtreAnnonceBis(r)
        }

    } 
}