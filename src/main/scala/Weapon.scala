package bughware

/**
*    @author Gustaf Franzén, Elliot
*
*
*
*/

trait Weapon(val moves : Vector[Pos])

case class AssaultRifle(  sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, AssaultRifle.time,   AssaultRifle.viewAngle))

case class MP5(           sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, MP5.time,            MP5.viewAngle))

case class Thompson(      sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, Thompson.time,       Thompson.viewAngle))

case class CustomSmg(     sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, CustomSmg.time,      CustomSmg.viewAngle))

case class LR300(         sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, LR300.time,          LR300.viewAngle))

case class M249(          sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, M249.time,           M249.viewAngle))

case class M39Rifle(      sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, M39Rifle.time,       M39Rifle.viewAngle))

case class M92(           sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, M92.time,            M92.viewAngle))

case class PythonRevolver(sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, PythonRevolver.time, PythonRevolver.viewAngle))

case class Revolver(      sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, Revolver.time,       Revolver.viewAngle))

case class SemiAutoPistol(sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, SemiAutoPistol.time, SemiAutoPistol.viewAngle))

case class SemiAutoRifle( sens: Double, fov: Double)
	extends Weapon(Weapon.relativeMoves(sens, fov, SemiAutoRifle.time,  SemiAutoRifle.viewAngle))


object Weapon:
	/**
	*   Voodoo magic that generates all Integer onscrean positions to iterate
	*   @author Gustaf franzén
	*/
	def relativeMoves(sensitivity : Double, fov : Double, rpm: Int, viewAngles : Vector[Vec2D]) : Vector[Pos] =
		/**
		*    Generate on screen positions ie non relative moves
		*/
		val mult : Double = -0.03 * (sensitivity * 3.0) * (fov / 100.0)
		var res = new Array[Pos](viewAngles.length*rpm)
		var current = Vec2D(0.0,0.0)

		for i <- 0 until res.length by rpm do
			if i == 0 then
				current = current + viewAngles(i) / mult
				res(i) = current.toLivePos
				val lerpVec = (viewAngles(i) / mult) * (1.0/rpm.toDouble)
				for j <- 0 until rpm do
					current = current + lerpVec
					res(i+j) = current.toPos
			else
				current = current + (viewAngles((i/(rpm)).toInt) - viewAngles(((i-1)/(rpm)).toInt)) / mult
				res(i) = current.toLivePos
				val lerpVec = ((viewAngles((i/(rpm)).toInt) - viewAngles(((i-1)/(rpm)).toInt)) / mult) * (1.0/rpm.toDouble)
				for j <- 0 until rpm do
					current = current + lerpVec
					res(i+j) = current.toPos
			/**
			*    convert to relative moves by subtracting the one before it
			*/
		(for i <- res.length-1 to 0 by -1 yield
			if i != 0 then res(i) - res(i-1) else res(i)).toVector

	def getTimes(rpm : Int, viewAngles : Vector[Vec2D]) : Vector[Double] =
		val res = new Array[Double](viewAngles.length)
		res(viewAngles.length-1) = 0.0
		for i <- 0 until viewAngles.length-1 do
			val at = (viewAngles(i+1).length(viewAngles(i))/0.02)
			if rpm > at then
				res(i) = rpm - at
			else res(i) = at
		res.toVector


object AssaultRifle:
	val time = 133
	val viewAngle = Vector(
		Vec2D(1.390706,   -2.003941), Vec2D(1.1764340,   -3.844176), Vec2D(3.387171,  -5.516686), Vec2D(5.087049,  -7.017456),
		Vec2D(5.094189,   -8.342467), Vec2D(4.4260130,   -9.487704), Vec2D(3.250455,  -10.44915), Vec2D(1.73545,   -11.22279),
		Vec2D(0.04893398, -11.80460), Vec2D(-1.641158,   -12.19056), Vec2D(-3.166891, -12.58713), Vec2D(-4.360331, -13.32077),
		Vec2D(-5.053545,  -14.32128), Vec2D(-5.090651,   -15.51103), Vec2D(-4.489915, -16.81242), Vec2D(-3.382552, -18.14783),
		Vec2D(-1.899585,  -19.43966), Vec2D(-0.1720295,  -20.61031), Vec2D(1.669086,  -21.58213), Vec2D(3.492748,  -22.27755),
		Vec2D(5.16793,    -22.61893), Vec2D(6.563614,    -22.81778), Vec2D(7.548776,  -23.37389), Vec2D(7.992399,  -24.21139),
		Vec2D(7.512226,   -25.23734), Vec2D(6.063792,    -26.35886), Vec2D(4.117367,  -27.48302), Vec2D(2.143932,  -28.51692),
		Vec2D(0.6144824,  -29.36766))

object MP5:
	val time = 120
	val viewAngle = Vector(
		Vec2D(0,           -0.8688382), Vec2D(0,         -2.042219), Vec2D(0,          -3.370441), Vec2D(-0.5103882, -4.703804),
		Vec2D(-1.687297,   -5.8926060), Vec2D(-2.999344, -6.787148), Vec2D(-3.915147,  -7.311441), Vec2D(-3.948318,  -7.742482),
		Vec2D(-3.224567,   -8.1274060), Vec2D(-2.228431, -8.468721), Vec2D(-1.438722,  -8.768936), Vec2D(-1.288914,  -9.030560),
		Vec2D(-1.598686,   -9.2561000), Vec2D(-2.154637, -9.448063), Vec2D(-2.826861,  -9.608960), Vec2D(-3.485454,  -9.741299),
		Vec2D(-4.000507,   -9.8475860), Vec2D(-4.242117, -9.930332), Vec2D(-4.184897,  -9.992043), Vec2D(-3.969568,  -10.03523),
		Vec2D(-3.629241,   -10.062400), Vec2D(-3.194572, -10.07606), Vec2D(-2.696223,  -10.07872), Vec2D(-2.16485,   -10.07288),
		Vec2D(-1.631112,   -10.061060), Vec2D(-1.125667, -10.04577), Vec2D(-0.6791761, -10.02951), Vec2D(-0.3222946, -10.01479),
		Vec2D(-0.08568263, -10.004120))

object Thompson:
	val time = 130
	val viewAngle = Vector(
		Vec2D(0.7399524,  -1.565956), Vec2D(1.011324,   -3.109221), Vec2D(0.8437103,  -4.587918), Vec2D(0.3127854,  -5.960169),
		Vec2D(-0.3338249, -7.184096), Vec2D(-0.8446444, -8.217823), Vec2D(-0.9689822, -9.093672), Vec2D(-0.6067921, -9.877484),
		Vec2D(0.01632042, -10.57721), Vec2D(0.6324611,  -11.20081), Vec2D(0.9737339,  -11.75624), Vec2D(0.8438975,  -12.25145),
		Vec2D(0.3745165,  -12.69440), Vec2D(-0.2263549, -13.09305), Vec2D(-0.7514643, -13.45534), Vec2D(-0.9935587, -13.78924),
		Vec2D(-0.862007,  -14.10270), Vec2D(-0.5397906, -14.40368), Vec2D(-0.1962007, -14.70013))

object CustomSmg:
	val time = 100
	val viewAngle = Vector(
		Vec2D( 0.6512542, -1.305408), Vec2D( 0.9681615, -2.599905), Vec2D( 0.9872047, -3.859258), Vec2D( 0.6951124, -5.059230),
		Vec2D( 0.2062594, -6.175588), Vec2D(-0.3338249, -7.184096), Vec2D(-0.7796098, -8.060521), Vec2D(-0.9855663, -8.812342),
		Vec2D(-0.8372459, -9.496586), Vec2D(-0.4148501, -10.11968), Vec2D( 0.1267298, -10.68622), Vec2D( 0.6324611, -11.20081),
		Vec2D( 0.9473124, -11.66807), Vec2D( 0.9353167, -12.09258), Vec2D( 0.6385964, -12.47896), Vec2D( 0.1786009, -12.83181),
		Vec2D(-0.3247314, -13.15574), Vec2D(-0.7514643, -13.45534), Vec2D(-0.9816588, -13.73522), Vec2D(-0.9354943, -13.99999),
		Vec2D(-0.7141180, -14.25425), Vec2D(-0.4193012, -14.50260), Vec2D(-0.1487077, -14.74965))

object LR300:
	val time = 120
	val viewAngle = Vector(
		Vec2D(0.09836517, -1.004928), Vec2D(0.3469534,  -2.248523), Vec2D(0.7512205, -3.575346), Vec2D(1.326888,  -4.829963),
		Vec2D(1.958069,   -5.858609), Vec2D(2.527623,   -6.687347), Vec2D(2.918412,  -7.399671), Vec2D(3.007762,  -8.005643),
		Vec2D(2.641919,   -8.515327), Vec2D(1.950645,   -8.938788), Vec2D(1.144313,  -9.286088), Vec2D(0.4332969, -9.567291),
		Vec2D(0.02797037, -9.793953), Vec2D(0.04550591, -9.992137), Vec2D(0.2685102, -10.17017), Vec2D(0.6408804, -10.33037),
		Vec2D(1.127565,   -10.47505), Vec2D(1.693516,   -10.60654), Vec2D(2.303682,  -10.72716), Vec2D(2.923013,  -10.83923),
		Vec2D(3.516459,   -10.94506), Vec2D(4.04897,    -11.04699), Vec2D(4.485496,  -11.14732), Vec2D(4.790986,  -11.24838),
		Vec2D(4.92656,    -11.35249), Vec2D(4.387823,   -11.46197), Vec2D(3.16274,   -11.57914), Vec2D(1.714368,  -11.70632),
		Vec2D(0.5057687,  -11.84584))

object M249:
	val time = 120
	val viewAngle = Vector(
		Vec2D(0.0, -2.7500), Vec2D(0.0, -5.5000), Vec2D(0.0, -8.2500), Vec2D(0.0, -11.000), Vec2D(0.0, -13.750), Vec2D(0.0, -16.500), Vec2D(0.0, -19.250),
		Vec2D(0.0, -22.000), Vec2D(0.0, -24.750), Vec2D(0.0, -27.500), Vec2D(0.0, -30.250), Vec2D(0.0, -33.000), Vec2D(0.0, -35.750), Vec2D(0.0, -38.500),
		Vec2D(0.0, -41.250), Vec2D(0.0, -44.000), Vec2D(0.0, -46.750), Vec2D(0.0, -49.500), Vec2D(0.0, -52.250), Vec2D(0.0, -55.000), Vec2D(0.0, -57.750),
		Vec2D(0.0, -60.500), Vec2D(0.0, -63.250), Vec2D(0.0, -66.000), Vec2D(0.0, -68.750), Vec2D(0.0, -71.500), Vec2D(0.0, -74.250), Vec2D(0.0, -77.000),
		Vec2D(0.0, -79.750), Vec2D(0.0, -82.500), Vec2D(0.0, -85.250), Vec2D(0.0, -88.000), Vec2D(0.0, -90.750), Vec2D(0.0, -93.500), Vec2D(0.0, -96.250),
		Vec2D(0.0, -99.000), Vec2D(0.0, -101.75), Vec2D(0.0, -104.50), Vec2D(0.0, -107.25), Vec2D(0.0, -110.00), Vec2D(0.0, -112.75), Vec2D(0.0, -115.50),
		Vec2D(0.0, -118.25), Vec2D(0.0, -121.00), Vec2D(0.0, -123.75), Vec2D(0.0, -126.50), Vec2D(0.0, -129.25), Vec2D(0.0, -132.00), Vec2D(0.0, -134.75),
		Vec2D(0.0, -137.50), Vec2D(0.0, -140.25), Vec2D(0.0, -143.00), Vec2D(0.0, -145.75), Vec2D(0.0, -148.50), Vec2D(0.0, -151.25), Vec2D(0.0, -154.00),
		Vec2D(0.0, -156.75), Vec2D(0.0, -159.50), Vec2D(0.0, -162.25), Vec2D(0.0, -165.00), Vec2D(0.0, -167.75), Vec2D(0.0, -170.50), Vec2D(0.0, -173.25),
		Vec2D(0.0, -176.00), Vec2D(0.0, -178.75), Vec2D(0.0, -181.50), Vec2D(0.0, -184.25), Vec2D(0.0, -187.00), Vec2D(0.0, -189.75), Vec2D(0.0, -192.50),
		Vec2D(0.0, -195.25), Vec2D(0.0, -198.00), Vec2D(0.0, -200.75), Vec2D(0.0, -203.50), Vec2D(0.0, -206.25), Vec2D(0.0, -209.00), Vec2D(0.0, -211.75),
		Vec2D(0.0, -214.50), Vec2D(0.0, -217.25), Vec2D(0.0, -220.00), Vec2D(0.0, -222.75), Vec2D(0.0, -225.50), Vec2D(0.0, -228.25), Vec2D(0.0, -231.00),
		Vec2D(0.0, -233.75), Vec2D(0.0, -236.50), Vec2D(0.0, -239.25), Vec2D(0.0, -242.00), Vec2D(0.0, -244.75), Vec2D(0.0, -247.50), Vec2D(0.0, -250.25),
		Vec2D(0.0, -253.00), Vec2D(0.0, -255.75), Vec2D(0.0, -258.50), Vec2D(0.0, -261.25), Vec2D(0.0, -264.00), Vec2D(0.0, -266.75), Vec2D(0.0, -269.50),
		Vec2D(0.0, -272.25), Vec2D(0.0, -275.00), Vec2D(0.0, -277.75))

object M39Rifle:
	val time = 133
	val viewAngle = Vector(
		Vec2D(0.0, -3.50), Vec2D(0.0, -7.00), Vec2D(0.0, -10.5), Vec2D(0.0, -14.0), Vec2D(0.0, -17.5), Vec2D(0.0, -21.0),
		Vec2D(0.0, -24.5), Vec2D(0.0, -28.0), Vec2D(0.0, -31.5), Vec2D(0.0, -35.0), Vec2D(0.0, -38.5), Vec2D(0.0, -42.0),
		Vec2D(0.0, -45.5), Vec2D(0.0, -49.0), Vec2D(0.0, -52.5), Vec2D(0.0, -56.0))

object M92:
	val time = 133
	val viewAngle = Vector(
		Vec2D(0, -3.750), Vec2D(0, -7.50), Vec2D(0, -11.25), Vec2D(0, -15.0), Vec2D(0, -18.75), Vec2D(0, -22.5),
		Vec2D(0, -26.25), Vec2D(0, -30.0), Vec2D(0, -33.75), Vec2D(0, -37.5), Vec2D(0, -41.25), Vec2D(0, -45.0),
		Vec2D(0, -48.75), Vec2D(0, -52.5), Vec2D(0, -56.25), Vec2D(0, -60.0))

object PythonRevolver:
	val time = 133
	val viewAngle = Vector(
		Vec2D(0.0, -8.00), Vec2D(0.0, -16.0), Vec2D(0.0, -24.0), Vec2D(0.0, -32.0),
		Vec2D(0.0, -40.0), Vec2D(0.0, -48.0), Vec2D(0.0, -56.0))

object Revolver:
	val time = 133
	val viewAngle = Vector(
		Vec2D(0.0, -2.50), Vec2D(0.0, -5.00), Vec2D(0.0, -7.50), Vec2D(0.0, -10.0), Vec2D(0.0, -12.5),
		Vec2D(0.0, -15.0), Vec2D(0.0, -17.5), Vec2D(0.0, -20.0), Vec2D(0.0, -22.5))

object SemiAutoPistol:
	val time = 133
	val viewAngle = Vector(
		Vec2D(0.0, -4.00), Vec2D(0.0, -8.00), Vec2D(0.0, -12.0), Vec2D(0.0, -16.0), Vec2D(0.0, -20.0),
		Vec2D(0.0, -24.0), Vec2D(0.0, -28.0), Vec2D(0.0, -32.0), Vec2D(0.0, -36.0), Vec2D(0.0, -40.0),
		Vec2D(0.0, -44.0))

object SemiAutoRifle:
	val time = 133
	val viewAngle = Vector(
		Vec2D(0.0, -3.250), Vec2D(0.0, -6.500), Vec2D(0.0, -9.750), Vec2D(0.0, -13.00), Vec2D(0.0, -16.25),
		Vec2D(0.0, -19.50), Vec2D(0.0, -22.75), Vec2D(0.0, -26.00), Vec2D(0.0, -29.25), Vec2D(0.0, -32.50),
		Vec2D(0.0, -35.75), Vec2D(0.0, -39.00), Vec2D(0.0, -42.25), Vec2D(0.0, -45.50), Vec2D(0.0, -48.75),
		Vec2D(0.0, -52.00))
