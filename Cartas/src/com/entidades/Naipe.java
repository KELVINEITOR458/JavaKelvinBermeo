package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles = new ArrayList<>();
	private ArrayList<Carta> cartas = new ArrayList<>();
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	public Naipe() {
		numerosPosibles.add(new Numero("A", 11));
		numerosPosibles.add(new Numero("2", 2));
		numerosPosibles.add(new Numero("3", 3));
		numerosPosibles.add(new Numero("4", 4));
		numerosPosibles.add(new Numero("5", 5));
		numerosPosibles.add(new Numero("6", 6));
		numerosPosibles.add(new Numero("7", 7));
		numerosPosibles.add(new Numero("8", 8));
		numerosPosibles.add(new Numero("9", 9));
		numerosPosibles.add(new Numero("10", 10));
		numerosPosibles.add(new Numero("J", 10));
		numerosPosibles.add(new Numero("Q", 10));
		numerosPosibles.add(new Numero("K", 10));
		
		ArrayList<String> palos = new ArrayList<>();
		palos.add("CR");
        palos.add("CN");
        palos.add("DI");
        palos.add("TR");
        
        Numero numero;
        for(int  i=0; i<numerosPosibles.size(); i++) {
        	numero = numerosPosibles.get(i);
        	String palo;
        	for(int a=0; a<palos.size();a++) {
        		palo = palos.get(i);
        		cartas.add(new Carta(numero, palo));
        	}
        }
	}
	
	public ArrayList<Carta> barajar() {
		ArrayList<Carta> auxiliar = new ArrayList<>();
		Carta carta;
		for(int i=1; i<100; i++) {
			int posicion = Random.obtenerPosicion();
			carta = cartas.get(posicion);
			if(carta.getEstado() != null) {
				if(carta.getEstado().equals("N")) {
					auxiliar.add(carta);
					carta.setEstado("C");
				}
			}
		}
		
		Carta restantes;
		for(int i=0; i<auxiliar.size(); i++) {
			restantes = auxiliar.get(i);
			if(restantes.getEstado().equals("N")) {
				auxiliar.add(restantes);
			}
		}
		
		return auxiliar;
	}
	
	
}
