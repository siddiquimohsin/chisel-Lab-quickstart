package LAB2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT23 extends FreeSpec with ChiselScalatestTester{
    "EXQT23" in {
        test(new Mux4to2){c =>
            c.io.in0.poke(0.U)
            c.io.in1.poke(0.U)
            c.io.in2.poke(0.U)
            c.io.in3.poke(1.U)
            //c.clock.step(500)
            c.io.out.expect("b11".U)
            
    }
    }
	
	
}