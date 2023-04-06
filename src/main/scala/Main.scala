package bughware

import java.awt.Robot
import java.awt.MouseInfo;
import bughware._
import java.util.logging.Logger
import java.util.logging.Level
import scala.collection.mutable.ArrayBuffer
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea



/*
val akViewAngles = Vector((1.390706, -2.003941), (1.176434, -3.844176), (3.387171, -5.516686), (5.087049, -7.017456), (5.094189, -8.342467), (4.426013, -9.487704), (3.250455, -10.44915), (1.73545, -11.22279), (0.04893398, -11.8046), (-1.641158, -12.19056), (-3.166891, -12.58713), (-4.360331, -13.32077), (-5.053545, -14.32128), (-5.090651, -15.51103), (-4.489915, -16.81242), (-3.382552, -18.14783), (-1.899585, -19.43966), (-0.1720295, -20.61031), (1.669086, -21.58213), (3.492748, -22.27755), (5.16793, -22.61893), (6.563614, -22.81778), (7.548776, -23.37389), (7.992399, -24.21139), (7.512226, -25.23734), (6.063792, -26.35886), (4.117367, -27.48302), (2.143932, -28.51692), (0.6144824, -29.36766))

val sensitivity = 1
val fov = 90

val xpixlar = for i <- 0 until xdelta.length yield (xdelta(i) / mult).toInt
val ypixlar = for i <- 0 until ydelta.length yield (ydelta(i) / mult).toInt

val xdelta = for i <- 0 until akViewAngles.length-1 yield akViewAngles(i)._1 - akViewAngles(i+1)._1
val ydelta = for i <- 0 until akViewAngles.length-1 yield akViewAngles(i)._2 - akViewAngles(i+1)._2
val mult: Double = 0.03*(sensitivity*3.0) * (fov / 100.0)
*/

@main def main: Unit =
	val okej = Bughware(0.17, 90)
