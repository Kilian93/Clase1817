package modelo;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.View;

public class Ejercicios {

	public void pruebasAPI() {
		// 1. imprimiir por consola el valor de 2 elevado a 2
		// 2. Imprime un valor aleatorio entre 1 y 100
		// 3. En la cadena "LAS PALMAS DE GRAN CANARIA", imprime "GRAN"

		// 1. Usa la clase estatica java.lang.Math y sus metodos
		// 2. Usa la clase java.util.Ramdom y el metodo rnd.
		// 3.

		// double resul = Math.pow(2, 3);
		System.out.println("1." + Math.pow(2, 3));
		Random rnd = new Random();
		System.out.println("2." + rnd.nextInt(100));
		System.out.println("3." + "LAS PALMAS DE GRAN CANARIA".substring(14, 18));

	}

	
	public Persona[] crearListaPersona() {
		return personas;
		
	}
	
	// declarar un array de persona

	private Persona[] personas = {};

	public void hijosPersona() {
		// int numHijos= personas[4].getHijos().length;

		for (int i = 0; i < personas.length; i++) {
			Persona[] hijos = personas[i].getHijos();
			System.out.println("Progenitor --> "+ personas[0].getNombre());
			if (hijos != null)
				for (int j = 0; j < hijos.length; j++) {
					System.out.println("Hijo --> " + hijos[j].getNombre());

				}
		}
	}

	public void invertirLista(int[] lista) {
		int aux = 0;
		for (int i = 0; i < lista.length / 2; i++) {

			aux = lista[i];
			lista[i] = lista[lista.length - i - 1];
			lista[lista.length - i - 1] = aux;
		}

	}

	public int[] mezclaListaOrdenadas(int[] l1, int[] l2) {

		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j])
				resultado[k] = l1[i++];
			else
				resultado[k] = l2[j++];
			k++;

			if (i == l1.length)
				l1[--i] = Integer.MAX_VALUE;

			if (j == l2.length)
				l2[--j] = Integer.MAX_VALUE;
		}
		return resultado;

	}

	public void invertirCaracterCadena(String cadena) {
		String sCadenaInvertida = null;
		for (int i = cadena.length() - 1; i >= 0; i--) {
			sCadenaInvertida = sCadenaInvertida + cadena.charAt(i);
		}

		// for (int x=sCadena.length()-1;x>=0;x--)
		// sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x)
	}

	public void mostrarVentasVndedor() {

	}

	public int[] convertirCadenasAnumeros(String[] cn) {
		int[] resultado = new int[cn.length];
		for (int i = 0; i < resultado.length; i++)
			try {
				resultado[i] = Integer.parseInt(cn[i]);
			} catch (NumberFormatException e) {
				resultado[i] = -1;
			}

		return resultado;

	}

	/*
	 * public float [] resumenVendedorIrregular(float[][] ventas) { float
	 * acumVendedor = 0; float [] resultado = new float[ventas.length]; for (int i =
	 * 0; i < ventas.length; i++) { if(ventas[i].length > acumVendedor)
	 * acumVendedor=ventas[i].length; } for (int j = 0; j < resultado.length; j++) {
	 * for } return resultado; }
	 */

	// Ejercicio para tener claro los bucles anidados

	public int[] listarPrimos3(int desde, int cuantos) {
		int[] primos = new int[cuantos];
		int acum = 0;
		while (acum < cuantos) {
			if (esPrimo2(desde))
				primos[acum++] = desde;
			desde++;
		}
		return primos;
	}

	public void listarPrimos2(int desde, int cuantos) {
		int acum = 0;
		while (acum < cuantos) {
			if (esPrimo2(desde++))
				System.out.print(desde + ", ");
			acum++;

		}
	}

	public void listarPrimos(int desde, int hasta) {
		for (int i = desde; i < hasta; i++)
			if (esPrimo2(i))
				System.out.print(i + ",");

	}

	public boolean esPrimo2(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}

		return true;
	}

	public void esPrimo(int numero) {
		boolean primo = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				primo = false;
			break;
		}
		if (primo)
			System.out.println(numero + " es primo");
		else
			System.out.println(numero + " no es primo");
		;
	}

	public void imprimirFechaHora() {
		for (int i = 0; i < 10; i++) {
			System.out.println(LocalDateTime.now());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void reloj() {
		for (int h = 0; h < 24; h++)
			for (int m = 0; m < 60; m++)
				for (int s = 0; s < 60; s++) {
					System.out.println(h + ":" + m + ":" + s);
					try {
						Thread.sleep(s);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

	}

	public float[] resumenVendedorPorMes(float[][] ventas) {
		float[] resultado = new float[ventas[0].length];
		float acum = 0;
		for (int j = 0; j < ventas[0].length; j++) {
			for (int i = 0; i < ventas.length; i++)
				acum += ventas[i][j];
			resultado[j] = acum;

		}

		return resultado;

	}

	public float[] resumenVendedor(float[][] ventas) {
		float[] resultado = new float[ventas.length];
		float acum = 0f;
		for (int i = 0; i < ventas.length; i++) {
			acum = 0;
			for (int j = 0; j < ventas[i].length; j++)
				acum += ventas[i][j];
			resultado[i] = acum;

		}

		return resultado;

	}

	public void recorerMatriz(int[][] mat) {
		int acum = 0;
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[i].length; j++) {
				acum += mat[i][j];

			}
	}

	public void compararCadena() {
		String nombre = "abc";
		String nombre2 = "aba";
		// System.out.println(nombre.compareTo(nombre2));

		if (nombre.compareTo(nombre2) == 0)
			System.out.println("cadena1 y cadena2 son iguales");
		else if (nombre.compareTo(nombre2) < 0)
			System.out.println("cadena1 va antes que cadena2");
		else if (nombre.compareTo(nombre2) > 0)
			System.out.println("cadena2 va después que cadena1: " + nombre2);

	}

	public void pruebaCadena() {

		String nombre = "LAS PALMAS DE GRAN CANARIAS";

		for (int i = 0; i < nombre.length(); i++) {
			System.out.println(nombre.charAt(i));

		}

	}

	public float devolverSaldo(float saldoInicial, float[] movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.length; i++)
			saldoFinal += movimientos[i];
		System.out.println("Saldo Final es: " + saldoFinal + "€");

		return saldoFinal;

	}

	public Persona[] devolverListaPersona(int n) {
		Persona[] resultado = new Persona[n];
		for (int i = 0; i < n; i++) {
			resultado[i] = new Persona();
		}
		return resultado;
	}

	public void imprimeAleatorio(int n) {
		Random rnd = new Random();
		int numero = 0;
		for (int i = 0; i < n; i++) {
			numero = 1 + rnd.nextInt(100);
			System.out.println(i + 1 + ".- " + numero);
		}
	}

	public int[] estadisticaAparicionNumero(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		Random rnd = new Random();
		int numero = 0;
		for (int i = 0; i < cuantos; i++) {
			numero = inferior + rnd.nextInt(superior - inferior + 1);
			resultado[numero - 1]++;
		}

		return resultado;
	}

	// crear un metodo para calcular la frecuencia de aparición de un número

	public int[] frecuenciaNum(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamiento = this.generaAleatorio2(cuantos, inferior, superior);
		for (int i = 0; i < lanzamiento.length; i++) {
			resultado[lanzamiento[i] - 1]++;
		}
		return resultado;
	}

	// crear un metodo que genere numeros aleatorios y devuleva un array de enteros

	public int[] generaAleatorio(int n) { // cabecera
		int[] resultado = new int[n]; // inicializar array
		Random rnd = new Random();
		for (int i = 0; i < n; i++)
			resultado[i] = rnd.nextInt(1000);
		return resultado;

	}

	// devuelve un Array de numeros enteros aleatorios

	public int[] generaAleatorio2(int cuantos, int inferior, int superior) {
		int[] resultado = new int[cuantos];// Declaro e Inicializo el Array
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);

		return resultado;
	}

	// Mostrar por consola los numeros comprendidos entre dos entero a y b

	// 1.prototipo del metodo

	public void listaIntervaloEnteros(int primero, int ultimo) {
		// 2.implementacion del metodo

		for (int j = primero; j < ultimo; j++)
			System.out.println(j);
		;

		// true/false
		boolean condicion = true;
		if (condicion) {
			// en caso de verdadero

		} else {
			// en caso de falso
		}

		// int i=primero;
		/*
		 * while (i < ultimo){ System.out.println(i++);
		 */
	}

	public int factorialNumero(int n) {

		int resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado *= i;
			System.out.println(resultado);
		}

		return resultado;

	}

	public static int devuelveMayor3(int n1, int n2, int n3, int n4) {
		if (n1 > n2)
			if (n1 > n3)
				if (n1 > n4)
					return n1;
				else
					return n4;

			else if (n3 > n4)
				return n3;
			else
				return n4;

		else if (n2 > n3)
			if (n2 > n4)
				return n2;
			else
				return n4;
		else if (n3 > n4)
			return n3;
		else
			return n4;

	}

	public float devuelveMayor3(float n1, float n2, float n3) {
		if (n1 > n2)
			if (n1 > n3)
				return n1;
			else
				return n3;
		else if (n2 > n3)
			return n2;
		else
			return n3;
	}

	public void devuelveMayor2(float n1, float n2, float n3) {

		if (n1 > n2) {
			if (n1 > n3) {
				System.out.println("El mayor es: " + n1);
			} else {
				System.out.println("el mayor es: " + n3);
			}
		} else if (n2 > n3) {
			System.out.println("el mayor es: " + n2);
		} else {
			System.out.println("el mayor es: " + n3);
		}

	}

	public void devuelveMayor() {

		Scanner sc = new Scanner(System.in);
		int n1, n2, n3;
		System.out.print("Introduzca primer número: ");
		n1 = sc.nextInt();
		System.out.print("Introduzca segundo número: ");
		n2 = sc.nextInt();
		System.out.print("Introduzca tercer número: ");
		n3 = sc.nextInt();
		if (n1 > n2) {
			if (n1 > n3) {
				System.out.println("El mayor es: " + n1);
			} else {
				System.out.println("el mayor es: " + n3);
			}
		} else if (n2 > n3) {
			System.out.println("el mayor es: " + n2);
		} else {
			System.out.println("el mayor es: " + n3);
		}
	}

	public Integer convertirCadenaAentero(String cadena) {
		int parse_numero = 0;
		try {
			parse_numero = Integer.parseInt(cadena);
			System.out.println("El numero es : " + cadena);
		} catch (NumberFormatException e) {
			System.out.println(cadena + " no es un numero valido");
		}
		return parse_numero;
	}

	public void serieFibonacci(int cuanto) {
		int x = 0;
		int y = 1;
		int z;
		int fin = 0;
		for (int i = 2; i < cuanto; i++) {
			// System.out.print(x +" ,");
			z = x + y;
			x = y;
			y = z;
			fin = z;
			System.out.print(fin + ",");
		}

	}

	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		int z;
		numeros[0] = x;
		numeros[1] = y;
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			numeros[i] = z;
			x = y;
			y = z;
		}
		return numeros;
	}

	/*
	 * public static void main(String[] args) { Ejercicios ejercicios = new
	 * Ejercicios(); int n1 = 15, n2 = 50, n3 = 5, n4 = 20; int mayor =
	 * Ejercicios.devuelveMayor3(n1, n2, n3, n4); // definido con la Clase
	 * Ejercicios al estar el metod en // statico // int mayor =
	 * ejercicios.devuelveMayor3(n1, n2, n3, n4); //definido con el // objeto
	 * ejercicios System.out.println("el mayor es : " + mayor); }
	 */

}
