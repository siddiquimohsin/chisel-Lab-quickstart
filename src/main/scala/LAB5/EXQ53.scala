package LAB5
import chisel3._
import chisel3.util._
class Operator[T <: Data](n:Int, generic:T)(op:(T,T) => T) extends Module {
require (n > 0)
val io = IO(new Bundle {
val in = Input(Vec(n,generic))
val out = Output(Vec(n,generic))
})

for(i<-0 to n-1){
    io.out(i) := io.in.reduce(op)
}
}