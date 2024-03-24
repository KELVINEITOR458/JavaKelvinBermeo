package com.cmc.evaluacion;

public class Cuota {
	private int numero;
	private double cuota;
	private double capitalInicio;
	private double interes;
	private double abonoCapital;
	private double saldo;

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getCapitalInicio() {
		return capitalInicio;
	}

	public void setCapitalInicio(double capitalInicio) {
		this.capitalInicio = capitalInicio;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getAbonoCapital() {
		return abonoCapital;
	}

	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cuota(int numero) {
		this.numero = numero;
	}

	public void mostrarPrestamo() {
		Utilitario cuotaRe = new Utilitario();
		Utilitario capitalInicioRe = new Utilitario();
		Utilitario interesRe = new Utilitario();
		Utilitario abonoCapitalRe = new Utilitario();
		Utilitario saldoRe = new Utilitario();
		cuota = cuotaRe.redondear(cuota);
		capitalInicio = capitalInicioRe.redondear(capitalInicio);
		interes = interesRe.redondear(interes);
		abonoCapital = abonoCapitalRe.redondear(abonoCapital);
		saldo = saldoRe.redondear(saldo);

		System.out.println(numero + " | " + cuota + " | " + capitalInicio + " | " + interes + " | "
		+ abonoCapital + " | " + saldo);
	}

}
