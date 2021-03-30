package LAB3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class TaskT33 extends FreeSpec with ChiselScalatestTester{
    "TaskT33" in {
        test(new Decoder2to4){c =>
            c.io.input.poke("b01".U)
            c.clock.step(500)
    }
    }
	
}	