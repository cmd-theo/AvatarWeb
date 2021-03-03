package interface_UI

import scala.swing._ 
import java.awt.Color

/**
 * MainFrame realizing the CopyThat application
 */
class UI extends MainFrame {
  
  // Propriétés de la fenêtre
  title = "AVATAR APP 1.0"
  preferredSize = new Dimension(500, 500)

  // Quelques champs définissant les composants
  val input = new InField
  val output = new ResultText
  val reponse = new Response
  output.preferredSize = new Dimension(50, 50)
  val copy = new SendButton("Send", input, output,reponse)

  // Ajout des composants à la fenêtre
  contents = new BoxPanel(Orientation.Vertical) {
    background = Color.WHITE
    contents += output
    contents += reponse
 
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += input
      contents += copy
    }
    //contents += Swing.VStrut(10)
  }
    
}