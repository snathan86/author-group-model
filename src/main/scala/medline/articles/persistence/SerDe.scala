package medline.articles.persistence

import java.io._

/**
  * Created by senthil on 18/04/17.
  * Serialize or deserialize object
  */
object SerDe {

  /**
    * Persist given object into the file provided as file
    * @param file : file with full path to persist object
    * @param obj : object to be persisted
    */
  def serialize(file : String, obj : Serializable): Unit = {
    try {
      val fos = new FileOutputStream(file)
      val oos = new ObjectOutputStream(fos)
      oos.writeObject(obj)
      oos.close()
    } catch {
      case ioe : FileNotFoundException => { println(s"IOException while persisting result ${ioe.getMessage}"); throw ioe }
      case fnf : IOException => { println(s"File ${file}  Not Found  ${fnf.getMessage}"); throw fnf }
    }
  }

  /**
    * Deserialize object from given file
    * @param file : file with full path to read object from
    * @return : read object
    */
  def deSerialize(file : String ): AnyRef = {
    try {
      val fis = new FileInputStream(file)
      val ois = new ObjectInputStream(fis)

      val result = ois.readObject
      ois.close()
      result
    } catch {
      case ioe : FileNotFoundException => { println(s"IOException while persisting result ${ioe.getMessage}"); throw ioe }
      case fnf : IOException => { println(s"File ${file}  Not Found  ${fnf.getMessage}"); throw fnf }
    }

  }

}
