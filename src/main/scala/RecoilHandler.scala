
package bughware
import java.awt.{Robot, MouseInfo}

class RecoilHandler(antonaro: Robot, gun: Weapon)(using ctx: Bughware) extends Runnable:
	var t = new Thread(this)
	t.start()


	def run: Unit =
		var i = 0
		var a = true
		while a do
			if ctx.mButton1 then println("b1")
			if ctx.mButton1 && ctx.mButton2 && i < gun.moves.length then
				gun.moves(i) match
					case p : LivePos => relativeMove(p)
					case p : Pos     => relativeMove(p.withErr(1))
				delay(1)
				print("testttt")
				i += 1
			else i = 0

	/**
	*    accuracy:
	*    avrage ~0.012 on short delays (esimate)
	*    High   ~0.1
	*    @author Gustaf Franzén
	*/
	def delay(time: Long) =
		var t0 = System.currentTimeMillis
		while System.currentTimeMillis-t0 < time do ()


	def relativeMove(p: Pos): Unit =
		var mouseX = MouseInfo.getPointerInfo().getLocation().getX().toInt
		var mouseY = MouseInfo.getPointerInfo().getLocation().getY().toInt
		if p.x != mouseX && p.y != mouseY then
			antonaro.mouseMove(mouseX + p.x, mouseY + p.y)
