package id.unikub.kubox
package core

import services.EngineService
import org.lwjgl.glfw.Callbacks.glfwFreeCallbacks
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.system.MemoryUtil.NULL

class Window(private var _width: Int, private var _height: Int, var title: String) extends EngineService:
  private var _handler = 0L

  def windowShouldClose: Boolean = glfwWindowShouldClose(_handler)

  override def init(): Unit =
    GLFWErrorCallback.createPrint(System.err).set
    if (!glfwInit)
      throw new IllegalStateException("Unable to init GLFW.")
    _handler = glfwCreateWindow(_width, _height, title, NULL, NULL)
    if (_handler == NULL) throw RuntimeException("Failed to create window.")
    glfwMakeContextCurrent(_handler)
    //glfwSwapInterval(1)
    glfwShowWindow(_handler)

  def swap(): Unit =
    glfwSwapBuffers(_handler)
    glfwPollEvents()

  override def dispose(): Unit =
    // Free the window callbacks and destroy the window// Free the window callbacks and destroy the window
    glfwFreeCallbacks(_handler)
    glfwDestroyWindow(_handler)
    // Terminate GLFW and free the error callback
    glfwTerminate()
    glfwSetErrorCallback(null).free()