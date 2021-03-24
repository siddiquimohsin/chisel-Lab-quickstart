package LAB1

import chisel3._

class EXQ3(size:Int,maxValue:Int) extends Module {
    val io = IO ( new Bundle {
        val result = Output (Bool())
    })
    
    def genCounter(n:Int,max:Int )={
        val count=RegInit(0.U(n.W))
        val max1 = max.asUInt
        when( count === max1 ){
            count := 0.U
        }.elsewhen(count(n-1) === 1.U){
            count := 0.U
        }.otherwise{
            count := count + 1.U
        }
        count
    }
val counter1=genCounter(size,maxValue)
io.result := counter1(size-1)
}
