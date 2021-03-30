package LAB3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT32 extends FreeSpec with ChiselScalatestTester{
    "EXQT32" in {
        test(new ALU){c =>
            c.io.A.poke(5.S)
            c.io.B.poke(6.S)
            c.io.ALUcontrol.poke(2.U)
            c.clock.step(500)
            c.io.output.expect(1.S)
            
    }
    }
	
}	