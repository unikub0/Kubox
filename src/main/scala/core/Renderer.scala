package id.unikub.kubox
package core

import services.EngineService

abstract class Renderer extends EngineService:
  def render(): Unit
  def clear(): Unit