package LAB2
import chisel3 . _
import chisel3 . util . _
class Task22 extends Module {
val io = IO (new Bundle{
val in = Vec(4,Input(Bool()))
val sel = Vec(2,Input(Bool()))
val shift_type = Input(Bool())
val out = Vec (4,Output(Bool()))
})
// Start you code here

io.out(0) := MuxCase(false.B,Array(
    (io.sel(0)===0.B && io.sel(1)===0.B) -> io.in(0),
    (io.sel(0)===0.B && io.sel(1)===1.B) -> io.in(1),
    (io.sel(0)===1.B && io.sel(1)===0.B) -> io.in(2),
    (io.sel(0)===1.B && io.sel(1)===1.B) -> io.in(3)
))
io.out(1) := MuxCase(false.B,Array(
    (io.sel(0)===0.B && io.sel(1)===0.B) -> io.in(1),
    (io.sel(0)===0.B && io.sel(1)===1.B) -> io.in(2),
    (io.sel(0)===1.B && io.sel(1)===0.B) -> io.in(3),
    (io.sel(0)===1.B && io.sel(1)===1.B) -> Mux(io.shift_type,io.in(0) << 1.U,io.in(0) >> 1.U)
))
io.out(2) := MuxCase(false.B,Array(
    (io.sel(0)===0.B && io.sel(1)===0.B) -> io.in(2),
    (io.sel(0)===0.B && io.sel(1)===1.B) -> io.in(3),
    (io.sel(0)===1.B && io.sel(1)===0.B) -> Mux(io.shift_type,io.in(0) << 1.U,io.in(0) >> 1.U),
    (io.sel(0)===1.B && io.sel(1)===1.B) -> Mux(io.shift_type,io.in(1) << 1.U,io.in(1) >> 1.U)
))
io.out(3) := MuxCase(false.B,Array(
    (io.sel(0)===0.B && io.sel(1)===0.B) -> io.in(3),
    (io.sel(0)===0.B && io.sel(1)===1.B) -> Mux(io.shift_type,io.in(0) << 1.U,io.in(0) >> 1.U),
    (io.sel(0)===1.B && io.sel(1)===0.B) -> Mux(io.shift_type,io.in(1) << 1.U, io.in(1) >> 1.U),
    (io.sel(0)===1.B && io.sel(1)===1.B) -> Mux(io.shift_type,io.in(2) << 1.U,io.in(2) >> 1.U)
))
// End your code here
}