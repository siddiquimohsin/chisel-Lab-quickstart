package LAB3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT31 extends FreeSpec with ChiselScalatestTester{
    "TaskT31" in {
        test(new Branch_control){c =>
            c.io.arg_x.poke(2.S)
            c.io.arg_y.poke(3.S)
            c.io.func3.poke(4.U)
            c.io.branch.poke(1.U)
            c.io.branch_taken.expect(1.U)
    }
    }
	
}	