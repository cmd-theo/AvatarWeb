package interface_UI

import scala.swing._
import java.awt.Color

/**
 * Customized textfield receiving the input text to copy 
 */
class InField extends TextField {
  //preferredSize = new Dimension(500, 30)
  background = Color.WHITE
  foreground = Color.BLACK
  text = ""
  columns = 80
  border = Swing.LineBorder(Color.GRAY) 
  //maximumSize = new Dimension(600,30)
  
}