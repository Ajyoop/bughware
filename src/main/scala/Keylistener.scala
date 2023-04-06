package bughware

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

class GlobalKeyListener(recoilScript: Bughware) extends NativeKeyListener:
	override def nativeKeyPressed(e: NativeKeyEvent):  Unit = recoilScript.keyPressed(e)
	override def nativeKeyReleased(e: NativeKeyEvent): Unit = recoilScript.keyReleased(e)
	override def nativeKeyTyped(e: NativeKeyEvent):    Unit = print("")
class GlobalMouseListener(recoilScript: Bughware) extends NativeMouseInputListener:
	override def nativeMousePressed(e: NativeMouseEvent):  Unit = recoilScript.mousePressed(e)
	override def nativeMouseReleased(e: NativeMouseEvent): Unit = recoilScript.mouseReleased(e)
	override def nativeMouseMoved(e: NativeMouseEvent):    Unit = ()
	override def nativeMouseDragged(e: NativeMouseEvent):  Unit = ()
	override def nativeMouseClicked(e: NativeMouseEvent):  Unit = ()
