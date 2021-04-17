package LAB4
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import scala.util.Random

class TaskT42 extends FreeSpec with ChiselScalatestTester{
    val PC_array = Array(0.U,4.U,8.U,12.U,16.U,20.U)
    val Instruction_array = Array("h00200093","h00200113","h00400193","h00400213","h00600293","h00600313")
    val PC = PC_array(Random.nextInt(7))
    val in = Random.nextInt(7)
    val Instruction = Instruction_array(in).U

       
        val result = in match {
            case 0 => 2.S
            case 1 => 2.S
            case 2 => 4.S
            case 3 => 4.S
            case 4 => 6.S
            case 5 => 6.S
        }


    "TestT4" in {
        test(new Immediate_Gen){c =>
            c.io.instr.poke(Instruction)
            c.io.PC.poke(PC)
            c.clock.step(500)
            c.io.immd_se.expect(result)
    }
    }
}