package control;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Random;

import modelo.Persona;

public class Ejercicios {

	public void pruebasAPI() {
		// 1. imprimiir por consola el valor de 2 elevado a 2
		// 2. Imprime un valor aleatorio entre 1 y 100
		// 3. En la cadena "LAS PALMAS DE GRAN CANARIA", imprime "GRAN"

		// 1. Usa la clase estatica java.lang.Math y sus metodos
		// 2. Usa la clase java.util.Ramdom y el metodo rnd.
		// 3.

		//double resul = Math.pow(2, 3);
		System.out.println("1." + Math.pow(2, 3));
		Random rnd = new Random();
		System.out.println("2." + rnd.nextInt(100));
		System.out.println("3." + "LAS PALMAS DE GRAN CANARIA".substring(14, 18));
				
		
	}
	
	//Mostrar por consola los numeros comprendidos entre dos entero  a y b 
	
	//1.prototipo del metodo
	
	public void listaIntervaloEnteros(int primero, int ultimo) {
		//2.implementacion del metodo
		
		for (int j = primero; j < ultimo; j++)
			System.out.println(j);;
			
		// true/false	
		boolean condicion = true;	
		if (condicion) {
			//en caso de verdadero
			
		}
		else {
			//en caso de falso
		}
			
			
		//int i=primero;
		/*while (i < ultimo){
			System.out.println(i++);*/
			} 
	
	public Integer convertirCadenaAentero (String cadena){
		int parse_numero=0;
		try {
			parse_numero = Integer.parseInt(cadena);
			System.out.println("El numero es : " + cadena);
		} catch (NumberFormatException e) {
			System.out.println(cadena + " no es un numero valido");
		}
		return parse_numero;}
	
	public void serieFibonacci(int cuanto){
		int x=0;
		int y=1;
		int z;
		int fin=0;
		for (int i = 2; i < cuanto; i++) {
			z = x + y;
			x = y;
			y = z;	
			fin=z;
			System.out.println(fin);
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
	

	public static void main(String[] args) {

		Ejercicios prueba = new Ejercicios();
		//int x= 10;
		//int y=30;
		//prueba.pruebasAPI();
		//prueba.listaIntervaloEnteros(x, y);
		//prueba.convertirCadenaAentero("234");
		//prueba.convertirCadenaAentero("ab38");
		prueba.serieFibonacci(10);
		//prueba.numerosFibonacci(10);
		System.out.println("FIN DE PROGRAMA");
		
	}
}
