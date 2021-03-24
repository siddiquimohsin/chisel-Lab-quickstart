package LAB2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT21 extends FreeSpec with ChiselScalatestTester{
    "TaskT21" in {
        test(new Mux5to1){c =>
            c.io.s0.poke(false.B)
            c.io.s1.poke(true.B)
            c.io.s2.poke(false.B)
            c.clock.step(500)
        
    }
    }
	
	
}