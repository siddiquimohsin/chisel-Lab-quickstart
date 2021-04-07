package LAB6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class EXQT63 extends FreeSpec with ChiselScalatestTester{
    "EXQT63" in {
        test(new twoshot(4,8)){c =>
        c.clock.step(50)
        }
    }
}