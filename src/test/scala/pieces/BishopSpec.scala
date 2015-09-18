package pieces

class BishopSpec extends DiagonalRiderSpec with NonOrthogonalRiderSpec with NonKnightedPieceSpec {
  override val piece: Piece = Bishop (0, 0)
}