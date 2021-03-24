package LAB2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT21 extends FreeSpec with ChiselScalatestTester{
    "EXQT21" in {
        test(new Mux2to1){c =>
            c.io.in_A.poke(32.U)
            c.io.in_B.poke(16.U)
            c.io.sel.poke(1.B)
            c.clock.step(500)
            
            
    }
    }
	
	
}