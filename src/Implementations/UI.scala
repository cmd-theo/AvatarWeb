package Implementations

import scala.swing._
import event._
class UI extends MainFrame {
  title = "GUI Program #1"
  preferredSize = new Dimension(320, 240)
  contents = new Label("Test avatar")
}

object GuiProgramOne {
  def main(args: Array[String]) {
    val ui = new UI
    ui.visible = true
    println("End of main function")
  }
  class sendButton(lab: String) extends Button {
  
  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {
     case ButtonClicked(_)=> null
  }
  }
}
