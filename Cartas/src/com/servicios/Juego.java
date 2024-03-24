package com.servicios;

import java.util.ArrayList;
import com.entidades.Carta;
import com.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<ArrayList<Carta>> cartasJugadores;
	private ArrayList<Carta> naipeBarajado;

	public Juego() {
		this.naipe = new Naipe();
		this.naipeBarajado = naipe.barajar();
	}

	public Juego(ArrayList<String> idsJugadores) {
		this.naipe = new Naipe();
		this.naipeBarajado = naipe.barajar();
		cartasJugadores = new ArrayList<ArrayList<Carta>>();
		for (int i = 0; i < idsJugadores.size(); i++) {
			ArrayList<Carta> cartasJugador = new ArrayList<Carta>();
			cartasJugadores.add(cartasJugador);
		}
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public ArrayList<ArrayList<Carta>> getCartasJugadores() {
		return cartasJugadores;
	}

	public void entregarCartas(int cartasPorJugador) {
		int cantJugadores = cartasJugadores.size();
		int cartasEntregadas = 0;

		while (cartasEntregadas < cartasPorJugador) {
			for (int i = 0; i < cantJugadores; i++) {
				ArrayList<Carta> cartasdeEntregadas = cartasJugadores.get(i);
				Carta cartaEntregada = naipeBarajado.remove(0);
				cartasdeEntregadas.add(cartaEntregada);
				cartasEntregadas++;
			}
		}

	}
	
	public int devolverTotal(int idJugador) {
		ArrayList<Carta> cartasJugador = cartasJugadores.get(idJugador);
        int total = 0;

        for (Carta carta : cartasJugador) {
            total += carta.getNumero().getValor();
        }

        return total;
	}
	
	public String determinarGanador() {
		int idGanador = 0;
        int sumaGanador = devolverTotal(0);
        
        for (int i = 1; i < cartasJugadores.size(); i++) {
            int sumaActual = devolverTotal(i);
            if (sumaActual > sumaGanador) {
                idGanador = i;
                sumaGanador = sumaActual;
            }
        }

        return "jugador "+(idGanador+1);
    }
	
	

}
