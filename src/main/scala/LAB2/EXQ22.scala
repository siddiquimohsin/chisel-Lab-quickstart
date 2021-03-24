package LAB2
import chisel3 . _
import chisel3 . util . _
class Mux8to1 extends Module {
    val io = IO ( new Bundle {
        val in0 = Input (UInt(4.W))
        val in1 = Input (UInt(4.W))
        val in2 = Input (UInt(4.W))
        val in3 = Input (UInt(4.W))
        val in4 = Input (UInt(4.W))
        val in5 = Input (UInt(4.W))
        val in6 = Input (UInt(4.W))
        val in7 = Input (UInt(4.W))
        val sel1 = Input (UInt(1.W ))
        val sel2 = Input(UInt(2.W)) 
        val out = Output (UInt(4.W))
    })
    val Mux1=MuxLookup(io.sel1,false.B,Array(
    (0.U) -> io.in0 ,
    (1.U) -> io.in1 ,
    (2.U) -> io.in2 ,
    (3.U) -> io.in3 ,
    ))

    val Mux2=MuxLookup(io.sel1,false.B,Array(
    (0.U) -> io.in4 ,
    (1.U) -> io.in5 ,
    (2.U) -> io.in6 ,
    (3.U) -> io.in7 ,
    ))


    io.out := MuxLookup ( io.sel1, false.B , Array (
    (0.U ) ->Mux1 ,
    (1.U ) ->Mux2)
)
}