package modelo;

import java.time.LocalDate;

public class Estudiante extends Persona {

	private String curso;
	private String matricula;
	private char turno; // "D" diurno "T" tarde "N" noche

	public Estudiante() {
		super();
	}

	

	


	public Estudiante(String nif, String nombre, LocalDate fecha_nac, int longitudPaso, char genero) {
		super(nif, nombre, fecha_nac, longitudPaso, genero);
		
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
