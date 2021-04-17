package LAB8

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum


class EXQ81 extends Module {
    val io = IO (new Bundle {
        val enable = Input(Bool())
        val write = Input(Bool())
        val addr = Input(UInt(10.W))
        val mask = Input(Vec(4,Bool()))
        val dataIn = Input(Vec(4,UInt(8.W)))
        val dataOut = Output(Vec(4,UInt(8.W)))
    })
     val mem = SyncReadMem(1024,Vec(4,UInt(8.W)))
     val data = Reg(Vec(4,UInt()))

     val Con = Cat(io.mask(3) , io.mask(2) , io.mask(1) , io.mask(0))

     when(io.write === true.B){
        when(Con === 1.U){
            data(0) := io.dataIn(0)
            data(1) := 0.U
            data(2) := 0.U
            data(3) := 0.U
        }.elsewhen(Con === 2.U){
            data(0) := 0.U
            data(1) := io.dataIn(1)
            data(2) := 0.U
            data(3) := 0.U
            mem.write(io.addr, data)
        }.elsewhen(Con === 3.U){
            data(0) := io.dataIn(0)
            data(1) := io.dataIn(1)
            data(2) := 0.U
            data(3) := 0.U
            mem.write(io.addr, data)
        }.elsewhen(Con === 4.U){
            data(0) := 0.U
            data(1) := 0.U
            data(2) := io.dataIn(2)
            data(3) := 0.U
            mem.write(io.addr, data)
        }.elsewhen(Con === 5.U){
            data(0) := io.dataIn(0)
            data(1) := 0.U
            data(2) := io.dataIn(2)
            data(3) := 0.U
            mem.write(io.addr, data)
        }.elsewhen(Con === 6.U){
            data(0) := 0.U
            data(1) := io.dataIn(1)
            data(2) := io.dataIn(2)
            data(3) := 0.U
            mem.write(io.addr, data)
        }.elsewhen(Con === 7.U){
            data(0) := io.dataIn(0)
            data(1) := io.dataIn(1)
            data(2) := io.dataIn(2)
            data(3) := 0.U
            mem.write(io.addr, data)
        }.elsewhen(Con === 8.U){
            data(0) := 0.U
            data(1) := 0.U
            data(2) := 0.U
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 9.U){
            data(0) := io.dataIn(0)
            data(1) := 0.U
            data(2) := 0.U
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 10.U){
            data(0) := 0.U
            data(1) := io.dataIn(1)
            data(2) := 0.U
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 11.U){
            data(0) := io.dataIn(0)
            data(1) := io.dataIn(1)
            data(2) := 0.U
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 12.U){
            data(0) := 0.U
            data(1) := 0.U
            data(2) := io.dataIn(2)
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 13.U){
            data(0) := io.dataIn(0)
            data(1) := 0.U
            data(2) := io.dataIn(2)
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 14.U){
            data(0) := 0.U
            data(1) := io.dataIn(1)
            data(2) := io.dataIn(2)
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }.elsewhen(Con === 15.U){
            data(0) := io.dataIn(0)
            data(1) := io.dataIn(1)
            data(2) := io.dataIn(2)
            data(3) := io.dataIn(3)
            mem.write(io.addr, data)
        }

    }

    io.dataOut := mem.read(io.addr,io.enable)

}