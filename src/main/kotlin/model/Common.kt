package com.eksar.model

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import model.UserModelJava

fun UserModel.hideSpecialInfo() {
  this.specialInfo = "[PROTECTED]"
}

fun UserModelJava.hideSpecialInfo() {
  this.specialInfo = "[PROTECTED]"
}

fun CoroutinesExample() = runBlocking {
  val job = GlobalScope.launch {
    // launch a new coroutine and keep a reference to its Job
    delay(1000L)
    println("World!")
  }
  println("Hello,")
  job.join()
}