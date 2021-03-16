package interface_UI

import scala.swing._ 

import javax.swing.ImageIcon
import event._
import java.awt.Color
/** A button for realizing a text-copy
 * @param lab the label of the button
 * @param from the Infield from which the text is copied
 * @param to the ResultText to which the text is copied
 */
class SendButton(lab: String, from : InField, to : ScrollPane, then:Response) extends Button {

  text = lab
  val z = new MainPanel
  val temp = z.p
  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {

    case ButtonClicked(_) => {
    

      if (from.text != "") {
        
          temp.contents += new FlowPanel {
            preferredSize = new Dimension(500,475)
            contents += new Label {
              icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/avatar.png")
              preferredSize = new Dimension (50,50)
            }
            contents += new Label(from.text)
            contents += Swing.HStrut(100)
            contents += new Label {
              icon = new ImageIcon("/private/student/e/ue/tboue/Bureau/rennes.png")
              preferredSize = new Dimension (50,50)
            }
            contents += new Label("Réponse : " + Implementations.MachineImpl.ask(from.text))
          }
        
        
        
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