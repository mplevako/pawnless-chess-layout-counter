package pieces

class RookSpec extends OrthogonalRiderSpec with NonDiagonalRiderSpec with NonKnightedPieceSpec {
  override val piece: Piece = Rook (0, 0)
}