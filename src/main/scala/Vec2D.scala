package bughware





class Vec2D(val x : Double, val y : Double):

	def length(that : Vec2D) : Double = Math.sqrt(Math.abs((that.x-x)*(that.x-x))+Math.abs((that.y-y)*(that.y-y)))
	//def *(that : Vec2D) : Vec2D = Vec2D(x * that.x, y * that.y)

	def lerp(that : Vec2D, dist : Double) : Vec2D = //(this*(1-dist))+(that*dist)
		this+((that-this) * dist)

	def -(that: Vec2D): Vec2D = Vec2D(x - that.x, y - that.y)
	def +(that: Vec2D): Vec2D = Vec2D(x + that.x, y + that.y)
	def *(scalar: Double): Vec2D = Vec2D(x * scalar, y * scalar)
	def /(scalar: Double): Vec2D = Vec2D(x / scalar, y / scalar)
	def ==(that: Vec2D): Boolean = x == that.x && y == that.y
	def toPos = Pos(x.toInt, y.toInt)
	def toLivePos = LivePos(x.toInt, y.toInt)


class Pos(val x : Int, val y : Int):
	def -(that : Pos) : Pos = Pos(x-that.x,y-that.y)
	def withErr(magnitude : Int): Pos = Pos(x+(Math.random()*magnitude).toInt,y+(Math.random()*magnitude).toInt)
	override def toString = s"X:$x | Y:$y"
class LivePos(val _x : Int, val _y : Int) extends Pos(_x, _y):
	override def -(that : Pos) = LivePos(x-that.x,y-that.y)
