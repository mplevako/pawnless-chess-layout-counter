package pieces

import org.scalatest.FlatSpec

trait PieceSpec extends FlatSpec {
  def piece: Piece

  "pieces" can "not take pieces like a (1,3)-leaper" in {
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