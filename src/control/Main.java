package control;

import java.util.ArrayList;
import java.util.HashMap;

import auxiliar.Ejercicios;
import modelo.Equipo;
import modelo.Persona;

public class Main {

	public static void main(String[] args) {

		Ejercicios prueba = new Ejercicios();

		// Pruebas Segundo Trimestre
		
		// 21 de febrero 2019
		
		prueba.creaFicheroObjetoEquipos2();
		prueba.leerObjetosEquipos();
		
		
		
		//19 de febrero 2019
		
		// HashMap<String, ArrayList<Integer>> resultados =
				// prueba.resultadosEquipos("ficheros/partidos.txt");
				// HashMap<String, Integer> puntosEquipos =
				// prueba.generaPuntosEquipos(resultados);
				prueba.muestraClasificacion();

		// 07 de frbrero 2019

		HashMap<String, ArrayList<String>> recorgerDatos = prueba.tablaPartidos("ficheros/partidos.txt");

		// 06 de febrero 2019

		//ArrayList<Equipo> ordenarEquipo = prueba.ordenarListaEquipo("ficheros/equipos.txt");

		// 05 de febrero 2019

		// HashMap<String, ArrayList<Integer>> resultado =
		// prueba.resultadosEquipos("ficheros/partidos.txt");
		// HashMap<String, Integer> puntosEquipos =
		// prueba.generaPuntosEquipos(resultado);

		// 30 de enero 2019

		// prueba.pruebaSWING();

		// 29 de enero 2019

		//HashMap<String, ArrayList<Integer>> x = prueba.resultadosEquipos("ficheros/partidos.txt");
		//HashMap<String, Integer> recogerPuntos = prueba.muestraPuntosEquipos(x);
		// HashMap<String,Integer> recoger=
		// prueba.comprobarPartidos("ficheros/partidos.txt", "#");

		// prueba.crearMapaEquipos("ficheros/equipos.txt");
		// prueba.mostrarNumeroPartidosJugadosTry("ficheros/partidos.txt");
		// ArrayList<Persona> listaPersonas =
		// prueba.creaListaPersonas("ficheros/personas.txt", "##");

		// prueba.introLista();
		// prueba.introMapas();
		// prueba.introLista2();
		System.out.println(" FIN DE PROGRAMA");
		System.exit(0);

		// int x= 10;
		// int y=30;
		// prueba.pruebasAPI();
		// prueba.listaIntervaloEnteros(x, y);
		// prueba.convertirCadenaAentero("234");
		// prueba.convertirCadenaAentero("ab38");
		// prueba.serieFibonacci(10);
		// prueba.numerosFibonacci(10);
		// prueba.factorialNumero(5);
		// prueba.devuelveMayor2(3.5f, 2.5f, 1.5f);
		// int n1=15, n2= 50, n3=5, n4=20;
		// System.out.println("el meyoror es: " +prueba.devuelveMayor3(n1, n2, n3, n4));
		// int[] misAleatorios = prueba.generaAleatorio(30);
		// int [] misAleatorios = prueba.generaAleatorio2(10, 130, 150);
		// prueba.imprimeAleatorio(130);
		// int [] miEstadistica = prueba.frecuenciaNum(20, 1, 6);
		// int [] miEstadistica2 = prueba.estadisticaAparicionNumero(20, 1, 6);

		// crear e inicializar un array, varias opciones

		// float[] movs = { 10.0f, -5.0f, 20.5f };

		// prueba.devolverSaldo(10.0f, movs);
		// prueba.pruebaCadena();
		// prueba.compararCadena();
		// int[][] sudoku = new int[9][];

		// ejemplo de matrices

		// int[][] mat = { { 7, 2, 5 }, { 8, 0 }, { 3, 5, 10, 4 }, { 7 } };

		/*
		 * int[][] mat; mat = new int[4][]; mat[0] = new int[3]; mat[0][0] = 7;
		 * mat[0][1] = 2; mat[0][2] = 5; mat[0][3] = 3;
		 */

		float[][] ventasYear = {
				// hay 3 filas (vendedores) y 12 columnas (meses)
				{ 12.5f, 13.50f, 8.5f, 5.0f }, { 16.5f, 14.55f, 5.5f, 1.0f }, { 12.5f, 11.50f, 7.5f, 12.0f } };

		float[] resumenVentasVendedorMes = prueba.resumenVendedorPorMes(ventasYear);

		float[] resumenVendedor = prueba.resumenVendedor(ventasYear);
		// String [] meses = {""};
		// String [] nombres = {""};

		String[] cadenas = { "123", "63A", "ABC", "101" };
		// int[] numero = prueba.convertirCadenasAnumeros(cadenas);
		// prueba.reloj();
		// prueba.imprimirFechaHora();
		// boolean recogerPrimo = prueba.esPrimo2(27);
		// System.out.println(recogerPrimo);
		int desde = 50;
		int cuantos = 5;

		int inicio = 1;
		int fin = 10;

		int[] lista = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] l1 = { 1, 2, 3, 4, 5 };
		int[] l2 = { 6, 7, 8, 9, 10 };
		int[] recogerMezcla = prueba.mezclaListaOrdenadas(l1, l2);

		Persona madre = new Persona();
		madre.setNombre("Maria");

		/*
		 * Persona[] persona1 = new Persona[3]; persona1[0] = new Persona("54134207g",
		 * "kilian", 100, 'm', null, null); persona1[1] = new Persona("54134207g",
		 * "kilian", 100, 'm', madre, null); persona1[2] = new Persona("54134207g",
		 * "kilian", 100, 'm', null, null);
		 */

		// prueba.invertirLista(lista);
		int[] invertirLista = prueba.invertirLista2(lista);

		// int[] recorgerPrimos3=prueba.listarPrimos3(desde, cuantos);

		// prueba.listarPrimos2(desde, cuantos);
		// prueba.listarPrimos(inicio, fin);
		// prueba.esPrimo(9);

		System.out.println(" FIN DE PROGRAMA");

	}

}
