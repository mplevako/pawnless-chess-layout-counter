package layout

import pieces.Piece

trait LayoutCounter {

  type Layout = Set[Piece]
  type PieceStock = Seq[Piece#Cell => Piece]

  /**
   * The counter counts all distinct layouts of a set of chess pieces on a chess board with given dimensions where none
   * of the pieces is in a position to take any of the others. The colour of pieces does not matter and the counter treats
   * pieces of the same kind as indistinguishable and does not count layouts that only differ in permutations of such
   * pieces as distinct.
   *
   * Arrangements are counted by placing the next piece from the given set of pieces on the board at those cells where the
   * piece does not attack the pieces already placed on the board. Then all the cells controlled by that piece are
   * removed from the set of tentative cells to be evaluated and the process recurses with the contracted set cells and pieces
   * left in the stock until either all pieces are placed on the board (which is counted as +1) or the procedure finds there
   * are leftovers that cannot be placed on the remaining part of the board (and the layout does not count). Afterwards
   * the algorithm backtracks and tries another square and/or piece.
   *
   * @param boardRows    the number of board rows
   * @param boardColumns the number of board columns
   * @param pieceStock   the set of pieces to place on the board
   * @return             the number of all distinct layouts of the set of pieces on the board where none of the pieces is
   *                     in a position to take any of the others
   */
  def countLayouts(boardRows: Int, boardColumns: Int)(pieceStock: PieceStock): Long = {
    def notTakenBy(piece: Piece) = (cell: Piece#Cell) => !(piece controls cell)

    def enumerateLayouts(openCells: Set[Piece#Cell], placedPieces: Layout, pieceStock: PieceStock): Set[Set[Piece]] = pieceStock match {
      case Nil => if(placedPieces.isEmpty) Set.empty else Set(placedPieces)
      case pieceAt::stock =>
        for {
              cell <- openCells
              currentPiece = pieceAt(cell) if placedPieces map (_.cell) forall notTakenBy(currentPiece)
              layouts <- enumerateLayouts((openCells - cell) filter notTakenBy(currentPiece),
                                          placedPieces + currentPiece, stock)
            } yield layouts
    }

    enumerateLayouts((for(r <- 0 until boardRows; c <- 0 until boardColumns) yield (r,c)).toSet, Set.empty, pieceStock).size
  }
}
