package com.cmc.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.Cuota;
import com.cmc.evaluacion.Prestamo;

public class CalculadoraAmortizacion {
	public static double calcularCuota(Prestamo prestamo) {
		double cuota = 0.0;
		cuota = (prestamo.getMonto() * ((prestamo.getInteres()/12)/100))
				/ (1-Math.pow((1+((prestamo.getInteres()/12)/100)), prestamo.getPlazo() * -1));
		return cuota;
	}
	
	public static void generarTabla(Prestamo prestamo) {
		double cuotaCambiante = calcularCuota(prestamo);
		ArrayList<Cuota> cuotas = prestamo.getCuotas();
		for (int i = 1; i <= prestamo.getPlazo(); i++) {
			Cuota cuota = new Cuota(i);
			cuota.setCuota(cuotaCambiante);
			cuotas.add(cuota);
		}
		Cuota primeraCuota = cuotas.get(0);
		primeraCuota.setCapitalInicio(prestamo.getMonto());
		
		for(int i=0; i<cuotas.size(); i++) {
			Cuota cuotaNueva;
			cuotaNueva= cuotas.get(i);
			int cuotaSiguiente = cuotas.indexOf(cuotaNueva)+1;
			if(cuotaSiguiente < cuotas.size()) {
				calcularValoresCuota(prestamo.getInteres(), cuotaNueva, cuotas.get(cuotaSiguiente));
			}else {
				calcularValoresCuota(prestamo.getInteres(), cuotaNueva, null);
			}
		}
		
	}
	
	public static void calcularValoresCuota(double interes, Cuota cuota, Cuota sigCuota) {
		double valorInteres;
		valorInteres = ((interes/100)/12)* cuota.getCapitalInicio();
		double abonoCapital;
		abonoCapital = cuota.getCuota() - valorInteres;
		double saldo;
		saldo = cuota.getCapitalInicio() - abonoCapital;
		
		cuota.setInteres(valorInteres);
		cuota.setAbonoCapital(abonoCapital);
		cuota.setSaldo(saldo);
		
		if(sigCuota != null) {
			sigCuota.setCapitalInicio(saldo);
		}else {
			cuota.setCuota(cuota.getCuota() + saldo);
			cuota.setAbonoCapital(cuota.getCuota() - valorInteres);
			cuota.setSaldo(0);
		}
		
	}
	
	public static void mostrarTabla(Prestamo prestamo) {
		ArrayList <Cuota> mostrarCuotas = prestamo.getCuotas();
		Cuota cuotaPorMostrar;
		System.out.println("Numero | Cuota | Inicio | Interes | Abono | Saldo");
		for(int i=0; i<mostrarCuotas.size(); i++) {
			cuotaPorMostrar = mostrarCuotas.get(i);
			cuotaPorMostrar.mostrarPrestamo();
		}
	}
}
