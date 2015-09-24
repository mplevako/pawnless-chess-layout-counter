### About pawnless layout counter
 Pawnless layout counter counts all distinct layouts of a set of normal chess pieces on a chess board with given dimensions
 where none of the pieces is in a position to take any of the others. The colour of pieces does not matter and there are no
 pawns among the pieces. Also the counter treats pieces of the same kind as indistinguishable and does not count layouts that
 only differ in permutations of such pieces as distinct.

### Algorithm
 Arrangements are counted by placing the next piece from the given set of pieces on the board at those cells where the piece does not
 attack the pieces already placed on the board. Then all the cells controlled by that piece are removed from the set of
 tentative cells to be evaluated and the process recurses with the contracted set cells and pieces left in the stock until either
 all pieces are placed on the board (which is counted as +1) or the procedure finds there are leftovers that cannot be placed on
  the remaining part of the board (and the layout does not count). Afterwards the algorithm backtracks and tries another square and/or
  piece.

### Running
 To build the project you should install [SBT](http://www.scala-sbt.org/). Having installed it simply type `sbt "run --help"` in the
 command line to see the synopsis of usage.