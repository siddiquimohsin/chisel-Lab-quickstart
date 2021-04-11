package LAB7
import chisel3._
import chisel3.util . _
import chisel3.experimental.ChiselEnum
import chisel3.experimental.{withClock , withReset , withClockAndReset}


class Manchester extends Bundle {
    val in = Input (UInt(1.W))
    val start = Input (Bool())
    val out = Output (UInt(8.W))
    val flag = Output (UInt(1.W))
}

class Task72 extends Module{
    val io =IO (new Manchester)
    val register = RegInit(0.U(8.W))
    io.out:=0.U
    io.flag:=0.U
    switch (io.start){
        is (true.B){
            when (io.in === 1.U){
                register:= register << 1.U | io.in
                io.out:=register

            }.otherwise{
                register:= register << 1.U
                io.out := register
            }
        }
        is (false.B){
            io.out:=register
            io.flag:=0.U
        }
    }
}