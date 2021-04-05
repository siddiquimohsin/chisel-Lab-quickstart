package LAB5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT52 extends FreeSpec with ChiselScalatestTester{
    "EXQT52" in {
        test(new mux(UInt(2.W))){c =>
            c.io.in1.poke(1.U)
            c.io.in2.poke(3.U)
            c.io.sel.poke(1.B)
            c.clock.step(500)
            c.io.out.expect(1.U)
            
    }
    }
}