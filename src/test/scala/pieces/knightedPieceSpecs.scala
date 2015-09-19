package pieces

trait KnightedPieceSpec extends PieceSpec {
  "The piece" must "be a KnightedPiece" in assert(piece.isInstanceOf[KnightedPiece])

  "A KnightedPiece" can "control cells that are two cells vertically and one cell horizontally" in {
    assert(piece controls (-1, 2))
    assert(piece controls (-1, -2))
    assert(piece controls (1, -2))
    assert(piece controls (1, 2))
  }

  "A KnightedPiece" can "control cells that are two cells horizontally and one cell vertically" in {
    assert(piece controls (-2, 1))
    assert(piece controls (-2, -1))
    assert(piece controls (2, -1))
    assert(piece controls (2, 1))
  }
}

trait NonKnightedPieceSpec extends PieceSpec {
  "A non-knighted piece" can "not control cells that are two cells vertically and one cell horizontally" in {
    assert(!(piece controls (-1, 2)))
    assert(!(piece controls (-1, -2)))
    assert(!(piece controls (1, -2)))
    assert(!(piece controls (1, 2)))
  }

  "A non-knighted piece" can "not control cells that are two cells horizontally and one cell vertically" in {
    assert(!(piece controls (-2, 1)))
    assert(!(piece controls (-2, -1)))
    assert(!(piece controls (2, -1)))
    assert(!(piece controls (2, 1)))
  }
}