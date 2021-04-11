package LAB7
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT71 extends FreeSpec with ChiselScalatestTester{
    "EXQT71" in {
        test(new Arbiter_with_Queue(3)){c =>
        c.io.in(0).bits.poke(1.U)
        c.io.in(0).valid.poke(1.B)
        c.io.in(1).bits.poke(2.U)
        c.io.in(1).valid.poke(1.B)
        c.clock.step(5)
        }
    }
}