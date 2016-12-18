package edu.nju.nlp.mt

import java.io._
import java.util.concurrent.TimeUnit

import edu.nju.nlp.Sentence

import scala.io.Source

/**
  * Created by YWJ on 2016.12.16.
  * Copyright (c) 2016 NJU PASA Lab All rights reserved.
  */
object parser {
  def main(args: Array[String]) {
    if(args.size < 3) {
      System.exit(-1)
    }

    val inputFile =args(0)
    val pos = args(1)
    val head = args(2)

    val fos = new FileOutputStream(pos)
    val os : OutputStreamWriter = new OutputStreamWriter(fos, "UTF-8")
    val fos2 = new FileOutputStream(head)
    val os2 : OutputStreamWriter = new OutputStreamWriter(fos2, "UTF-8")

    val t1 = System.nanoTime()

    val data = Source.fromFile(new File(inputFile)).getLines().toArray

    val sp = data.splitAt(10)
      //.map(x => Sentence(x))
    data.foreach(elem => {
      val se = Sentence(elem)
      val posTags = se.pos
      val headIndex = se.stanfordDependencies
      val sp1 = new StringBuilder
      val sp2 = new StringBuilder
      sp1.append(posTags(0))
      for (i <- 1 until posTags.size)
        sp1.append(" ").append(posTags(i))
      os.write(sp1.toString() + "\n")
      os.flush()

      sp2.append(headIndex(0)._1)
      for (i <- 1 until headIndex.size)
        sp2.append(" ").append(headIndex(i)._1)
      os2.write(sp2.toString() + "\n")
      os2.flush()
    })

    os.close()
    os2.close()

    val t2 = System.nanoTime()
    println("Total cost " + TimeUnit.MILLISECONDS.convert(t2- t1, TimeUnit.NANOSECONDS)/1000.0 + " .s\n")

  }
}
