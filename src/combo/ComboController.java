package combo;


import auxiliar.Ejercicios;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import modelo.Equipo;
import modelo.Jugador;
import modelo.dao.AccesoDatos;

public class ComboController  {
	@FXML
	private ComboBox<Equipo> miCombo;
	@FXML
	private ListView<Jugador> lv_jugadores;

	public void cargaEquipos() {
		miCombo.getItems().clear();
		// miCombo.getItems().addAll(Ejercicios.crearListaEquipos("ficheros/equipos.txt"));
		miCombo.getItems().addAll(AccesoDatos.getAllTeams("liga", "equipos"));

	}

	public void limpiaJugadoresEquipo() {
		lv_jugadores.getItems().clear();
	}

	public void muestraEquipo() {
		System.out.println("Ha seleccionado un equipo...");
		System.out.println(miCombo.getValue().getId());
	}

	public void cargaJugadoresEquipo() {
		lv_jugadores.getItems().clear();
		lv_jugadores.getItems().addAll(AccesoDatos.getPlayersByTeams(miCombo.getValue().getId()));
		// System.out.println(miCombo.getValue().getId());

	}
}
