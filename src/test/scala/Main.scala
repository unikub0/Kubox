package id.unikub.kubox

import org.scalatest.funsuite.AnyFunSuite

class Main extends AnyFunSuite:
  test("Window"){
    val myApp = new App:
      override def start(): Unit =
        engine.init()
        engine.loop()
        engine.dispose()
    myApp.start()
  }