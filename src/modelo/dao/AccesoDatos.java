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
import java.util.HashMap;

import auxiliar.BaseDeDatos;
import modelo.Equipo;
import modelo.Jugador;

public class AccesoDatos {

	// 21 mayo 2019
	
	public static void insertaPartidosDesdeFichero(String rutaPartidos) {

		try {
			BufferedReader fichero;
			fichero = new BufferedReader(new FileReader(rutaPartidos));
			String registro;

			BaseDeDatos bd = new BaseDeDatos("localhost", "liga", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			
			int IdCamposNull = 0;
			int gL;
			int gV;
			
			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				
				if (campos[3].equals("")) {
					gL = 0;
					gV = 0;
					IdCamposNull = Integer.parseInt(campos[0]);
				} else {
					gL = Integer.parseInt(campos[3]);
					gV = Integer.parseInt(campos[5]);
				}
				
				int id = Integer.parseInt(campos[0]);
				int jornada = Integer.parseInt(campos[1]);
				String eL = campos[2];				
				String eV = campos[4];				
				

				String sql = "INSERT INTO partidos (id, jornada, eL, gL, eV, gV) VALUES ";
				sql += "(" + id + ",'" + jornada + "'," + "'" + eL + "'," + "'" + gL + "'," + "'" + eV + "'," + "'" + gV + "')";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				
				if (campos[3].equals(""))
					 stmt.executeUpdate("UPDATE partidos SET gL = null, gV= null WHERE id = '" + IdCamposNull + "'");
				
			}

			fichero.close();
			System.out.println("Fin de la lectura del fichero");
		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertarPartidosBD(String rutaPartidos) {

		try {
			BufferedReader fichero;
			fichero = new BufferedReader(new FileReader(rutaPartidos));
			BaseDeDatos bd = new BaseDeDatos("localhost:3306", "liga", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			int IdCamposNull = 0;
			int gL;
			int gV;
			String registro;
			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				if (campos[3].equals("")) {
					gL = 0;
					gV = 0;
					IdCamposNull = Integer.parseInt(campos[0]);
				} else {
					gL = Integer.parseInt(campos[3]);
					gV = Integer.parseInt(campos[5]);
				}
				
				int id = Integer.parseInt(campos[0]);
				int jornada = Integer.parseInt(campos[1]);
				String eL= campos[2];
				String eV= campos[4];
			
				String sql = "insert into partidos(idPartidos,jornada,equipoLocal,golesLocal,equipoVisitante,golesVisitante) values";
				sql+= "(" + id + "," + jornada + ",\"" + eL + "\"," + gL + ",\"" + eV + "\"," + gV + ")";
				System.out.println(sql);	
				stmt.executeUpdate(sql);
				
				if (campos[3].equals(""))
					 stmt.executeUpdate("UPDATE partidos SET golesLocal = null, golesVisitante= null WHERE idPartidos = '" + IdCamposNull + "'");

			}
			stmt.close();
			conexion.close();
			fichero.close();
			System.out.println("Fin de la lectura del fichero");
		} catch (NumberFormatException e) {
			
		} catch (FileNotFoundException e) {
			System.out.println("fichero no encontrado");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}

	public static HashMap<String, Equipo> getAllTeamsMapa(String dbDatos, String tabla) {
		HashMap<String, Equipo> listaEquipo = new HashMap<String, Equipo>();
		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", dbDatos, "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rst = stmt.executeQuery("select * from " + tabla + " where 1");
			ResultSetMetaData rsMet = rst.getMetaData();
			rsMet.getColumnCount();
			while (rst.next()) {
				Equipo e = new Equipo();

				e.setId(rst.getInt("id"));
				e.setNombreCorto(rst.getString("nombreCorto"));
				e.setNombreLargo(rst.getString("nombreLargo"));
				// e.setPartidosJugados(rst.getInt("pj"));
				e.setPuntos(rst.getInt("puntos"));
				e.setPartidosGanados(rst.getInt("pg"));
				e.setPartidosEmpatados(rst.getInt("pe"));
				e.setPartidosPerdidos(rst.getInt("pp"));
				e.setGolesFavor(rst.getInt("gf"));
				e.setGolesEncontra(rst.getInt("gc"));
				listaEquipo.put("nombreCorto", e);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return listaEquipo;
	}

	// 15 mayo 2019

	public static ArrayList<Jugador> getPlayersByTeams(int idEquipo) {
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", "liga", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();

			// String sql = "Select liga.jugadores where idEquipo" + "like'"+ idEquipo +
			// ";";
			String sql = "select * from jugadores where idEquipo " + " like '" + idEquipo + "'";

			System.out.println(sql);

			ResultSet rst = stmt.executeQuery(sql);

			while (rst.next()) {
				Jugador jugador = new Jugador();
				jugador.setId(rst.getInt("id"));
				jugador.setNombre(rst.getString("nombre"));
				jugador.setDorsal(rst.getInt("dorsal"));
				jugador.setCodigoEquipo(rst.getInt("idEquipo"));
				listaJugadores.add(jugador);
			}
			rst.close();
			stmt.close();
			conexion.close();
			return listaJugadores;

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return null;

	}

	public static ArrayList<Equipo> getAllTeams(String dbDatos, String tabla) {
		ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();

		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", dbDatos, "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rst = stmt.executeQuery("select * from " + tabla + " where 1");
			ResultSetMetaData rsMet = rst.getMetaData();
			rsMet.getColumnCount();
			while (rst.next()) {
				Equipo e = new Equipo();

				e.setId(rst.getInt("id"));
				e.setNombreCorto(rst.getString("nombreCorto"));
				e.setNombreLargo(rst.getString("nombreLargo"));
				// e.setPartidosJugados(rst.getInt("pj"));
				e.setPuntos(rst.getInt("puntos"));
				e.setPartidosGanados(rst.getInt("pg"));
				e.setPartidosEmpatados(rst.getInt("pe"));
				e.setPartidosPerdidos(rst.getInt("pp"));
				e.setGolesFavor(rst.getInt("gf"));
				e.setGolesEncontra(rst.getInt("gc"));
				listaEquipo.add(e);

			}
			rst.close();
			stmt.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaEquipo;
	}

	// 08 mayo 2019

	public static boolean validaLogin(String user, String pwd) {
		// conectar a la base de datos
		// preparar consulta contra liga.usuarios(SELECT)
		// como saber si existe o no ?

		try {
			BaseDeDatos bd = new BaseDeDatos("localhost", "liga", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			/*
			 * ResultSet rst = stmt.executeQuery("select nombre, clave from usuarios where
			 * nombre like" + "\"" + user + "\"" + "and clave like" + "\"" + pwd + "\";");
			 * 
			 * if (rst != null && rst.next()) { System.out.println(rst.getString(1) + " " +
			 * rst.getString(2)); } else {
			 * System.out.println("Usuario o contrase�a incorrecta"); }
			 */

			/*
			 * String sql = "select nombre, clave from usuarios where nombre like" + "\"" +
			 * user + "\"" + "and clave like" + "\"" + pwd + "\";";
			 */
			String sql = "SELECT * FROM usuarios  WHERE usuario LIKE '" + user + "' AND clave LIKE '" + pwd + "'";
			// System.out.println(sql);
			ResultSet rst = stmt.executeQuery(sql);

			int contador = 0;
			while (rst.next()) {
				contador++;
			}
			rst.close();
			stmt.close();
			conexion.close();
			if (contador == 0)
				return false;
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Error de conexi�n");
		}

		return false;

	}

	// 02 mayo 2019

	public static ArrayList<Equipo> crearListaEquipoBD(String dbDatos, String tabla) {
		ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
		try {

			BaseDeDatos bd = new BaseDeDatos("localhost", dbDatos, "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rst = stmt.executeQuery("select * from " + tabla + " where 1");
			ResultSetMetaData rsMet = rst.getMetaData();
			rsMet.getColumnCount();
			while (rst.next()) {
				int id = Integer.parseInt(rst.getString(1));
				String nombreCorto = rst.getString(2);
				String nombreLargo = rst.getString(3);
				// int pj = Integer.parseInt(rst.getString(4));
				// int puntos = Integer.parseInt(rst.getString(5));
				// int pg = Integer.parseInt(rst.getString(6));
				// int pe = Integer.parseInt(rst.getString(7));
				// int pp = Integer.parseInt(rst.getString(8));
				// int gf = Integer.parseInt(rst.getString(9));
				// int gc = Integer.parseInt(rst.getString(10));
				// Equipo equipo = new Equipo(id, nombreCorto, nombreLargo, pj, puntos, pg, pe,
				// pp, gf, gc);
				// listaEquipo.add(equipo);

				Equipo equipo2 = new Equipo(id, nombreCorto, nombreLargo);
				listaEquipo.add(equipo2);
			}
			/*
			 * for (int i = 0; i < listaEquipo.size(); i++) { Equipo unEquipo =
			 * listaEquipo.get(i); System.out.println(unEquipo.getId() + " --> " +
			 * unEquipo.getNombreCorto() + " --> " + unEquipo.getNombreLargo() + " --> " +
			 * unEquipo.getPartidosJugados() + " --> " + unEquipo.getPuntos() + " --> " +
			 * unEquipo.getPartidosGanados() + " --> " + unEquipo.getPartidosEmpatados() +
			 * " --> " + unEquipo.getPartidosPerdidos() + " --> " + unEquipo.getGolesFavor()
			 * + " --> " + unEquipo.getGolesEncontra());
			 * 
			 * }
			 */
			for (int i = 0; i < listaEquipo.size(); i++) {
				Equipo unEquipo = listaEquipo.get(i);
				System.out.println(
						unEquipo.getId() + " --> " + unEquipo.getNombreCorto() + " --> " + unEquipo.getNombreLargo());

			}

			rst.close();
			stmt.close();
			conexion.close();

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaEquipo;

	}

	// 30 abril 2019

	public void insertarJugadoresBD2(String rutaJugadores) {
		try {
			BufferedReader fichero;
			fichero = new BufferedReader(new FileReader(rutaJugadores));
			BaseDeDatos bd = new BaseDeDatos("localhost:3306", "liga", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();

			String registro;
			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				int id = Integer.parseInt(campos[0]);
				String nif = campos[1];
				String nombre = campos[2];
				int longitudPaso = Integer.parseInt(campos[3]);
				String fecha_nac = campos[4];
				char sexo = campos[5].charAt(0);
				int dorsal = Integer.parseInt(campos[6]);
				int idEq = Integer.parseInt(campos[7]);

				String sql = "insert into jugadores(id, nif, nombre, longitudPaso, fecha_nac, sexo,  dorsal, idEq) values";
				sql += "(" + id + ",\"" + nif + "\",\"" + nombre + "\"," + longitudPaso + ",\"" + fecha_nac + "\",\'"
						+ sexo + "\'," + dorsal + "," + idEq + ")";
				System.out.println(sql);
				stmt.executeUpdate(sql);
			}
			stmt.close();
			conexion.close();
			fichero.close();
			System.out.println("Fin de la lectura del fichero");
		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertarJugadoresBD(String rutaFichero) {

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
				String nombre = campos[1];
				int dorsal = Integer.parseInt(campos[2]);
				int idEquipo = Integer.parseInt(campos[3]);

				String sql = "	INSERT INTO jugadores (id, nombre, dorsal, idEquipo) VALUES";
				sql += "(" + id + ",\"" + nombre + "\"," + "\"" + dorsal + "\"," + "\"" + idEquipo + "\")";
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
			for (int i = 1; i <= mD.getColumnCount(); i++) {
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
			System.out.println("Error de conexi�n");

		}
	}
}
