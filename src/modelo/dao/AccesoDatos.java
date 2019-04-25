package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auxiliar.BaseDeDatos;

public class AccesoDatos {

	// mostrar por consola lodos los actores
	public void recorreTabla() {

		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", "sakila", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rS;
			rS = stmt.executeQuery("SELECT first_name, last_name FROM actor");
			while (rS.next()) {
				System.out.println(rS.getString(1) + "\t\t" + rS.getString("last_name"));
				rS.close();
				stmt.close();
				conexion.close();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
}
}
