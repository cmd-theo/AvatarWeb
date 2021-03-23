package interface_UI

import scala.swing._
import javax.swing.SwingConstants._
import javax.swing.ImageIcon
import event._
import java.awt.Color
import java.awt.Graphics
/**
 * A button for realizing a text-copy
 * @param lab the label of the button
 * @param from the Infield from which the text is copied
 * @param to the ResultText to which the text is copied
 */
class SendButton(lab: String, from: InField, to: ScrollPane) extends Button {

  def listToString(l: List[String]): String = {
    l match {
      case Nil      => "Je ne comprends pas votre requête."
      case a :: Nil => a
      case a :: b   => a + "\n" + listToString(b)
    }
  }

  text = lab
  val z = new MainPanel
  var temp = z.p
  var c = 0
  val bd = new GridPanel(2, 2)
  bd.background = Color.WHITE

  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {

    case ButtonClicked(_) => {
    c+=1
      if (from.text != "") {

        temp.contents += new GridPanel(2, 2) {
          background = Color.white

          contents += new BoxPanel(Orientation.Horizontal) {
            background = Color.WHITE
            contents += new Label {
              background = Color.WHITE
              icon = new ImageIcon("src/images/avatar.png")
              text = from.text
            }
          }

          contents += new BoxPanel(Orientation.Horizontal) {
background = Color.WHITE
          }
          contents += new BoxPanel(Orientation.Horizontal) {
background = Color.WHITE
          }

          contents += new BoxPanel(Orientation.Horizontal) {
            var b = new TextArea
            b.text += "\n" + " " + "\n" + " " + listToString(Implementations.MachineImpl.ask(from.text)) + "\n" + "  "
            b.editable = false
            contents += b
            background = Color.WHITE
            contents += new Label {
              background = Color.WHITE
              icon = new ImageIcon("src/images/rennes.png")
              
            }

          }

        }

        to.contents = temp
        //test
        from.text = ""
if ( c ==1){
            temp.contents += bd
              }
      }

    }
  }

}