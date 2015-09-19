package pieces

trait OrthogonalRiderSpec extends PieceSpec {
  "The piece" must "be a OrthogonalRider" in assert(piece.isInstanceOf[OrthogonalRider])

  "An OrthogonalRider" can "control the same row" in {
    assert(piece controls (-2, 0))
    assert(piece controls (2, 0))
  }

  "An OrthogonalRider" can "control the same column" in {
    assert(piece controls (0, 2))
    assert(piece controls (0, -2))
  }
}

trait NonOrthogonalRiderSpec extends PieceSpec {
  "A non-orthogonal rider" can "not control the same row" in {
    assert(!(piece controls (-1, 0)))
    assert(!(piece controls (1, 0)))
  }

  "A non-orthogonal rider" can "not control the same column" in {
    assert(!(piece controls (0, -1)))
    assert(!(piece controls (0, 1)))
  }
}