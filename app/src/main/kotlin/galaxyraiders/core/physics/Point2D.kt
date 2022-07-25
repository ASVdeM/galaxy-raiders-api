package galaxyraiders.core.physics
import java.lang.Math

data class Point2D (val x: Double, val y: Double) {
  //x e y são as coordenadas no plano cartesiano
  //private val initialx = x
  //private val initialy = y

  operator fun plus (p: Point2D): Point2D {
    return Point2D (x + p.x, y + p.y)
  }

  operator fun plus (v: Vector2D): Point2D {
    return Point2D (x + v.dx, y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D (x, y)
    //eu acredito que isso seja um vetor com uma ponta na origem e outra no ponto
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D (Math.abs (x - p.x), Math.abs (y - p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    return impactVector (p).unit
  }

  fun contactVector(p: Point2D): Vector2D {
    return impactVector (p).normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    return contactVector (p).unit
  }

  fun distance(p: Point2D): Double {
    return Math.hypot (x - p.x, y - p.y)
  }
}
