package combo;

import auxiliar.Ejercicios;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import modelo.Equipo;

public class ComboControler {
	
	@FXML
	private ComboBox<Equipo> miCombo;

	
	public void cargaEquipos() {
		miCombo.getItems().clear();
		miCombo.getItems().addAll(Ejercicios.crearListaEquipos("ficheros/equipos.txt"));
	}
	
	public void muestraEquipo() {
		
		
	}

}
