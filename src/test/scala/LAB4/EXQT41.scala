package LAB4
import chisel3._
import chisel3.util._
import scala.util.Random
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import ALUOP._

class EXQT41 extends FreeSpec with ChiselScalatestTester{
    val array_op = Array(ALU_ADD,ALU_SUB,ALU_AND,ALU_OR,ALU_XOR,ALU_SLT,ALU_SLL,
    ALU_SLTU,ALU_SRL,ALU_SRA,ALU_COPY_A,ALU_COPY_B,ALU_XXX)

val src_a = Random.nextLong() & 0xFFFFFFFFL
val src_b = Random.nextLong() & 0xFFFFFFFFL
val opr = Random.nextInt(12)
val aluop = array_op(opr)
// ALU functional implementation using Scala match
val result = aluop match {
        case ALU_ADD => src_a + src_b
        case ALU_SUB => src_a - src_b
        case ALU_AND => src_a & src_b
        case ALU_OR => src_a | src_b
        case ALU_XOR => src_a ^ src_b
        case ALU_SLL => src_a << ( src_b & 0x1F )
        case ALU_SRL => src_a >> ( src_b & 0x1F )
        case ALU_SRA => src_a .toInt >> ( src_b & 0x1F )
        case ALU_COPY_A => src_a
        case ALU_COPY_B => src_b
        case _=> 0
}
val result1:BigInt = if(result < 0)
(BigInt(0xFFFFFFFFL)+result+1) & 0xFFFFFFFFL
else result & 0xFFFFFFFFL
	
"EXQT41" in {
        test(new EXQ41_Lab4){c =>
            c.io.in_A.poke(src_a.U)
            c.io.in_B.poke(src_b.U)
            c.io.alu_Op.poke(aluop)
            c.clock.step(500)
            c.io.out.expect(result1.asUInt())
            
    }
    }

}