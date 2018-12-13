package modelo;

public class Estudiante extends Persona{
	
	private String curso;
	private String matricula;
	private char turno; // "D" diurno "T" tarde

	
	public Estudiante(String nif, String nombre, int longitudPaso, char genero, String curso, String matricula,
			char turno) {
		super(nif, nombre, longitudPaso, genero);
		this.curso = curso;
		this.matricula = matricula;
		this.turno = turno;
	}




	public Estudiante(String curso, String matricula, char turno) {
		super();
		this.curso = curso;
		this.matricula = matricula;
		this.turno = turno;
	}



	public Estudiante(String nif, String nombre, int longitudPaso, char genero) {
		super(nif, nombre, longitudPaso, genero);
		// TODO Auto-generated constructor stub
	}



	public String getCurso() {
		return curso;
	}



	public void setCurso(String curso) {
		this.curso = curso;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public char getTurno() {
		return turno;
	}



	public void setTurno(char turno) {
		this.turno = turno;
	}
	
	
}
