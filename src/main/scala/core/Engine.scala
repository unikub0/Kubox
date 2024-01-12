package id.unikub.kubox
package core

import services.EngineService

import org.lwjgl.glfw.GLFW

class Engine(window: Window, renderer: Renderer) extends EngineService:
  private final val UpdateTarget = 1/60.0
  private final val FrameTarget = 1/60.0

  override def init(): Unit =
    window.init()
    renderer.init()

  def loop(): Unit =
    var lastTime = GLFW.glfwGetTime
    var lag, currentTime, elapsedTime, frameTime, updateTime = .0
    var frames, updates = 0
    var render = true

    def timeProcess(): Unit =
      currentTime = GLFW.glfwGetTime()
      elapsedTime = currentTime - lastTime
      lastTime = currentTime
      lag += elapsedTime
      frameTime += elapsedTime
      updateTime += elapsedTime

    def calculateFPS() =
      if (frameTime >= 1)
        println(s"FPS : $frames")
        frames = 0
        frameTime -= 1

    def calculateUPS() =
      if (updateTime >= 1)
        println(s"UPS : $updates")
        updates = 0
        updateTime -= 1

    def sleep() =
      if (elapsedTime < FrameTarget) try
        Thread.sleep(((FrameTarget - elapsedTime) * 1000).toLong)
      catch
        case ie: InterruptedException =>
          ie.printStackTrace(System.err)
          Thread.currentThread.interrupt()

    while (!window.windowShouldClose)
      // get some elapsed times
      timeProcess()
      // TODO : input

      while (lag >= UpdateTarget)
        // TODO : update
        lag -= UpdateTarget
        updates += 1
        calculateUPS()

      if (render)
        // TODO : render
        frames += 1
        calculateFPS()
        renderer.render()
        render = false
        window.swap()
      else
        sleep()
        render = true

  override def dispose(): Unit =
    renderer.dispose()
    window.dispose()