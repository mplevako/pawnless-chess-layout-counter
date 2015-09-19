package pieces

trait CrownedPieceSpec extends PieceSpec {
  "The piece" must "be a CrownedPiece" in piece.isInstanceOf[CrownedPiece]

  "A CrownedPiece" can "control adjacent cells in the same row" in {
    assert(piece controls (-1, 0))
    assert(piece controls (1, 0))
  }

  "A CrownedPiece" can "control adjacent cells in the same column" in {
    assert(piece controls (0, -1))
    assert(piece controls (0, 1))
  }

  "A CrownedPiece" can "control adjacent cells on the smae diagonal" in {
    assert(piece controls (-1, 1))
    assert(piece controls (-1, -1))
    assert(piece controls (1, -1))
    assert(piece controls (1, 1))
  }

  "A CrownedPiece" can "not control adjacent cells in the same row" in {
    assert(!(piece controls (-2, 0)))
    assert(!(piece controls (2, 0)))
  }

  "A CrownedPiece" can "not control adjacent cells in the same column" in {
    assert(!(piece controls (0, -2)))
    assert(!(piece controls (0, 2)))
  }

  "A CrownedPiece" can "not control adjacent cells on the same diagonal" in {
    assert(!(piece controls (-2, 2)))
    assert(!(piece controls (-2, -2)))
    assert(!(piece controls (2, -2)))
    assert(!(piece controls (2, 2)))
  } 
}