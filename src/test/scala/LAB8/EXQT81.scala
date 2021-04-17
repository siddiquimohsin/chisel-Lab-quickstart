package LAB8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class EXQT81 extends FreeSpec with ChiselScalatestTester {

  "EXQT81" in {
    test(new EXQ81){ c =>

      c.io.addr.poke(3.U)
      c.io.dataIn(0).poke(5.U)
      c.io.dataIn(1).poke(9.U)
      c.io.dataIn(2).poke(2.U)
      c.io.dataIn(3).poke(4.U)
      c.io.enable.poke(true.B)
      c.io.write.poke(1.B)
      c.io.mask(0).poke(1.B)
      c.io.mask(1).poke(1.B)
      c.io.mask(2).poke(0.B)
      c.io.mask(3).poke(0.B)
      c.clock.step(25)
    }
  }
}