package LAB6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT62 extends FreeSpec with ChiselScalatestTester{
    "TaskT62" in {
        test(new counter_with_XOR(13)){c =>
        c.clock.step(100)
        }
    }
}