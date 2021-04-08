package LAB6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT64 extends FreeSpec with ChiselScalatestTester{
    "TaskT64" in {
        test(new up_downcounter(8)){c =>
        c.io.control.poke(1.U)
        c.clock.step(8)
        c.io.control.poke(0.U)
        c.clock.step(8)
        }
    }
}