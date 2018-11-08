package control;

import modelo.Ejercicios;

public class Main {

	public static void main(String[] args) {

		Ejercicios prueba = new Ejercicios();
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
		//int[] recorgerPrimos3=prueba.listarPrimos3(desde, cuantos);
		
		prueba.listarPrimos2(desde, cuantos);
		//prueba.listarPrimos(inicio, fin);
		// prueba.esPrimo(9);
		System.out.println(" FIN DE PROGRAMA");

	}

}
