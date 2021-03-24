package LAB2
import chisel3._
import chisel3.util._

class Mux5to1 extends Module {
    val io = IO(new Bundle{
        val s0 = Input(Bool())
        val s1 = Input(Bool())
        val s2 = Input(Bool())
        val out = Output(UInt(32.W))        
    })
    
    io.out:= MuxCase(false.B,Array(
        (io.s0===false.B && io.s1===false.B && io.s2===false.B) -> 0.U,
        (io.s0===true.B && io.s1===false.B && io.s2===false.B) -> 8.U,
        (io.s0===false.B && io.s1===true.B && io.s2===false.B) -> 16.U,
        (io.s0===true.B && io.s1===true.B && io.s2===false.B) -> 24.U,
        (io.s2===true.B) -> 32.U
    ))
}