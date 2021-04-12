package LAB8
import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
import chisel3.util.experimental.loadMemoryFromFile

class instruction extends Bundle{
    val addr = Input(UInt(32.W))
    val inst = Output(UInt(32.W))
}

class EXQ83 extends Module{
    val io = IO(new instruction)
    val mem = Mem(32, UInt(32.W))
    loadMemoryFromFile(mem, "/home/mohsin/data.txt")
    io.inst := mem(io.addr)
}