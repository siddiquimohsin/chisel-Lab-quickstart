package LAB7
import chisel3._
import chisel3.util._

class input_output(n:Int)extends Bundle{
    val in = Vec(2,Flipped(Decoupled(UInt(n.W))))
    val out = Decoupled(UInt(n.W))
}

class Arbiter_with_Queue(n:Int)extends Module{
    val io = IO(new input_output(n))
    io.out.bits:=0.U
    io.out.valid:=false.B
    val queue_1 = Queue(io.in(0),n)
    val queue_2 = Queue(io.in(1),n)
    val arbiter_priority = Module(new Arbiter(UInt(),2))

    queue_1.nodeq()
    queue_2.nodeq()

    arbiter_priority.io.in(0) <> queue_1
    arbiter_priority.io.in(1) <> queue_2

    io.out <> arbiter_priority.io.out
}