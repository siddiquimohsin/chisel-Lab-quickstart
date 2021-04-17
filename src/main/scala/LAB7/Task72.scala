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
    val s0 :: s1 :: Nil = Enum(2)
    val state = RegInit(s0)
    val register = RegInit(0.U(8.W))
    io.out:=0.U
    io.flag:=0.U
    when(state === s0){
        when(io.start === true.B){
            state:=s1        
        }.otherwise{
            io.out:=register
            io.flag:=false.B
        }
    }.elsewhen(state === s1){
        when(io.start === false.B){
            state := s0
        }.otherwise{
            register:=(register << 1.U) | io.in
            io.out:=register
            io.flag:=true.B
        }
    }
}