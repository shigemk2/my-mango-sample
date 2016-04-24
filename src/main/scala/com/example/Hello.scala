package com.example

import java.util.concurrent.TimeUnit
import org.feijoas.mango.common.cache._

object Hello {
  def main(args: Array[String]): Unit = {
    val expensiveFnc = (str: String) => str.length
    val cache = CacheBuilder.newBuilder()
      .maximumSize(100)
      .expireAfterWrite(10, TimeUnit.MINUTES)
      .build(expensiveFnc)
    println(cache("MyString"))
    println(expensiveFnc("MyString"))
    println("Hello, world!")
  }
}
