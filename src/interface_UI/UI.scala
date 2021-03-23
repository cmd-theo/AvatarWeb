package interface_UI

import scala.swing._ 

import javax.swing.ImageIcon
import java.awt.Color
import scala.swing.BorderPanel.Position._

/**
 * MainFrame realizing the CopyThat application
 */
class UI extends MainFrame {
  
  // Propriétés de la fenêtre
  title = "AVATAR APP 1.0"
  preferredSize = new Dimension(1200, 800)

  // Quelques champs définissant les composants
  val input = new InField
  val output = new ResultText
  val reponse = new Response
  
  val b = new BoxPanel(Orientation.Vertical){
    contents += new BoxPanel(Orientation.Horizontal) {
     preferredSize = new Dimension(100,100)
     contents += new Label {
       icon = new ImageIcon("src/images/rennes.png")
       text = "Bonjour ! En quoi puis-je vous aider ?"
     }
   }
  }
  val a = new ScrollPane(b)
  val c = new BoxPanel(Orientation.Vertical) 
  val copy = new SendButton("Send", input, a)
  val res = new ResetButton("Reset", input, a, copy)
output.preferredSize=new Dimension(50,50)
  


  
  // Ajout des composants à la fenêtre
  contents = new BorderPanel {
    
    
    background = Color.WHITE
    layout(a) = Center
    defaultButton_= (copy)
    layout(new BoxPanel(Orientation.Horizontal) {
      contents += input
      contents += copy
      contents += res
      
    }) = South
       
   
    //contents += Swing.VStrut(10)
  }
  
    
}
