package LAB5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT1 extends FreeSpec with ChiselScalatestTester{
    "TaskT1" in {
        test(new Task1(32)){c =>
            c.io.in_0.poke(8.U)
            c.io.in_1.poke(1.U)
            c.clock.step(500)
            c.io.sum.expect(9.U)
            
    }
    }
	
	
}