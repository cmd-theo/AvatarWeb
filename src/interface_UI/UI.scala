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
  val output = new ResultText
  val reponse = new Response
  
  val b = new BoxPanel(Orientation.Vertical){

  }
  val a = new ScrollPane(b)
  val c = new BoxPanel(Orientation.Vertical)
  val copy = new SendButton("Send", input, a,reponse)
  val res = new ResetButton("Reset", input, a, reponse)
output.preferredSize=new Dimension(50,50)
  


  
  // Ajout des composants à la fenêtre
  contents = new BorderPanel {
    
    
    background = Color.WHITE
    layout(a) = Center
    
    layout(new BoxPanel(Orientation.Horizontal) {
      contents += input
      contents += copy
      contents += res
      
    }) = South
       
   
    //contents += Swing.VStrut(10)
  }
    
}