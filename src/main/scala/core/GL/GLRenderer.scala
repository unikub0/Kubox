package id.unikub.kubox
package core.GL

import id.unikub.kubox.core.Renderer
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*

class GLRenderer extends Renderer:
  override def init(): Unit =
    GL.createCapabilities
    glClearColor(0, 0, 0, 1)

  override def clear(): Unit =
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

  override def render(): Unit = {}

  override def dispose(): Unit = {}
