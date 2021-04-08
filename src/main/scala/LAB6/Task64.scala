package LAB6
import chisel3._
import chisel3.util._

class up_downcounter(max : Int) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
        val control = Input(UInt(1.W))
    })
    val counter = RegInit(0.U(log2Ceil(max).W))
    io.out := 0.U
    when(io.control === 1.U){
        counter := counter + 1.U
        io.out := counter
    }.otherwise{
        counter := counter - 1.U
        io.out := counter
    }
}