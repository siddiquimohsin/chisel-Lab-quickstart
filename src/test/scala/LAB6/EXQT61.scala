package LAB6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT61 extends FreeSpec with ChiselScalatestTester{
    "EXQT61" in {
        test(new shift_register(4)){c =>
            c.io.in.poke(13.U)
            c.clock.step(4)
            c.io.out.expect(1.U)
            
    }
    }
}
	