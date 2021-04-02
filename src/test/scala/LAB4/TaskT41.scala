package LAB4
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import scala.util.Random
import chisel3.util._

class TaskT41 extends FreeSpec with ChiselScalatestTester{
    val brancha = Array(true.B,false.B)
    val a = Random.nextInt(32)
    val b = Random.nextInt(32)
    val branch = Random.nextBoolean()
    val func3 = Random.nextInt(8)

    val result = func3 match{
        case 0 => if(a == b) 1 else 0
        case 1 => if(a != b) 1 else 0
        case 4 => if(a < b) 1 else 0
        case 6 => if(a < b) 1 else 0
        case 5 => if(a >= b) 1 else 0
        case 7 => if(a >= b) 1 else 0
        case _ => 0
    }
    

        "TaskT41" in {
        test(new Branch_control){c =>
            c.io.arg_x.poke(a.S)
            c.io.arg_y.poke(b.S)
            c.io.branch.poke(branch.B)
            c.io.func3.poke(func3.asUInt)
            c.clock.step(500)
            if(branch) c.io.branch_taken.expect(result.B)
            else c.io.branch_taken.expect(0.B)

    }
    }
    
	
	
}