package LAB2
import chisel3._

class Mux2to1 extends Module {
       val io=IO(new Bundle{ 
        val in_A= Input(UInt(32.W))
        val in_B= Input(UInt(32.W))
        val sel=Input(Bool())
        val out=Output(UInt(32.W))
})
    when(io.sel === 0.U){
        io.out := io.in_A
    }.otherwise{
        io.out := io.in_B
    }
}