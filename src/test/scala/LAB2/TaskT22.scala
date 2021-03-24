package LAB2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT22 extends FreeSpec with ChiselScalatestTester{
    "TaskT22" in {
        test(new Task22){c =>
            c.io.in(0).poke(1.B)
            c.io.in(1).poke(0.B)
            c.io.in(2).poke(0.B)
            c.io.in(3).poke(1.B)
            c.io.sel(0).poke(1.B)
            c.io.sel(1).poke(0.B)
            c.io.shift_type.poke(0.B)
            c.clock.step(250)
        
    }
    }
	
	
}