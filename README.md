### About pawnless layout counter
 Pawnless layout counter counts all distinct layouts of a set of normal chess pieces on a chess board with given dimensions
 where none of the pieces is in a position to take any of the others. The colour of pieces does not matter and there are no
 pawns among the pieces. Also the counter treats pieces of the same kind as indistinguishable and does not count layouts that
 only differ in permutations of such pieces as distinct.

### Algorithm
 Starting with an empty board the counter yields a set of partial candidates for solutions by placing the next piece
 from the given set of pieces on the board at those cells where the piece does not attack the pieces already placed on the
 board and the latter do not attack the first. If it is possible the candidates are extended by adding such pieces, if not
 the algorithm backtracks.

### Running
 To build the project you should install [SBT](http://www.scala-sbt.org/). After you installed it type `sbt "run --help"` in the
 command line to see the synopsis of usage.