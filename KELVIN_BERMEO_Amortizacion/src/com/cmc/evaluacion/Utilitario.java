package com.cmc.evaluacion;

public class Utilitario {
	public double redondear(double valor) {
		valor = Math.round(valor*100.0)/100.0;
		return valor;
	}
}
