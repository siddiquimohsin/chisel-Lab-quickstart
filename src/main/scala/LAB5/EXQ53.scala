package LAB5
import chisel3._
import chisel3.util._
class Operator[T <: Data](n:Int, generic:T)(op:(T,T) => T) extends Module {
require ( n > 0)
val io = IO ( new Bundle {
val in = Input(Vec(n,generic))
val out = Output(Vec(2,generic))
})
io.out(0):= 0.U
io.out(1):= io.in.reduce(op)
}