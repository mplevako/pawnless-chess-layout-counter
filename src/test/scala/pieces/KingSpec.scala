package pieces

class KingSpec extends CrownedPieceSpec with NonKnightedPieceSpec {
  override def piece: Piece = King (0, 0)
}