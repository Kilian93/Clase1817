package modelo.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auxiliar.BaseDeDatos;

public class AccesoDatos {

	// 30 abril 2019

	public void insertarEquiposBD(String rutaFichero) {

		BufferedReader fichero;
		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", "liga", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			// String sql = "delete from equipos";
			// int rS = stmt.executeUpdate(sql);
			fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				int id = Integer.parseInt(campos[0]);
				String nombreCorto = campos[1];
				String nombreLargo = campos[2];

				String sql = "	INSERT INTO equipos (id, nombreCorto, nombreLargo) VALUES";
				sql += "(" + id + ",\"" + nombreCorto + "\"," + "\"" + nombreLargo + "\")";
				System.out.println(sql);
				stmt.executeUpdate(sql);
			}
			fichero.close();
			System.out.println("Fin de la lectura del fichero");

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("fichero no encontrado");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Excepcion");

		}

	}

	// mostrar por consola lodos los actores
	public void recorreTabla() {

		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", "sakila", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rS = stmt.executeQuery("SELECT first_name, last_name FROM actor");
			while (rS.next())
				System.out.println(rS.getString(1) + "\t\t" + rS.getString("last_name"));
			rS.close();
			stmt.close();
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error de conexión");

		}
	}
}
