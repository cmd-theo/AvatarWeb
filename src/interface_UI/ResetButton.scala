package interface_UI
import scala.swing._ 
import event._
import java.awt.Color

class ResetButton(lab: String, from : InField, to : ScrollPane, then : Response) extends Button {

  text = lab
  val res = new BoxPanel(Orientation.Vertical)
  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {

    case ButtonClicked(_) => {
      from.text = ""
      to.contents = res
      
    }
  }
}