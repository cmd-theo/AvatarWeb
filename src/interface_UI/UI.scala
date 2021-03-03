package interface_UI

import scala.swing._ 
import java.awt.Color
import scala.swing.BorderPanel.Position._

/**
 * MainFrame realizing the CopyThat application
 */
class UI extends MainFrame {
  
  // Propriétés de la fenêtre
  title = "AVATAR APP 1.0"
  preferredSize = new Dimension(500, 500)

  // Quelques champs définissant les composants
  val input = new InField
  input .preferredSize = new Dimension(10,10)
  val output = new ResultText
  val reponse = new Response
  output.preferredSize = new Dimension(50, 50)
  val copy = new SendButton("Send", input, output,reponse)

  // Ajout des composants à la fenêtre
  contents = new BorderPanel {
    background = Color.WHITE
    layout( output) = Center
   
    layout(new BoxPanel(Orientation.Horizontal) {
      contents += input
      contents += copy
      
    }) = South
    layout(new ScrollBar) = East
   
    //contents += Swing.VStrut(10)
  }
    
}