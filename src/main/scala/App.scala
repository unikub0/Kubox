package id.unikub.kubox

import core.{Engine, Window, Renderer}
import core.GL.GLRenderer
import services.EngineService

abstract class App(val engine: Engine = Engine(
  Window(800, 600, "Kubox v1"),
  GLRenderer(),
)):
  def start(): Unit