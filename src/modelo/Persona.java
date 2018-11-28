package modelo;

import java.time.LocalDate;
import java.util.Random;

public class Persona {

	private String nif;
	private String nombre;
	private LocalDate fecha_nac;
	private int longitudPaso;
	
	Persona[] hijos={new Persona("12654307f", "Kilian", 100), new Persona("32459812h", "Marco", 50)};

	public Persona() {
		super();
		this.nif = "54134207G";
		this.nombre = "Kilian Castellano";
		this.fecha_nac = LocalDate.now();
		this.longitudPaso = 57;
	}

	public Persona(String nif, String nombre, int longitudPaso) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.fecha_nac = null;
		// this.fecha_nac = fecha_nac;
		this.longitudPaso = longitudPaso;
	}

	public int caminar(int numPasos) {

		double a = 9.0;
		double raiz = Math.sqrt(a);

		Random miRamdom = new Random();
		int valor = miRamdom.nextInt();

		return numPasos * longitudPaso / 100;
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

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public int getLongitudPaso() {
		return longitudPaso;
	}

	public void setLongitudPaso(int longitudPaso) {
		this.longitudPaso = longitudPaso;
	}
}
