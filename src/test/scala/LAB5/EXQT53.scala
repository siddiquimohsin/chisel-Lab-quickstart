package LAB5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT53 extends FreeSpec with ChiselScalatestTester{
    "EXQT53" in {
        test(new Operator(2,UInt(16.W))(_+_)){c =>
            c.io.in(0).poke(1.U)
            c.io.in(1).poke(3.U)
            c.clock.step(500)
            c.io.out(1).expect(4.U)
            
    }
    }
}