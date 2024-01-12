package id.unikub.kubox
package core

object Time:
  private[core] var _dt = 0.0

  def dt: Double = _dt