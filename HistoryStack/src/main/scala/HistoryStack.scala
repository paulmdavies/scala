import scala.collection.mutable.ArrayBuffer

/**
 *  HistoryStack is a class designed to maintain a history of things,
 *  and to be able to walk around that history.
 *  It is ideal for providing an undo/redo stack for a program
 */
class HistoryStack[T] {
     private var stack = ArrayBuffer[T]()
     private var pointer = -1

     /**
      * Checks whether or not we can go "back" in the history
      * @return		Whether or not we can go back
      */
     def backAvailable() : Boolean = pointer > 0
     
     /**
      * Goes back one step in the history. Asserts that going back is possible.
      * @return		The previous item in the history
      */
     def back() : T =
     {
         assert( backAvailable )
         pointer -= 1
         stack( pointer )
     }

     /**
      * Checks whether or not we can go "forward" in the history
      * @return		Whether or not we can go forward
      */
     def forwardAvailable() : Boolean = pointer + 1 < stack.size
     
     /**
      * Goes forward one step in the history. Asserts that going forward is possible.
      * @return		The next item in the history
      */
     def forward() : T =
     {
         assert( forwardAvailable )
         pointer += 1
         stack( pointer )
     }

     /**
      * Pushes a new item of history onto the stack.
      * Deletes the item at the current position, and any after
      * @param		item	The new item of history
      */
     def push( t : T )
     {
         // delete extras after pointer
         stack = stack.slice( 0, pointer + 1 )
         stack.append( t )
         pointer = stack.size - 1//+= 1
     }

     /**
      * Resets the stack, deleting all items of history
      */
     def clear()
     {
         stack.clear
         pointer = -1
     }
     
     /**
      * Get the contents of the stack
      * @return		The stack
      */
     def contents() = stack
     
     /**
      * Get the number of items in the stack
      * @return		The size of the stack
      */
     def size() = stack.size
}

object HistoryStack
{
    def main( args : Array[String] ) = println( "HistoryStack running..." )
}