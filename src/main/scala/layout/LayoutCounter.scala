package layout

import pieces.Piece

trait LayoutCounter {

  type Layout = Set[Piece]
  type PieceStock = Seq[Piece#Cell => Piece]

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
