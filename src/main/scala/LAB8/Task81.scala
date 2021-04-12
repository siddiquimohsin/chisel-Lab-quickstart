package LAB8
import chisel3._
import chisel3.util._

class memory_assignment extends Module{
val io = IO(new Bundle{
val memory_out = Vec(4,Output(UInt(32.W)))
val requestor = Vec(4,Flipped(Decoupled(UInt(32.W))))
val addr = Input(UInt(5.W))


})
io.memory_out(0) := 0.U
io.memory_out(1) := 0.U
io.memory_out(2) := 0.U
io.memory_out(3) := 0.U
val memory_1 = Mem(1024,UInt(32.W))
val memory_2 = Mem(1024,UInt(32.W))
val memory_3 = Mem(1024,UInt(32.W))
val memory_4 = Mem(1024,UInt(32.W))

val queue_1 = Queue(io.requestor(0),4)
val queue_2 = Queue(io.requestor(1),4)
val queue_3 = Queue(io.requestor(2),4)
val queue_4 = Queue(io.requestor(3),4)

val arbiter_priority = Module(new Arbiter(UInt(),4))

arbiter_priority.io.in(0) <> queue_1
arbiter_priority.io.in(1) <> queue_2
arbiter_priority.io.in(2) <> queue_3
arbiter_priority.io.in(3) <> queue_4

arbiter_priority.io.out.nodeq()

when(io.requestor(0).valid){
    memory_1.write(io.addr,arbiter_priority.io.out.bits)
    io.memory_out(0):= memory_1.read(io.addr)
}.elsewhen(io.requestor(1).valid){
    memory_2.write(io.addr,arbiter_priority.io.out.bits)
    io.memory_out(1):= memory_2.read(io.addr)
}.elsewhen(io.requestor(2).valid){
    memory_3.write(io.addr,arbiter_priority.io.out.bits)
    io.memory_out(2) := memory_3.read(io.addr)
}.elsewhen(io.requestor(3).valid){
    memory_4.write(io.addr,arbiter_priority.io.out.bits)
    io.memory_out(3) := memory_4.read(io.addr)
}


}

