package modelo;

import java.time.LocalDate;
import java.util.Random;

public class Persona implements Comparable<Persona>, Humano{

	private String nif;
	private String nombre;
	private char genero;
	private String fecha_nac;
	private int longitudPaso;

	public Persona() {
		super();
		this.nif = "54134207G";
		this.nombre = "Kilian Castellano";
		this.fecha_nac = null;
		this.longitudPaso = 57;
	}

	public Persona(String nif, String nombre, String fecha_nac, int longitudPaso, char genero) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
		this.longitudPaso = longitudPaso;
		this.genero = genero;

		// this.hijos=hijos;
	}
	
	public String toString() {
		return this.getNombre();
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int caminar(int numPasos) {

		double a = 9.0;
		double raiz = Math.sqrt(a);

		Random miRamdom = new Random();
		int valor = miRamdom.nextInt();

		return numPasos * longitudPaso / 100;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public int getLongitudPaso() {
		return longitudPaso;
	}

	public void setLongitudPaso(int longitudPaso) {
		this.longitudPaso = longitudPaso;
	}

	@Override
	public int compareTo(Persona otro) {
		if (this.longitudPaso > otro.longitudPaso)
			return 1;
		else if (this.longitudPaso > otro.longitudPaso)
			return -1;
		else
			return 0;
	}

	@Override
	public boolean dormir(int horas) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float alimentarse(int calorias) {
		// TODO Auto-generated method stub
		return 0;
	}
}
