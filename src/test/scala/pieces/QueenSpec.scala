package pieces

class QueenSpec extends OrthogonalRiderSpec with DiagonalRiderSpec with NonKnightedPieceSpec{
  override val piece: Piece = Queen (0, 0)
}