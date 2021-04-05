package LAB5
import chisel3._
import chisel3.util._
class mux[T <: Data](gen : T) extends Module{
val io = IO (new Bundle{
val out = Output(gen)
val in1 = Input(gen)
val in2 = Input(gen)
val sel = Input(Bool())
})
io.out:= Mux(io.sel,io.in1,io.in2)
}