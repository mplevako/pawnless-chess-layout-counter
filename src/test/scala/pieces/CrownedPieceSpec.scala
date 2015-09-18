package pieces

trait CrownedPieceSpec extends PieceSpec {
  "the piece" must "be a CrownedPiece" in piece.isInstanceOf[CrownedPiece]

  "a CrownedPiece" can "take neighbour pieces row wise" in {
    assert(piece controls (-1, 0))
    assert(piece controls (1, 0))
  }

  "a CrownedPiece" can "take neighbour pieces column wise" in {
    assert(piece controls (0, -1))
    assert(piece controls (0, 1))
  }

  "a CrownedPiece" can "take neighbour pieces diagonal wise" in {
    assert(piece controls (-1, 1))
    assert(piece controls (-1, -1))
    assert(piece controls (1, -1))
    assert(piece controls (1, 1))
  }

  "a CrownedPiece" can "not take non-neighbour pieces row wise" in {
    assert(!(piece controls (-2, 0)))
    assert(!(piece controls (2, 0)))
  }

  "a CrownedPiece" can "not take non-neighbour pieces column wise" in {
    assert(!(piece controls (0, -2)))
    assert(!(piece controls (0, 2)))
  }

  "a CrownedPiece" can "not take non-neighbour pieces diagonal wise" in {
    assert(!(piece controls (-2, 2)))
    assert(!(piece controls (-2, -2)))
    assert(!(piece controls (2, -2)))
    assert(!(piece controls (2, 2)))
  } 
}