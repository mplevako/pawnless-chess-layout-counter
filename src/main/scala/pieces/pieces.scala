package pieces

import scala.math.abs

trait Piece {
  type Cell=(Int, Int)

  def cell: Cell
  def controls(anotherCell: Cell): Boolean
}

trait OrthogonalRider extends Piece {
  protected def sharesColumnWith(anotherCell: Cell): Boolean = cell._2 == anotherCell._2
  protected def sharesRowWith(anotherCell: Cell): Boolean = cell._1 == anotherCell._1

  override def controls(anotherCell: Cell): Boolean = sharesColumnWith(anotherCell) || sharesRowWith(anotherCell)
}

trait DiagonalRider extends Piece {
  protected def sharesDiagonalWith(anotherCell: Cell): Boolean = abs(cell._1 - anotherCell._1) == abs(cell._2 - anotherCell._2)

  override def controls(anotherCell: Cell): Boolean = sharesDiagonalWith(anotherCell)
}

trait KnightedPiece extends Piece {
  override def controls(anotherCell: Cell): Boolean = {
    val leapVector = (abs(anotherCell._1 - cell._1), abs(anotherCell._2 - cell._2))
    leapVector == (1,2) || leapVector == (2,1)
  }
}

trait CrownedPiece extends Piece {
  override def controls(anotherCell: Cell): Boolean =
    abs(anotherCell._1 - cell._1) <= 1 && abs(anotherCell._2 - cell._2) <= 1
}

case class King(override val cell: Piece#Cell)   extends CrownedPiece
case class Rook(override val cell: Piece#Cell)   extends OrthogonalRider
case class Bishop(override val cell: Piece#Cell) extends DiagonalRider
case class Knight(override val cell: Piece#Cell) extends KnightedPiece
case class Queen(override val cell: Piece#Cell)  extends OrthogonalRider with DiagonalRider {
  override def controls(anotherCell: Piece#Cell): Boolean = super[OrthogonalRider].controls(anotherCell) || super[DiagonalRider].controls(anotherCell)
}
