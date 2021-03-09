package interface_UI
import scala.swing._

import java.awt.Color
import java.awt.Dimension

class Response extends TextArea{
    preferredSize = new Dimension(500, 470)
  background = Color.WHITE
  foreground = Color.RED
  text = ""
  editable = false
}