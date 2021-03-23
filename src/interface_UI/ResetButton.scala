package interface_UI
import scala.swing._ 
import event._
import java.awt.Color

class ResetButton(lab: String, from : InField, to : ScrollPane, then : SendButton) extends Button {

  text = lab
  
  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {

    case ButtonClicked(_) => {
      val reset = new MainPanel 
      from.text = ""
      then.temp = reset.p
      to.contents = reset.main
    }
  }
}