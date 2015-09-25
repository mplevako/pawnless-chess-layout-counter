package layout

import pieces.Piece

import scala.annotation.tailrec

trait LayoutCounter {

  type Layout = Set[Piece]
  type PieceStock = Seq[Piece#Cell => Piece]

  /**
   * The counter counts all distinct layouts of a set of chess pieces on a chess board with given dimensions where none
   * of the pieces is in a position to take any of the others. The colour of pieces does not matter and the counter treats
   * pieces of the same kind as indistinguishable and does not count layouts that only differ in permutations of such
   * pieces as distinct.
   *
   * Starting with an empty board the counter yields a set of partial candidates for solutions by placing the next piece
   * from the given set of pieces on the board at those cells where the piece does not attack the pieces already placed on the
   * board and the latter do not attack the first. If it is possible the candidates are extended by adding such pieces, if not
   * the algorithm backtracks.
   *
   * @param boardRows    the number of board rows
   * @param boardColumns the number of board columns
   * @param pieceStock   the set of pieces to place on the board
   * @return             the number of all distinct layouts of the set of pieces on the board where none of the pieces is
   *                     in a position to take any of the others
   */
  def countLayouts(boardRows: Int, boardColumns: Int)(pieceStock: PieceStock): Int = {
    require(boardRows >= 0)
    require(boardColumns >= 0)

    val board = for{r <- 0 until boardRows
                    c <- 0 until boardColumns} yield (r,c)

    @tailrec
    def enumerateLayouts(partialCandidates: Set[Layout], pieceStock: PieceStock): Set[Layout] = pieceStock match {
      case Nil => partialCandidates
      case pieceAt::stock =>
        val extendedCandidates = for { placedPieces <- partialCandidates
                                       cell <- board if placedPieces forall (_.cell != cell)
                                       currentPiece = pieceAt(cell)
                                       if placedPieces forall (placedPiece => !(currentPiece controls placedPiece.cell) && !(placedPiece controls cell))
        } yield placedPieces + currentPiece
        enumerateLayouts(extendedCandidates, stock)
    }

    if(pieceStock.isEmpty) 0 else enumerateLayouts(Set(Set.empty[Piece]), pieceStock).size
  }
}
