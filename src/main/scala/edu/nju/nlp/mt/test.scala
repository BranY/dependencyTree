package edu.nju.nlp.mt

import java.io.File
import java.util

import edu.nju.nlp.Sentence

import scala.io.Source

/**
  * Created by YWJ on 2016.12.16.
  * Copyright (c) 2016 NJU PASA Lab All rights reserved.
  */
object test {
  def main(args: Array[String]) {
    val data = Source.fromFile(new File("data/test_en.txt")).getLines().toArray
      //.map(x => Sentence(x))
    val list :util.LinkedList[Array[String]] = new util.LinkedList[Array[String]]

//    val parser = data.map(x => x.pos)
//
//    for (elem <- parser) {
//      for (pos <-elem)
//        print(pos + " ")
//      println()
//    }
//
//    val head = data.map(x => x.stanfordDependencies)
//    for (elem <- head) {
//      for (e <- elem) {
//        print(e._1 + " ")
//      }
//      println()
//    }
  }
}
