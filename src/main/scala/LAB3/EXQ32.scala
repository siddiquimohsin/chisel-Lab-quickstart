package LAB3
import chisel3._
import chisel3.util._

class ALU extends Module{
	val io = IO(new Bundle{
	val A = Input(SInt(32.W))
	val B = Input(SInt(32.W))
	val ALUcontrol= Input(UInt(5.W))
	val output = Output(SInt(32.W))
	val Branch = Output(UInt(1.W))
})
    io.output := 0.S
	io.Branch := "b0".U
	val com = "b10".U
	val com1 = "b1".U
	val sbt1 = io.ALUcontrol(4,3)

    switch(io.ALUcontrol){
        is("b00000".U){
            io.output := io.A + io.B
        }
        is ("b00001".U){
            val sbt = io.B.asUInt
	        val sbt3 = io.B(4,0)
	        val sbt4 = io.A.asUInt
	        val sbt5 = sbt4 << sbt3
	        val sbt6 = sbt5.asSInt
	        io.output := sbt6
        }
        is ("b00010".U){
            when(io.A < io.B){
	            io.output := 1.S}
        }
        is ("b00011".U){
            val sbt = io.A.asUInt
	        val sbt3 = io.B.asUInt
	        when(sbt < sbt3){
	            io.output := 1.S}
	        when(com === sbt1){
	            io.Branch := "b1".U}
        }
        is ("b00100".U){
            val sbt2 = io.A.asUInt
	        val sbt3 = io.B.asUInt
	        val sbt4 = sbt2 ^ sbt3
	        val sbt5 = sbt4.asSInt
	        io.output := sbt5
        }
        is("b00101".U){
            val sbt = io.B.asUInt
	        val sbt3 = io.B(4,0)
	        val sbt4 = io.A.asUInt
	        val sbt5 = sbt4 >> sbt3
	        val sbt6 = sbt5.asSInt
	        io.output := sbt6
        }
        is("b00110".U){
            val sbt2 = io.A.asUInt
	        val sbt3 = io.B.asUInt
	        val sbt4 = sbt2 | sbt3
	        val sbt5 = sbt4.asSInt
	        io.output := sbt5
        }
        is("b00111".U){
            val sbt2 = io.A.asUInt
	        val sbt3 = io.B.asUInt
	        val sbt4 = sbt2 & sbt3
	        val sbt5 = sbt4.asSInt
	        io.output := sbt5
        }
        is("b01000".U){
            io.output := io.A - io.B
        }
        is("b01101".U){
            val sbt3 = io.B(4,0)
    	    io.output := io.A >> sbt3
        }
        is("b10000".U){
            when(io.A === io.B){
	            io.output := 1.S
	            io.Branch := "b1".U}
        }
        is("b10001".U){
            when(io.A =/= io.B){
	            io.output := 1.S
	            io.Branch := "b1".U}
        }
        is("b10100".U){
            when(io.A < io.B){
	            io.output := 1.S
	            io.Branch := "b1".U}
        }
        is("b10101".U){
            when(io.A > io.B){
	            io.output := 1.S
	            io.Branch := "b1".U}
        }
        is("b10110".U){
            val sbt = io.A.asUInt
	        val sbt3 = io.B.asUInt
	        when(sbt < sbt3){
	            io.output := 1.S}

            when(com === sbt1 & io.output === 1.S){
	            io.Branch := "b1".U}
        }
        is("b10111".U){
            val sbt = io.A.asUInt
	        val sbt3 = io.B.asUInt
	        when(sbt > sbt3){
	            io.output := 1.S}
	        when(com === sbt1 & io.output === 1.S){
	            io.Branch := "b1".U}
        }
        is("b11111".U){
            io.output := io.A
        }
    }
}