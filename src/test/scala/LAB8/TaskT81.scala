package LAB8
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TaskT81 extends FreeSpec with ChiselScalatestTester{
    "TaskT81" in {
        test(new memory_assignment){c =>
        c.io.requestor(0).bits.poke(3.U)
        c.io.requestor(0).valid.poke(0.B)
        c.io.requestor(1).bits.poke(5.U)
        c.io.requestor(1).valid.poke(1.B)
        c.io.requestor(2).bits.poke(8.U)
        c.io.requestor(2).valid.poke(0.B)
        c.io.requestor(3).bits.poke(9.U)
        c.io.requestor(3).valid.poke(0.B)
        c.io.addr.poke(0.U)
        c.clock.step(50)
        

        }
    }
}