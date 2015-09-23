package layout

import org.scalatest.{Matchers, WordSpec}
import pieces.{King, Knight, Queen, Rook}

class PawnlessLayoutCounterSpec extends WordSpec with Matchers with LayoutCounter {

  """The number of all distinct layouts of a set of normal chess pieces on a chess board where none of the pieces is in
     a position to take any of the others, the colour of the piece does not matter and there are no pawns among the pieces""" when {

    "the board dimensions are NxM and there are no pieces" should {
      "be 0" in { countLayouts(8, 8)(Seq.empty) shouldBe 0 }
    }

    "the board dimensions are 3x3 and there are 2 kings and 1 rook" should {
      "be 4" in { countLayouts(3, 3)(Seq.fill(2)(King) ++ Seq(Rook)) shouldBe 4 }
    }

    "the board dimensions are 4x4 and there are 2 rooks and 4 knights" should {
      "be 8" in { countLayouts(4, 4)(Seq.fill(2)(Rook) ++ Seq.fill(4)(Knight)) shouldBe 8 }
    }

    "the board dimensions are QxQ and there are Q queens" should {
      "be 2 when Q is 4"    in { countLayouts(4, 4)(Seq.fill(4)(Queen))    shouldBe 2 }
      "be 10 when Q is 5"   in { countLayouts(5, 5)(Seq.fill(5)(Queen))    shouldBe 10 }
      "be 4 when Q is 6"    in { countLayouts(6, 6)(Seq.fill(6)(Queen))    shouldBe 4 }
      "be 92 when Q is 8"   in { countLayouts(8, 8)(Seq.fill(8)(Queen))    shouldBe 92 }
      "be 724 when Q is 10" in { countLayouts(10, 10)(Seq.fill(10)(Queen)) shouldBe 724 }
    }

    "the board dimensions are RxR and there are R rooks" must {
      "be 24 when R is 4"  in { countLayouts(4, 4)(Seq.fill(4)(Rook)) shouldBe 24 }
      "be 120 when R is 5" in { countLayouts(5, 5)(Seq.fill(5)(Rook)) shouldBe 120 }
      "be 720 when R is 6" in { countLayouts(6, 6)(Seq.fill(6)(Rook)) shouldBe 720 }
    }

    "the board dimensions are 8x8 and there are 5 queens and 5 knights" must {
      "be 16" in { countLayouts(8, 8)(Seq.fill(5)(Queen) ++ Seq.fill(5)(Knight)) shouldBe 16 }
    }
  }
}
