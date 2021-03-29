package interface_UI
import scala.swing._ 
import javax.swing.ImageIcon
import java.awt.Color
import scala.swing.BorderPanel.Position._

//Panneau principal de l'UI, va être édité au fil de la conversation 
class MainPanel {
  val p = new BoxPanel(Orientation.Vertical){ 
    contents += new BoxPanel(Orientation.Horizontal) {
     preferredSize = new Dimension(100,100)
     contents += new Label {
       icon = new ImageIcon("src/images/rennes.png")
       text = "Bonjour ! En quoi puis-je vous aider ?"
     }
   }
  }
  val main = new ScrollPane(p)
 
  
  
  
}