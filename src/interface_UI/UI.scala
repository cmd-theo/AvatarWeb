package interface_UI

import scala.swing._ 
import java.awt.Color

/**
 * MainFrame realizing the CopyThat application
 */
class UI extends MainFrame {
  
  // Propriétés de la fenêtre
  title = "My First Reactive Application!"
  preferredSize = new Dimension(500, 500)
  
  // Quelques champs définissant les composants
  val input = new InField
  val output = new ResultText
  val copy = new SendButton("Send",input,output)
  
  // Ajout des composants à la fenêtre
  contents = new BoxPanel(Orientation.Horizontal) {
    background = Color.BLACK
    contents += input
    contents += copy
    contents += output
  }
    
}