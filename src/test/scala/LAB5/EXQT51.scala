package LAB5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT51 extends FreeSpec with ChiselScalatestTester{
    "EXQT51" in {
        test(new ALU(32)){c =>
            c.io.arg_x.poke(5.U)
            c.io.arg_y.poke(6.U)
            c.io.alu_oper.poke("b0010".U)
            c.clock.step(500)
            c.io.alu_out.expect(11.U)
            
    }
    }
}