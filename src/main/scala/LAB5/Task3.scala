package LAB5
import chisel3._
import chisel3.util._
class eMux[T <: Data ](gen:T , gen1:T) extends Module {
val io = IO(new Bundle{
val out = Output(gen)
val in1 = Input(gen)
val in2 = Input(gen1)
val sel = Input(Bool())
})
when(io.sel === 0.B){
    io.out := io.in1
}.otherwise{
    io.out := io.in2
}
}
