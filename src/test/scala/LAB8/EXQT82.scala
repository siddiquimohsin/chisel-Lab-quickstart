package LAB8
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT82 extends FreeSpec with ChiselScalatestTester{
    "EXQT82" in {
        test(new EXQ82(8)){c =>
        c.io.dataIn(0).poke(3.U)
        c.io.dataIn(1).poke(4.U)
        c.io.enable.poke(1.B)
        c.io.rdAddr.poke(0.U)
        c.io.wrAddr.poke(0.U)
        c.clock.step(2)
        }
    }
}