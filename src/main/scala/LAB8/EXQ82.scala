package LAB8
import chisel3._
import chisel3.util._

class Bank_2_Memory(width : Int) extends Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(Vec(2,Bool()))
    val data_in = Input(Vec(2,UInt(width.W)))
    val data_out = Output(Vec(2,UInt(width.W)))

}

class EXQ82(width:Int) extends Module{
    val io = IO(new Bank_2_Memory(width))
    val mem = SyncReadMem(1024, Vec(2, UInt(width.W)))
    val WriteDataReg = RegNext(io.data_in)
    val doFowarding = RegNext(io.enable === true.B && io.write === true.B)
    val memData = mem.read(io.addr)

    when (io.write){
        mem.write(io.addr,io.data_in,io.mask)
    }

    when(doFowarding){
        for(i <- 0 until 2){
            io.data_out(i) := Mux(doFowarding,Mux(io.mask(i),WriteDataReg(i),0.U),0.U)
        }
    }.otherwise{
        io.data_out := memData
    }

}
