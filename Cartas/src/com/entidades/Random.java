package com.entidades;

public class Random {
	public static int obtenerPosicion() {
		int random = (int) (Math.random() * 52);
		return random;
	}
}
