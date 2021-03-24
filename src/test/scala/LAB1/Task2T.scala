package LAB1

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Task2T extends FreeSpec with ChiselScalatestTester{
    "Task2" in {
        test(new Task2(4,8)){c =>
            c.clock.step(250)
            
    }
    }
	
	
}