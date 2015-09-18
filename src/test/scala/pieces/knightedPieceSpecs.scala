package pieces

trait KnightedPieceSpec extends PieceSpec {
  "the piece" must "be a KnightedPiece" in assert(piece.isInstanceOf[KnightedPiece])

  "a KnightedPiece" can "take pieces in cells that are two cells vertically and one cell horizontally" in {
    assert(piece controls (-1, 2))
    assert(piece controls (-1, -2))
    assert(piece controls (1, -2))
    assert(piece controls (1, 2))
  }

  "a KnightedPiece" can "take pieces in cells that are two cells horizontally and one cell vertically" in {
    assert(piece controls (-2, 1))
    assert(piece controls (-2, -1))
    assert(piece controls (2, -1))
    assert(piece controls (2, 1))
  }
}

trait NonKnightedPieceSpec extends PieceSpec {
  "a non-knighted piece" can "not take pieces in cells that are two cells vertically and one cell horizontally" in {
    assert(!(piece controls (-1, 2)))
    assert(!(piece controls (-1, -2)))
    assert(!(piece controls (1, -2)))
    assert(!(piece controls (1, 2)))
  }

  "a non-knighted piece" can "take pieces in cells that are two cells horizontally and one cell vertically" in {
    assert(!(piece controls (-2, 1)))
    assert(!(piece controls (-2, -1)))
    assert(!(piece controls (2, -1)))
    assert(!(piece controls (2, 1)))
  }
}