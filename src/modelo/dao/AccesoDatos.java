package modelo.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import auxiliar.BaseDeDatos;
import modelo.Equipo;

public class AccesoDatos {

	//08 mayo 2019
	
	/*
	 * public boolean validaLogin(String user, String pwd) { //conectar a la base de
	 * datos //preparar consulta contra liga.usuarios(SELECT) //como saber si existe
	 * o no ?
	 * 
	 * BaseDeDatos bd = new BaseDeDatos("localhost", "liga", "root", ""); Connection
	 * conexion = bd.getConexion(); Statement stmt = conexion.createStatement();
	 * ResultSet rS = stmt.executeQuery("SELECT * from usuario where 1");
	 * ResultSetMetaData mD = rS.getMetaData();
	 * 
	 * return false;
	 * 
	 * }
	 */

	// 02 mayo 2019

	/*
	 * public ArrayList<Equipo> crearListaEquipoBD(String dbDatos, String tabla) {
	 * ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>(); BaseDeDatos bd = new
	 * BaseDeDatos("localhost", "liga", "root", ""); Connection conexion =
	 * bd.getConexion(); Statement stmt = conexion.createStatement(); ResultSet rst
	 * = stmt.executeQuery("select * from" + tabla + "where 1"); ResultSetMetaData
	 * rsMet = rst.getMetaData(); rsMet.getColumnCount(); while (rst.next()) { int
	 * id = Integer.parseInt(rst.getString(1)); String nombreCorto =
	 * rst.getString(2); String nombreLargo = rst.getString(3); int puntos =
	 * Integer.parseInt(rst.getString(4)); int pg =
	 * Integer.parseInt(rst.getString(5)); int pe =
	 * Integer.parseInt(rst.getString(6)); int pp =
	 * Integer.parseInt(rst.getString(7)); int gf =
	 * Integer.parseInt(rst.getString(8)); int gc =
	 * Integer.parseInt(rst.getString(9));
	 * 
	 * } return listaEquipo;
	 * 
	 * }
	 */

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
	public void recorreTabla(String tabla, String dbDatos) {

		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", dbDatos, "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rS = stmt.executeQuery("SELECT * from " + tabla + " where 1");
			ResultSetMetaData mD = rS.getMetaData();
			for (int i = 1; i < mD.getColumnCount(); i++) {
				// System.out.println(i + " -> " + mD.getColumnName(i));
				System.out.print(mD.getColumnName(i) + "\t\t");
			}
			System.out.println();
			while (rS.next()) {
				for (int i = 1; i < mD.getColumnCount(); i++) {

					System.out.print(rS.getString(i) + "\t\t");
				}
				System.out.println();
				// System.out.print(rS.getString(1) + "\t\t" + rS.getString("last_name"));
			}
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
