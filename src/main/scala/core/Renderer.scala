package id.unikub.kubox
package core

import id.unikub.kubox.services.EngineService

abstract class Renderer extends EngineService:
  def render(): Unit
  def clear(): Unit