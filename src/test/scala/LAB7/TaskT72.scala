package LAB7

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT72 extends FreeSpec with ChiselScalatestTester{
    "TaskT72" in {
        test(new Task72){c =>
            c.io.start.poke(true.B)
            c.clock.step(1)
            c.io.in.poke(1.U)
            c.clock.step(1)
            c.io.in.poke(1.U)
            c.clock.step(1)
            c.io.in.poke(0.U)
            c.clock.step(1)
            c.io.in.poke(1.U)
            c.clock.step(1)
    }
    }
	
}