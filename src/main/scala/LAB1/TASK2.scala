package LAB1
import chisel3._

class Task2(size:Int,maxValue:Int) extends Module {
    val io = IO (new Bundle {
        val out = Output (Bool () )
    })
    
    def genCounter (n:Int, max:Int ) = {
        val count = RegInit(0.U(n.W))
        val count_max = RegInit(0.U(n.W))
        val max1=max.asUInt
        io.out := 1.B
        when(count===max1){
            io.out := 1.B
            when(count_max===count){
                io.out := 1.B
                count_max := count_max-1.U
            }.elsewhen(count_max>0.U){
                count_max := count_max-1.U
                io.out := 0.B
            }.otherwise{
                io.out := 1.B
                count := 0.U
            }
        }.elsewhen(count===0.U){
            io.out := 1.B
            count:=count+1.U
            count_max:= count_max+1.U
        }.elsewhen(count<max1){
            count:=count+1.U
            count_max:=count_max+1.U
            io.out := 0.B
        }
        count
    }
val counter = genCounter ( size , maxValue )
}