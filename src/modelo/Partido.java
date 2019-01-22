package modelo;

public class Partido {
	
	private int id;
	private int Jornada;
	private String equipoLocal;
	private int golesLocal;
	private String equipoVisitante;
	private int golesVisitante;
	
	
	public Partido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Partido(int id, int jornada, String equipoLocal, int golesLocal, String equipoVisitante,
			int golesVisitante) {
		super();
		this.id = id;
		Jornada = jornada;
		this.equipoLocal = equipoLocal;
		this.golesLocal = golesLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesVisitante = golesVisitante;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getJornada() {
		return Jornada;
	}


	public void setJornada(int jornada) {
		Jornada = jornada;
	}


	public String getEquipoLocal() {
		return equipoLocal;
	}


	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}


	public int getGolesLocal() {
		return golesLocal;
	}


	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}


	public String getEquipoVisitante() {
		return equipoVisitante;
	}


	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}


	public int getGolesVisitante() {
		return golesVisitante;
	}


	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	
	
	
}
