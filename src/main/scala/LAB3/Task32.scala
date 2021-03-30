package LAB3
import chisel3._
import chisel3.util._
import chisel3.util._
class Immediate extends Bundle {
	val instr = Input(UInt(32.W))
	val PC = Input(UInt(32.W))
	val immd_se = Output(SInt(32.W))
}
class Immediate_Gen extends Module {
	val io = IO(new Immediate)
	io.immd_se := 0.S

	when(io.instr(6,0)==="b0100011".U){                 //S_Immediate
		val sbt2 = io.instr(11,7)
		val sbt3 = io.instr(31,25)
		val sbt4 = Cat(sbt3,sbt2)
		val output2 = Cat(Fill(19,sbt4(11)),sbt4)
		val output3 = output2.asSInt
		io.immd_se := output3
	}.elsewhen(io.instr(6,0)==="b110111".U){              //U_Immediate
		val sbt5 = io.instr(31,12)
		val sbt6 = Cat(Fill(11,sbt5(19)),sbt5)
		val sbt7 = sbt6 << "hc".U
		val output4 = sbt7.asSInt
		io.immd_se := output4
	}.elsewhen(io.instr(6,0)==="b0010011".U){            //I_Immediate
		val sbt1 = io.instr(31,20)
		val output = Cat(Fill(19,sbt1(11)),sbt1)
		val output1 = output.asSInt 
		io.immd_se := output1
	}.elsewhen(io.instr(6,0)==="b1100011".U){           //SB_Immediate
		val sbt8 = io.instr(7)
		val sbt9 = io.instr(11,8)
		val sbt10 = io.instr(30,25)
		val sbt11 = io.instr(31)
		val sbt12 = Cat(sbt11,sbt8,sbt10,sbt9,"b0".U)
		val sbt13 = Cat(Fill(19,sbt12(12)),sbt12)
		val output5 = sbt13 + io.PC
		val output6 = output5.asSInt
		io.immd_se := output6

	}.elsewhen(io.instr(6,0)==="b1101111".U){      //UJ_Immediate
		val sbt14 = io.instr(19,12)
		val sbt15 = io.instr(20)
		val sbt16 = io.instr(30,21)
		val sbt17 = io.instr(31)
		val sbt18 = Cat(sbt17,sbt14,sbt15,sbt16,0.U)
		val sbt19 = Cat(Fill(11,sbt18(20)),sbt18)
		val output8 = sbt19 +io.PC
		val output9 = output8.asSInt
		io.immd_se := output9
	}
}