package modelo;

public class Jugador extends Persona{

	private int id;
	private int dorsal;
	private int idEquipo;
	
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Jugador(String nombre, int id, int dorsal, int idEquipo) {
		super(nombre);
		this.id = id;
		this.dorsal = dorsal;
		this.idEquipo = idEquipo;
	}


	/*public Jugador(String nif, String nombre, String fecha_nac, int longitudPaso, char genero, int id, int dorsal,
			int idEquipo) {
		super(nif, nombre, fecha_nac, longitudPaso, genero);
		this.id = id;
		this.dorsal = dorsal;
		this.idEquipo = idEquipo;
	}*/





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public int getCodigoEquipo() {
		return idEquipo;
	}
	public void setCodigoEquipo(int codigoEquipo) {
		this.idEquipo = codigoEquipo;
	}
	
}
