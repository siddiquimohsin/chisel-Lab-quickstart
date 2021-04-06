package LAB5
import chisel3._
import chisel3.util._

class DataPackets[T <: Data](gen : T) extends Bundle{
    val address = UInt(10.W)
    val data = gen
    override def cloneType=(new DataPackets(gen)).asInstanceOf[this.type]
}

class Task2[T <: Data](gen:T,gen1:T) extends Module{
    val io = IO(new Bundle{
        val in = Input(new DataPackets(gen))
        val out = Output(new DataPackets(gen1))
    })
    io.out.address := io.in.address
    io.out.data := io.in.data
}