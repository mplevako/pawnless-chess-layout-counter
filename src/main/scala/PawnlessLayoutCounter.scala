import layout.LayoutCounter
import pieces._

case class PawnlessLayoutCounterOptions(rows: Int = 8, cols: Int = 8,
                                        bishops: Int = 0, kings: Int = 0, knights: Int = 0, queens: Int = 0, rooks: Int = 0)

object PawnlessLayoutCounter extends LayoutCounter {

  def main(args: Array[String]): Unit = {
    val parser = new scopt.OptionParser[PawnlessLayoutCounterOptions]("Pawnless Layout Counter") {
      head("PawnlessLayoutCounter")

      opt[Int]('M', "rows") action { (M, opts) => opts.copy(rows = M) } text "the number of rows (8 by default)"
      opt[Int]('N', "cols") action { (N, opts) => opts.copy(cols = N) } text "the number of columns (8 by default)"

      opt[Int]('B', "bishops") action { (B, opts) => opts.copy(bishops = B) } text "the number of bishops"
      opt[Int]('K', "kings")   action { (K, opts) => opts.copy(kings = K) } text "the number of kings"
      opt[Int]('Q', "queens") action { (Q, opts) => opts.copy(queens = Q) } text "the number of queens"
      opt[Int]('R', "rooks")  action { (R, opts) => opts.copy(rooks = R) } text "the number of rooks"
      opt[Int]("knights") abbr "Kt" action { (Kt, opts) => opts.copy(knights = Kt) } text "the number of knights"

      help("help") text "prints this synopsis"
    }

    parser.parse(args, PawnlessLayoutCounterOptions()) foreach { opts =>
      val pieceStock = Seq.fill(opts.bishops)(Bishop) ++ Seq.fill(opts.kings)(King) ++ Seq.fill(opts.knights)(Knight) ++
                       Seq.fill(opts.queens)(Queen)   ++ Seq.fill(opts.rooks)(Rook)
      print(s"The number of distinct layouts is: ${countLayouts(opts.rows, opts.cols)(pieceStock)}")
    }
  }
}
