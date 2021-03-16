package interface_UI

import scala.swing._ 
import javax.swing.SwingConstants._
import javax.swing.ImageIcon
import event._
import java.awt.Color
/** A button for realizing a text-copy
 * @param lab the label of the button
 * @param from the Infield from which the text is copied
 * @param to the ResultText to which the text is copied
 */
class SendButton(lab: String, from : InField, to : ScrollPane, then:Response) extends Button {

  def listToString (l:List[String]):String = {
    l match {
      case Nil => "Je ne comprends pas votre requête."
      case a::Nil => a
      case a::b => a + "\n" + listToString(b)
    }
  }
  
  text = lab
  val z = new MainPanel
  val temp = z.p
  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {

    case ButtonClicked(_) => {
    

      if (from.text != "") {
        
            temp.contents += new BoxPanel(Orientation.Horizontal) {
              preferredSize = new Dimension(100,100)
              contents += new Label {
                icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/avatar.png")
                text = from.text
              }
              contents += Swing.HStrut(50)
              contents += new Label {
                icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/rennes.png")
                text = listToString(Implementations.MachineImpl.ask(from.text))
              }
              contents += Swing.VStrut(30)
              
            
              
            }
        
//          temp.contents += new BoxPanel(Orientation.Horizontal) {
//            preferredSize = new Dimension(100,100)
//            contents += new Label {
//              icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/avatar.png")
//            }
//            contents += new Label(from.text)
//            contents += Swing.HStrut(100)
//            contents += new Label {
//              icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/rennes.png")
//            }
//            contents += new Label(listToString(Implementations.MachineImpl.ask(from.text)))
//          }
        
        
        
//        temp.contents += new GridPanel(2,2) {
//          preferredSize = new Dimension(500,475)
//          contents += new TextArea {
//            text = from.text
//            editable = false
//            
//          }
//          contents += new Label {
//          icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/avatar.png")
//          }
//          contents += new Label {
//          icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/rennes.png")
//          }
//          contents += new TextArea { 
//            text = "Réponse : " + Implementations.MachineImpl.ask(from.text)
//            editable = false
//          }
//        }
        
        to.contents = temp
        //test
        from.text = ""
        

      }
        
      }
  }
  
}