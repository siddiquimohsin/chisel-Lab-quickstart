package LAB4
import chisel3._
import chisel3.util._

class Branch_control extends Module{
    val io = IO(new Bundle{
        val func3 = Input(UInt(3.W))
        val branch = Input(Bool())
        val arg_x = Input(SInt(32.W))
        val arg_y = Input(SInt(32.W))
        val branch_taken = Output(Bool())
    })
    io.branch_taken := 0.U
    when(io.arg_x===io.arg_y && io.func3==="b00".U && io.branch===1.B){
        io.branch_taken := 1.B
    }.elsewhen(io.arg_x=/=io.arg_y && io.func3==="b001".U && io.branch===1.B){
        io.branch_taken := 1.B
    }.elsewhen((io.arg_x < io.arg_y) && (io.func3==="b100".U || io.func3==="b110".U) && io.branch===1.B){
        io.branch_taken := 1.B
    }.elsewhen((io.arg_x >= io.arg_y) && (io.func3==="b101".U || io.func3==="b111".U) && io.branch===1.B){
        io.branch_taken := 1.B
    }.otherwise{
        io.branch_taken := 0.B
    }

    
}