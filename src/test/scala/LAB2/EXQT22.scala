package LAB2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT22 extends FreeSpec with ChiselScalatestTester{
    "EXQT22" in {
        test(new Mux8to1){c =>
            c.io.in0.poke(1.U)
            c.io.in1.poke(5.U)
            c.io.in2.poke(3.U)
            c.io.in3.poke(11.U)
            c.io.in4.poke(15.U)
            c.io.in5.poke(8.U)
            c.io.in6.poke(12.U)
            c.io.in7.poke(13.U)
            c.io.sel1.poke(1.U)
            c.io.sel2.poke(1.U)
            //c.clock.step(1)
            c.io.out.expect(8.U)
        
    }
    }
	
	
}