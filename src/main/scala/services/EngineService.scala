package id.unikub.kubox
package services

trait EngineService:
  def init(): Unit
  def dispose(): Unit