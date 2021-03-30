package LAB3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class TaskT32 extends FreeSpec with ChiselScalatestTester{
    "TaskT32" in {
        test(new Immediate_Gen){c =>
            c.io.instr.poke("h01700013".U)
            c.io.PC.poke(12.U)
            c.io.immd_se.expect(23.S)
    }
    }
	
}	