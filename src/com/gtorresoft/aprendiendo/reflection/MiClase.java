package com.gtorresoft.aprendiendo.reflection;

public class MiClase {

	public MiClase() {
		// TODO Auto-generated constructor stub
	}
	public String unaVariableString = "Un Texto";
	private int unaVariableInt = 5;
	private MiClase miclasePrivada;
	public MiClase miClasePublica;

	public String getUnaVariableString(String concatenar) {
		return unaVariableString + concatenar;
	}

	private int getUnaVariableInt(int suma) {
		return unaVariableInt + suma;
	}

	/**
	 * @return the miclasePrivada
	 */
	public MiClase getMiclasePrivada() {
		return miclasePrivada;
	}

	/**
	 * @param miclasePrivada the miclasePrivada to set
	 */
	public void setMiclasePrivada(MiClase miclasePrivada) {
		this.miclasePrivada = miclasePrivada;
	}

	/**
	 * @return the miClasePublica
	 */
	public MiClase getMiClasePublica() {
		return miClasePublica;
	}

	/**
	 * @param miClasePublica the miClasePublica to set
	 */
	public void setMiClasePublica(MiClase miClasePublica) {
		this.miClasePublica = miClasePublica;
	}
	
	
}
