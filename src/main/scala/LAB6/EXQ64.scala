package LAB6
import chisel3._
import chisel3.util._

class My_Queue extends Module{
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })

    io.out.valid := false.B
    io.out.bits := 0.U
    val queue_1 = Queue(io.in,5)
    val queue_2 = Queue(queue_1,5)

    queue_1.nodeq()
    queue_2.nodeq()

    when(queue_2.valid && io.out.ready){
        io.out.enq(queue_2.deq())
    }

}