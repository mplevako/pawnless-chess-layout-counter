package pieces

class KnightSpec extends KnightedPieceSpec with NonOrthogonalRiderSpec with NonDiagonalRiderSpec {
  override val piece: Piece = Knight (0, 0)
}