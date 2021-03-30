package LAB3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ALUcontrolTests extends FreeSpec with ChiselScalatestTester{
    "ALUcontrolTests" in {
        test(new ALUcontrol){c =>
            c.io.ALUop.poke(5.U)
			c.io.Func3.poke(1.U)
			c.io.Func7.poke(2.U)
			c.clock.step(500)
			c.io.Ctrl.expect(0.U)
    }
    }
	
}	
