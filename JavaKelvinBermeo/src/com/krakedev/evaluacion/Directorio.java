package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos = new ArrayList<>();
	private Date fechaModificacion;
	private ArrayList<Contacto> incorrectos = new ArrayList<>();
	private ArrayList<Contacto> correctos = new ArrayList<>();
	
	public Directorio() {
		this.contactos = new ArrayList<>();
		this.fechaModificacion = new Date();
	}
	
	
	
	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}



	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}



	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}



	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}
	
	



	public ArrayList<Contacto> getContactos() {
		return contactos;
	}



	public boolean agregarContacto(Contacto contacto) {
		boolean contactoAgregado = false;
		Contacto contactoEncontrado = buscarPorCedula(contacto.getCedula());
		if(contactoEncontrado == null) {
			contactos.add(contacto);
			this.fechaModificacion = new Date();
			contactoAgregado = true;
		}else {
			contactoAgregado = false;
		}
		return contactoAgregado;
	}
	
	public Contacto buscarPorCedula(String cedula) {
		Contacto contactoRecuperado;
		Contacto contactoEncontrado = null;
		String cedulaEncontrar;
		for(int i=0; i<contactos.size();i++) {
			contactoRecuperado = contactos.get(i);
			cedulaEncontrar = contactoRecuperado.getCedula();
			if(cedulaEncontrar.equals(cedula)) {
				contactoEncontrado = contactoRecuperado;
			}
		}
		return contactoEncontrado;
	}
	
	public String consultarUltimaModificacion() {
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formateador.format(fechaModificacion);
	}
	
	public int contarPerdidos() {
		int perdidos = 0;
		Contacto contacto;
		for(int i=0; i<contactos.size(); i++) {
			contacto = contactos.get(i);
			if(contacto.getDireccion() == null) {
				perdidos += 1;
			}
		}
		return perdidos;
	}
	
	public int contarFijos() {
		int contactosFijos = 0;
		Contacto contactoRecuperado;
		for(int i=0; i<contactos.size(); i++) {
			contactoRecuperado = contactos.get(i);
			Telefono telefono;
			for(int a=0; a<contactoRecuperado.getTelefonos().size(); a++) {
				telefono = contactoRecuperado.getTelefonos().get(a);
				if(telefono.getEstado().equals("C") && telefono.getTipo().equals("Convencional")) {
					contactosFijos += 1;
				}
			}
				
			
		}
		
		return contactosFijos;
	}
	
	public void depurar() {
		Contacto contactoss;
		Direccion direccion;
		
		for(int i=0; i<contactos.size(); i++) {
			contactoss = contactos.get(i);
			direccion = contactoss.getDireccion();
			if(direccion == null) {
				incorrectos.add(contactoss);
			}else {
				correctos.add(contactoss);
			}
		}
		contactos.clear();
	}
}
