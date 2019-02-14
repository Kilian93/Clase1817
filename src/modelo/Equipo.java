package modelo;

public class Equipo implements Comparable<Equipo>{
	
	private int id;
	private String nombreCorto;
	private String nombreLargo;
	private int puntos;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int golesFavor;
	private int golesEncontra;
	
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Equipo(int id, String nombreCorto, String nombreLargo) {
		super();
		this.id = id;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
	}

	
	public String toString() {
		return this.getNombreLargo();
	}

	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public int getPartidosGanados() {
		return partidosGanados;
	}


	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}


	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}


	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}


	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}


	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}


	public int getGolesFavor() {
		return golesFavor;
	}


	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}


	public int getGolesEncontra() {
		return golesEncontra;
	}


	public void setGolesEncontra(int golesEncontra) {
		this.golesEncontra = golesEncontra;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}


	@Override
	public int compareTo(Equipo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
