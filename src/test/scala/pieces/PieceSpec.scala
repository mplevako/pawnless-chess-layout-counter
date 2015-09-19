package pieces

import org.scalatest.FlatSpec

trait PieceSpec extends FlatSpec {
  def piece: Piece

  "Pieces" can "not control cells that are (1,3) or (3,1) cells away" in {
    assert(!(piece controls (-1, 3)))
    assert(!(piece controls (-1, -3)))
    assert(!(piece controls (1, -3)))
    assert(!(piece controls (1, 3)))

    assert(!(piece controls (-3, 1)))
    assert(!(piece controls (-3, -1)))
    assert(!(piece controls (3, -1)))
    assert(!(piece controls (3, 1)))
  }
}