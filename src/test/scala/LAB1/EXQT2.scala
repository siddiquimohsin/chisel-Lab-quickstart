package LAB1
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT2 extends FreeSpec with ChiselScalatestTester{
    "EXQT2" in {
        test(new EXQ2(4.U,4)){c =>
            c.clock.step(500)
            
    }
    }
	
}	