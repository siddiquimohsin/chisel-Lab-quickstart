package LAB5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT2 extends FreeSpec with ChiselScalatestTester{
    "TaskT2" in {
        test(new Task2(UInt(32.W),UInt(32.W))){c =>
        c.io.in.address.poke(3.U)
        c.io.in.data.poke(12.U)
        c.clock.step(500)
        c.io.out.address.expect(3.U)
        c.io.out.data.expect(12.U)
        }
    }
}