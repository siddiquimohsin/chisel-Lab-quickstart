package LAB1
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT1 extends FreeSpec with ChiselScalatestTester{
    "EXQT1" in {
        test(new EXQ1(4.U)){c =>
            c.clock.step(500)
            
    }
    }
	
}	
