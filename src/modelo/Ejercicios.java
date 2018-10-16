package modelo;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

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
	
	
	//crear un metodo que genere numeros aleatorios y devuleva un array de enteros 
	
	public int[] generaAleatorio(int n) { //cabecera
		int[] resultado = new int[n]; //inicializar array
		Random rnd = new Random();
		for (int i = 0; i < n; i++)
			resultado[i] = rnd.nextInt(1000);
		return resultado;
		
	}
	
	
	public int[] generaAleatorio2(int cuantos, int inferiro, int superior) {
		int [] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++) {
			resultado[i] = inferiro + rnd.nextInt(superior - inferiro + 1);
		}
		return resultado;
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
	
	public int factorialNumero(int n) {
		
		int resultado = 1;
		for (int i = 1; i <= n ; i++) {
			resultado *= i;
			System.out.println(resultado);
		}
		
		return resultado;
		
		
		
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
	
	public void devuelveMayor(){
		
    Scanner sc = new Scanner(System.in);
   int n1, n2, n3;
    System.out.print("Introduzca primer n�mero: ");
    n1 = sc.nextInt();
    System.out.print("Introduzca segundo n�mero: ");
    n2 = sc.nextInt();
    System.out.print("Introduzca tercer n�mero: ");
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
			//System.out.print(x +" ,");
			z = x + y;
			x = y;
			y = z;	
			fin=z;
			System.out.print(fin +",");
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
}
	

	