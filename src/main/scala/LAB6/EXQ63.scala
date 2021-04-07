package LAB6
import chisel3._
import chisel3.util._


class twoshot(width:Int,max : Int) extends Module{
    val io = IO(new Bundle{
        val high = Output(Bool())
    })
    val timer = RegInit(max.U(width.W))
    val incr = RegInit(max.U(width.W))
    io.high := false.B
    
    when (timer === max.U){
        io.high:=1.B
        timer:=timer-1.U
        incr:=incr-1.U
    }.elsewhen(timer === 0.U){
        when(incr === 0.U){
            io.high:=1.B
            incr := incr +1.U
        }.elsewhen(incr === max.U){
            io.high:=1.B
            timer:=max.U
        }.otherwise{
            io.high:=0.B
            incr:=incr+1.U
        }
    }.otherwise{
        io.high:=0.B
        incr:=incr-1.U
        timer:=timer-1.U
    }
}