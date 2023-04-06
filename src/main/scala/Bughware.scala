package bughware

import java.awt.Robot
import java.awt.MouseInfo;
import bughware._


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

import java.util.logging.Logger
import java.util.logging.Level
import scala.collection.mutable.ArrayBuffer




class Bughware(sens: Double, fov: Int):


	val antonaro = Robot()
	var mButton1 = false
	var mButton2 = false
	var gun = new AssaultRifle(sens, fov)
	val keyListener = GlobalKeyListener(this)
	val mouseListener = GlobalMouseListener(this)
	for p <- gun.moves do println(p.toString)

	GlobalScreen.addNativeKeyListener(keyListener)
	GlobalScreen.addNativeMouseListener(mouseListener)
	GlobalScreen.registerNativeHook()

	val rH = RecoilHandler(antonaro, gun)(using this)


	def keyPressed(e: NativeKeyEvent): Unit = ()

	def keyReleased(e: NativeKeyEvent): Unit = ()



	def mousePressed(e: NativeMouseEvent): Unit = e.getButton match
		case NativeMouseEvent.BUTTON1 => {mButton1 = true; println("testOn")}
		case NativeMouseEvent.BUTTON2 => {mButton2 = true; println("testOn")}
		case _ => ()

	def mouseReleased(e: NativeMouseEvent): Unit = e.getButton match
		case NativeMouseEvent.BUTTON1 => {mButton1 = false; println("testOf")}
		case NativeMouseEvent.BUTTON2 => {mButton2 = false; println("testOf")}
		case _ => ()
