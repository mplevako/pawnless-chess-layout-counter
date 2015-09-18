package pieces

trait DiagonalRiderSpec extends PieceSpec {
  "the piece" must "be a DiagonalRider" in assert(piece.isInstanceOf[DiagonalRider])

  "a DiagonalRider" can "take pieces diagonal wise" in {
    assert(piece controls (-2, 2))
    assert(piece controls (-2, -2))
    assert(piece controls (2, -2))
    assert(piece controls (2, 2))
  }
}

trait NonDiagonalRiderSpec extends PieceSpec {
  "a non-diagonal rider" can "not take pieces diagonal wise" in {
    assert(!(piece controls (-1, 1)))
    assert(!(piece controls (-1, -1)))
    assert(!(piece controls (1, -1)))
    assert(!(piece controls (1, 1)))
  }
}