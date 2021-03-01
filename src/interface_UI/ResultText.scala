package interface_UI

import scala.swing._
import java.awt.Color
import java.awt.Dimension

/**
 * Customized label receiving the copied text 
 */
class ResultText extends TextField {
  preferredSize = new Dimension(500, 470)
  background = Color.WHITE
  foreground = Color.BLACK
  text = ""
  editable = false
  
}