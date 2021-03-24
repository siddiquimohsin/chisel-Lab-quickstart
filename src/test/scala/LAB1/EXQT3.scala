package LAB1
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT3 extends FreeSpec with ChiselScalatestTester{
    "EXQT3" in {
        test(new EXQ3(4,14)){c =>
            c.clock.step(500)
            
    }
    }
	
}	
