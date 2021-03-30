package LAB3
import chisel3._
import chisel3.util.Cat
class ALUcontrol extends Module{
	val io = IO(new Bundle{
	val ALUop = Input(UInt(3.W))
	val Func7 = Input(UInt(1.W))
	val Func3 = Input(UInt(3.W))
	val Ctrl = Output(UInt(5.W))
})

	io.Ctrl := "b00000".U
	when(io.ALUop === "b000".U){
	io.Ctrl := Cat(0.U, io.Func7, io.Func3)
}
	.elsewhen(io.ALUop === "b001".U){
	when(io.Func3 === "b101".U){
	io.Ctrl := Cat("b0".U,io.Func7,io.Func3)
	}.otherwise{
	io.Ctrl := Cat("b00".U,io.Func3)

}
}
	.elsewhen(io.ALUop === "b101".U){
	io.Ctrl := "b00000".U
} 
	.elsewhen(io.ALUop === "b100".U){
	io.Ctrl	:= "b00000".U
}
	.elsewhen(io.ALUop === "b010".U){
	io.Ctrl := Cat("b10".U ,io.Func3)
}
	.elsewhen(io.ALUop === "b011".U){
	io.Ctrl := "b11111".U
}
	.elsewhen(io.ALUop === "b001".U){
	io.Ctrl := Cat("b0".U,io.Func7,io.Func3)
}
	.elsewhen(io.ALUop ==="b110".U){
	io.Ctrl := "b00000".U
}	
}
