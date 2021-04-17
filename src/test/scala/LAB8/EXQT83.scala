package LAB8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class EXQT83 extends FreeSpec with ChiselScalatestTester {

  "EXQT83" in {
    test(new EXQ83) { c =>
      c.io.addr.poke(3.U)
      c.io.instwrite.poke("h00500193".U)
      c.io.write.poke(true.B)
      c.clock.step(2)

      c.io.write.poke(false.B)
      c.io.addr.poke(3.U)
      c.clock.step(2)
    }
  }
}