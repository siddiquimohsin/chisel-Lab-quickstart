package LAB8
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT82 extends FreeSpec with ChiselScalatestTester{
    "EXQT82" in {
        test(new EXQ82(8)){c =>
        c.io.enable.poke(true.B)
        c.io.write.poke(true.B)
        c.io.addr.poke(1.U)
        c.io.data_in(0).poke(5.U)
        c.io.mask(0).poke(true.B)
        c.clock.step(3)
        }
    }
}