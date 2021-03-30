package LAB3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT31 extends FreeSpec with ChiselScalatestTester{
    "EXQT31" in {
        test(new Encoder4to2){c =>
            c.io.in.poke("b0001".U)
            c.clock.step(500)
            c.io.out.expect("b00".U)
            
    }
    }
	
}	