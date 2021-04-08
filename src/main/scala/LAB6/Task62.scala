package LAB6
import chisel3._
import chisel3.util._

class counter_with_XOR(max :Int) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
    })
    val count = RegInit(0.U(log2Ceil(max).W))

    when(count(log2Ceil(max).U-1.U) ^ 0.U === 1.U){
        count := 0.U
        io.out := count
    }.otherwise{
        count := count + 1.U
        io.out := count
    }
}