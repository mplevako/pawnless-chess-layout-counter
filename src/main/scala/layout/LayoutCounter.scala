package layout

import pieces.Piece

trait LayoutCounter {

  type Layout = Set[Piece]
  type PieceStock = Seq[Piece#Cell => Piece]

  def countLayouts(boardRows: Int, boardColumns: Int)(pieces: PieceStock): Long = {
    def notTakenBy(piece: Piece) = (cell: Piece#Cell) => !(piece controls cell)

    def countLayouts(openCells: Set[Piece#Cell], placedPieces: Layout, pieceStock: PieceStock): Long = pieceStock match {
      case Nil if placedPieces.isEmpty => 0L
      case Nil => 1L
      case pieceAt::stock =>
        var layoutNumber = 0L
        for {
          cell <- openCells
          currentPiece = pieceAt(cell) if placedPieces map (_.cell) forall notTakenBy(currentPiece)
        } layoutNumber += countLayouts((openCells - cell) filter notTakenBy(currentPiece),
                                       placedPieces + currentPiece, stock)

        layoutNumber
    }

    countLayouts((for(r <- 0 until boardRows; c <- 0 until boardColumns) yield (r,c)).toSet, Set.empty, pieces)
  }
}
