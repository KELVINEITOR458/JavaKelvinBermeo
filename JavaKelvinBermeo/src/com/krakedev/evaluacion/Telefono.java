package com.krakedev.evaluacion;

public class Telefono {
	private String numero;
	private String tipo;
	private String estado;

	
	public Telefono(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
		
		if(validar(numero, tipo) == false) {
			this.estado = "C";
		}else {
			this.estado = "E";
		}
	}

	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}
	
	public boolean validar(String numero, String tipo) {
		boolean error = false;
		
		if (numero == null || tipo == null) {
            error = true;
        }else {
        	error = false;
        }

		if(tipo != null) {
			if (tipo.equals("Movil") || tipo.equals("Convencional")) {
	            error = false;
	        }else {
	        	error = true;
	        }
		}else {
			error = true;
		}
        

        if(numero != null && tipo != null) {
        	if (tipo.equals("Movil") && numero.length() != 10) {
                error = true;
            }else {
            	error = false;
            }
        }else {
        	error = true;
        }
       
        if(numero != null && tipo != null) {
        	if (tipo.equals("Convencional") && numero.length() != 7) {
                error = true;
            }else {
            	error = false;
            }
        }else {
        	error = true;
        }
        
		
		return error;
	}
	
	
}
