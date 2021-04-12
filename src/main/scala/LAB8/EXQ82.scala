package LAB8
import chisel3._
import chisel3.util._

class Bank_2_Memory(width : Int) extends Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val dataIn = Input (Vec(2,UInt(width.W)))
    val dataOut = Output(Vec(2,UInt(width.W)))
    val rdAddr = Input((UInt(10. W)))
    val wrAddr = Input(UInt(10. W))
}

class EXQ82(width:Int) extends Module{
    val io = IO(new Bank_2_Memory(width))
    io.dataOut(0) := 0.U
    io.dataOut(1) := 0.U

    val bank2mem = SyncReadMem(1024,UInt(32.W))
    val bank2mem1 = SyncReadMem(1024,UInt(32.W))
    val wrDataReg_1 = RegNext(io.dataIn(0))
    val wrDataReg_2 = RegNext(io.dataIn(1))
    val DoForward = RegNext(io.wrAddr === io.rdAddr && io.enable)
    val memData1 = bank2mem.read(io.rdAddr)
    val memData2 = bank2mem1.read(io.rdAddr)

    when(io.enable){
        bank2mem.write(io.rdAddr,io.dataIn(0))
        bank2mem1.write(io.rdAddr,io.dataIn(1))
    }
    io.dataOut(0) := Mux(DoForward,wrDataReg_1,memData1)
    io.dataOut(1) := Mux(DoForward,wrDataReg_2,memData2)
}
