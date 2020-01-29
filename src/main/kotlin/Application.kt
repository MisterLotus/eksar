package com.eksar

import com.eksar.model.CoroutinesExample
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Application {
  //init block here we can start all we need or handle incoming args

  init {
    //System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");

    System.out.println("Start system")
    //CoroutinesExample()
  }
}

//must have static function for main,
// class can't be static so best solution move function at package level
fun main(args: Array<String>) {
  val app = SpringApplication(Application::class.java)
  app.run(*args)
}


