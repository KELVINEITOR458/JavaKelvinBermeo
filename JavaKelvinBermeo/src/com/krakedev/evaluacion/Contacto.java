package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos = new ArrayList<>();

	public Contacto(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	/*
	 * public void imprimir() { System.out.println("Cédula: " + cedula);
	 * System.out.println("Nombre: " + nombre); System.out.println("Apellido: " +
	 * apellido); System.out.println("Direccion: ");
	 * System.out.println(" Calle Principal: " + direccion.getCallePrincipal());
	 * System.out.println(" Calle Secundaria: " + direccion.getCalleSecundaria()); }
	 */

	public void imprimir() {
		if (this.direccion != null) {
			System.out.println("***" + nombre + " " + apellido + "***");
			System.out.println(
					"Direccion; " + " " + direccion.getCallePrincipal() + " y " + direccion.getCalleSecundaria());
		} else {
			System.out.println("***" + nombre + " " + apellido + "***" + " \nNo tiene asociada una direccion");
		}
	}

	public void agregarTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}

	public void mostrarTelefonos() {
		Telefono tipoTelefono;
		System.out.println("Telefonos con estado 'C'");
		for (int i = 0; i < telefonos.size(); i++) {
			tipoTelefono = telefonos.get(i);
			if (tipoTelefono.getEstado().equals("C")) {
				if (tipoTelefono.getTipo().equals("Movil")) {
					System.out.println("Numero:" + tipoTelefono.getNumero() + ", Tipo:" + tipoTelefono.getTipo());
				} else if (tipoTelefono.getTipo().equals("Convencional")) {
					System.out.println("Numero:" + tipoTelefono.getNumero() + ", Tipo:" + tipoTelefono.getTipo());
				}
			}
		}

	}

	public ArrayList<Telefono> recuperarIncorrectos() {
		ArrayList<Telefono> telefonosIncorrectos = new ArrayList<Telefono>();
		Telefono telefonosMalos;
		for (int i = 0; i < telefonos.size(); i++) {
			telefonosMalos = telefonos.get(i);
			if (telefonosMalos.getEstado().equals("E")) {
				telefonosIncorrectos.add(telefonosMalos);
			}
		}

		return telefonosIncorrectos;

	}
	
	public ArrayList<Telefono> recuperarCorrectos(){
		ArrayList<Telefono> telefonosCorrectos = new ArrayList<Telefono>();
		Telefono telefonosBuenos;
		for(int i=0; i<telefonos.size(); i++) {
			telefonosBuenos = telefonos.get(i);
			if(telefonosBuenos.getEstado().equals("C")) {
				telefonosCorrectos.addFirst(telefonosBuenos);
			}
		}
		return telefonosCorrectos;
	}
	
	
}


