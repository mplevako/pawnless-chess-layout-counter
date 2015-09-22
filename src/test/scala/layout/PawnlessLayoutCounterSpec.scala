package layout

import org.scalatest.{Matchers, WordSpec}
import pieces.{Knight, Rook, Queen}

class PawnlessLayoutCounterSpec extends WordSpec with Matchers with LayoutCounter {

  """The number of all distinct layouts of a set of normal chess pieces on a chess board where none of the pieces is in
     a position to take any of the others, the colour of the piece does not matter and there are no pawns among the pieces""" when {

    "the board dimensions are 8x8 and there are Q queens" should {
      "be 2 for 4 queens"    in countLayouts(8, 8)(Seq.fill(4)(Queen))  shouldBe 2
      "be 10 for 5 queens"   in countLayouts(8, 8)(Seq.fill(5)(Queen))  shouldBe 10
      "be 4 for 6 queens"    in countLayouts(8, 8)(Seq.fill(6)(Queen))  shouldBe 4
      "be 92 for 8 queens"   in countLayouts(8, 8)(Seq.fill(8)(Queen))  shouldBe 92
      "be 724 for 10 queens" in countLayouts(8, 8)(Seq.fill(10)(Queen)) shouldBe 724
    }

    "the board dimensions are RxR and there are R rooks" must {
      "be 24 when M is 4"  in countLayouts(4, 4)(Seq.fill(4)(Rook)) shouldBe 24
      "be 120 when M is 5" in countLayouts(4, 4)(Seq.fill(5)(Rook)) shouldBe 120
      "be 720 when M is 6" in countLayouts(4, 4)(Seq.fill(6)(Rook)) shouldBe 720
    }

    "the board dimensions are 8x8 and there are 5 queens and 5 knights" must {
      "be 16" in countLayouts(8, 8)(Seq.fill(5)(Queen) ++ Seq.fill(5)(Knight)) shouldBe 16
    }
  }

}
