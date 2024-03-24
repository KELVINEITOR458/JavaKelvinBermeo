package com.entidades;

import java.util.ArrayList;

import com.servicios.Juego;

public class Jugadores {
	private ArrayList<String> jugadores;

	public ArrayList<String> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<String> jugadores) {
		this.jugadores = jugadores;
	}

	public void jugar() {
		ArrayList<String> jugadores = new ArrayList<>();
		jugadores.add("Jugador 1");
		jugadores.add("Jugador 2");
		jugadores.add("Jugador 3");

		Juego juego = new Juego(jugadores);
		juego.entregarCartas(5);

		for (int i = 0; i < jugadores.size(); i++) {
			ArrayList<Carta> cartasJugador = juego.getCartasJugadores().get(i);
            int total = 0;
            for (int j=0;j<cartasJugador.size();i++) {
                total += 1;
            }
            System.out.println("Jugador " + jugadores.get(i) + " - Total: " + total);
        }
	}
	
	
}
