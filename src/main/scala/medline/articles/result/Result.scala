package medline.articles.result

/**
  * Created by svijayaraja on 18/04/17.
  */

@SerialVersionUID(21L)
case class Result(matrix : Array[Array[Int]]) extends Serializable
@SerialVersionUID(20L)
case class DistinctAuthors(authors : List[String]) extends Serializable
