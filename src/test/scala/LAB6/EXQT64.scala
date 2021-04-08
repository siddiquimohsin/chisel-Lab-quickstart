package LAB6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT64 extends FreeSpec with ChiselScalatestTester{
    "EXQT64" in {
        test(new My_Queue){c =>
        c.io.in.bits.poke(3.U)
        c.io.in.valid.poke(1.B)
        c.io.out.ready.poke(1.B)
        c.clock.step(5)
        c.io.out.bits.expect(3.U)

        }
    }
}