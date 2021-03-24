package LAB1

import chisel3._

class EXQ2(counterBits:UInt,maxVal:Int) extends Module {
    val io = IO (new Bundle {
       val result = Output(Bool())
     })
   val max = (1.U << counterBits)
    val count = RegInit(0.U(maxVal.W))
    when (count === max){
        count := 0.U
    }
    .otherwise{
        count := count + 1.U
}
io.result := count(0.U)

}