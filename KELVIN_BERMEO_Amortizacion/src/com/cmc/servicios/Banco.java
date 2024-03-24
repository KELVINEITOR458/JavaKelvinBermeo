package com.cmc.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.Cliente;
import com.cmc.evaluacion.Prestamo;

public class Banco {
	ArrayList<Prestamo> prestamo;
	ArrayList<Cliente> clientes;

	public Banco() {
		this.prestamo = new ArrayList<Prestamo>();
		this.clientes = new ArrayList<Cliente>();
	}

	public ArrayList<Prestamo> getPrestamo() {
		return prestamo;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Cliente buscarCliente(String cedula) {
		Cliente clienteEncontrado = null;
		Cliente cliente;
		for (int i = 0; i < clientes.size(); i++) {
			cliente = clientes.get(i);
			if (cliente.getCedula().equals(cedula)) {
				clienteEncontrado = cliente;
			}
		}

		return clienteEncontrado;
	}

	public void registrarCliente(Cliente cliente) {
		if (buscarCliente(cliente.getCedula()) == null) {
			clientes.add(cliente);
			System.out.println("Cliente registrado");
		} else {
			System.out.println("Este cliente ya existe: " + cliente.getCedula());
		}

	}

	public void agregarPrestamo(String cedula, Prestamo prestamo) {
		Cliente clienteEncontrado = buscarCliente(cedula);
		if (clienteEncontrado == null) {
			System.out.println("No es cliente del banco");
		} else {
			prestamo.setCliente(clienteEncontrado);
			CalculadoraAmortizacion.generarTabla(prestamo);
			this.prestamo.add(prestamo);
		}
	}

	public ArrayList<Prestamo> buscarPrestamos(String cedula) {
		ArrayList<Prestamo> prestamoCliente = new ArrayList<>();
		for (int i = 0; i < prestamo.size(); i++) {
			Prestamo prestamoo = prestamo.get(i);
			if (prestamoo.getCliente().getCedula().equals(cedula)) {
				prestamoCliente.add(prestamoo);
			}
		}
		return prestamoCliente;
	}
}
