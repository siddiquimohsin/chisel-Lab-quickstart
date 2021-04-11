package LAB6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT62 extends FreeSpec with ChiselScalatestTester{
    "EXQT62" in {
        test(new counter(4)){c =>
        c.clock.step(10)
        c.io.out.expect(2.U)
        }
    }
}