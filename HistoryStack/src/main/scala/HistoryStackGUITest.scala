
import scala.swing.Frame
import scala.swing.GridPanel
import scala.swing.Button
import scala.swing.Label
import scala.swing.event.ButtonClicked

object HistoryStackGUITest extends Application {
	override def main( args : Array[String] ) = ( new HistoryStackGUITest ).visible = true
}

class HistoryStackGUITest extends Frame
{
    val hStack = new HistoryStack[Int]
    var nextInteger = 0
    
    title = "HistoryStack GUI Test"
        
    val panel = new GridPanel( 1, 0 )
    contents = panel
    
    val backButton = new Button( "Back" )
    val label = new Label( "<empty>" )
    val addButton = new Button( "Add" )
    val clearButton = new Button( "Clear" )
    val forwardButton = new Button( "Forward" )
    
    listenTo( backButton, addButton, clearButton, forwardButton )
    reactions +=
    {
        case ButtonClicked( `backButton` ) =>
        {
            label.text = hStack.back.toString
            updateButtons()
        }
        case ButtonClicked( `forwardButton` ) =>
        {
        	label.text = hStack.forward.toString
        	updateButtons()
        }
        case ButtonClicked( `addButton` ) =>
        {
            label.text = nextInteger.toString
            hStack.push( nextInteger )
            nextInteger += 1
            updateButtons()
        }
        case ButtonClicked( `clearButton` ) =>
        {
            label.text = "<empty>"
            hStack.clear
            updateButtons()
        }
    }
    
    panel.contents += backButton
    panel.contents += label
    panel.contents += addButton
    panel.contents += clearButton
    panel.contents += forwardButton
    pack()
    
    private def updateButtons() =
    {
        backButton.enabled = hStack.backAvailable
        forwardButton.enabled = hStack.forwardAvailable
    }
}