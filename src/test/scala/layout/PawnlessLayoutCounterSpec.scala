package layout

import org.scalatest.{Matchers, WordSpec}
import pieces._

class PawnlessLayoutCounterSpec extends WordSpec with Matchers with LayoutCounter {

  """The number of all distinct layouts of a set of normal chess pieces on a chess board where none of the pieces is in
     a position to take any of the others, the colour of the piece does not matter and there are no pawns among the pieces""" when {

    "the board dimensions are NxM and there are no pieces" should {
      "be 0" in { countLayouts(8, 8)(Seq.empty) shouldBe 0 }
    }

    "the board dimensions are 1x1 and there is more than one piece" should {
      "be 0" in {
        countLayouts(1, 1)(Seq(Bishop,King)) shouldBe 0
        countLayouts(1, 1)(Seq(King,Knight)) shouldBe 0
        countLayouts(1, 1)(Seq(Queen,Rook))  shouldBe 0
      }
    }

    "the board dimensions are 100x100 and there is only one piece" should {
      "be 10000" in {
        countLayouts(100, 100)(Seq(Bishop)) shouldBe 10000
        countLayouts(100, 100)(Seq(King))   shouldBe 10000
        countLayouts(100, 100)(Seq(Knight)) shouldBe 10000
        countLayouts(100, 100)(Seq(Queen))  shouldBe 10000
        countLayouts(100, 100)(Seq(Rook))   shouldBe 10000
      }
    }

    "the board dimensions are 3x3 and there are 2 kings and 1 rook" should {
      "be 4" in { countLayouts(3, 3)(Seq.fill(2)(King) ++ Seq(Rook)) shouldBe 4 }
    }

    "the board dimensions are 4x4 and there are 2 rooks and 4 knights" should {
      "be 8" in { countLayouts(4, 4)(Seq.fill(2)(Rook) ++ Seq.fill(4)(Knight)) shouldBe 8 }
    }

    "the board dimensions are QxQ and there are Q queens" should {
      "be 1 when Q is 1"  in { countLayouts(1, 1)(Seq.fill(1)(Queen)) shouldBe 1 }
      "be 0 when Q is 2"  in { countLayouts(2, 2)(Seq.fill(2)(Queen)) shouldBe 0 }
      "be 0 when Q is 3"  in { countLayouts(3, 3)(Seq.fill(3)(Queen)) shouldBe 0 }
      "be 2 when Q is 4"  in { countLayouts(4, 4)(Seq.fill(4)(Queen)) shouldBe 2 }
      "be 10 when Q is 5" in { countLayouts(5, 5)(Seq.fill(5)(Queen)) shouldBe 10 }
      "be 4 when Q is 6"  in { countLayouts(6, 6)(Seq.fill(6)(Queen)) shouldBe 4 }
      "be 40 when Q is 7" in { countLayouts(7, 7)(Seq.fill(7)(Queen)) shouldBe 40 }
      "be 92 when Q is 8" in { countLayouts(8, 8)(Seq.fill(8)(Queen)) shouldBe 92 }
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
