package pieces

trait OrthogonalRiderSpec extends PieceSpec {
  "the piece" must "be a OrthogonalRider" in assert(piece.isInstanceOf[OrthogonalRider])

  "an OrthogonalRider" can "take row wise" in {
    assert(piece controls (-2, 0))
    assert(piece controls (2, 0))
  }

  "an OrthogonalRider" can "take column wise" in {
    assert(piece controls (0, 2))
    assert(piece controls (0, -2))
  }
}

trait NonOrthogonalRiderSpec extends PieceSpec {
  "a non-orthogonal rider" can "not take row wise" in {
    assert(!(piece controls (-1, 0)))
    assert(!(piece controls (1, 0)))
  }

  "a non-orthogonal rider" can "not take column wise" in {
    assert(!(piece controls (0, -1)))
    assert(!(piece controls (0, 1)))
  }
}