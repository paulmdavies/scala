import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class HistoryStackTest extends FunSuite
{
    /**
     * A simple test that pushing values onto a stack works correctly
     */
    test( "Stack Push Test" )
    {
        var hs = new HistoryStack[Int]
        hs push 0
        hs push 1
        hs push 2
        assert( hs.contents === ArrayBuffer[Int]( 0, 1, 2 ) )
        assert( hs.size === 3 )
    }
    
    /**
     * A test which walks around the stack a bit
     */
    test( "Stack Move Test" )
    {
        var hs = new HistoryStack[Int]
        hs push 0
        hs push 1
        hs push 2
        
        // move back => 1
        assert( hs.backAvailable )
        assert( !hs.forwardAvailable )
        assert( hs.back == 1 )
        
        // move back => 0
        assert( hs.backAvailable )
        assert( hs.forwardAvailable )
        assert( hs.back == 0 )
        
        // move forward => 1 
        assert( !hs.backAvailable )
        assert( hs.forwardAvailable )
        assert( hs.forward == 1 )
        
        // move forward => 2 
        assert( hs.backAvailable )
        assert( hs.forwardAvailable )
        assert( hs.forward == 2 )
    }
}