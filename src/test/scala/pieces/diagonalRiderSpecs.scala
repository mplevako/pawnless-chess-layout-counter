package pieces

trait DiagonalRiderSpec extends PieceSpec {
  "The piece" must "be a DiagonalRider" in assert(piece.isInstanceOf[DiagonalRider])

  "A DiagonalRider" can "control the same diagonal" in {
    assert(piece controls (-2, 2))
    assert(piece controls (-2, -2))
    assert(piece controls (2, -2))
    assert(piece controls (2, 2))
  }
}

trait NonDiagonalRiderSpec extends PieceSpec {
  "A non-diagonal rider" can "not control the same diagonal" in {
    assert(!(piece controls (-1, 1)))
    assert(!(piece controls (-1, -1)))
    assert(!(piece controls (1, -1)))
    assert(!(piece controls (1, 1)))
  }
}