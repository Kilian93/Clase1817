package control;

import modelo.Ejercicios;

public class Main {
	
	public static void main(String[] args) {

		Ejercicios prueba = new Ejercicios();
		//int x= 10;
		//int y=30;
		//prueba.pruebasAPI();
		//prueba.listaIntervaloEnteros(x, y);
		//prueba.convertirCadenaAentero("234");
		//prueba.convertirCadenaAentero("ab38");
		//prueba.serieFibonacci(10);
		//prueba.numerosFibonacci(10);
		//prueba.factorialNumero(5);
		//prueba.devuelveMayor2(3.5f, 2.5f, 1.5f);
		//int[] misAleatorios = prueba.generaAleatorio(30);
		int [] misAleatorios = prueba.generaAleatorio2(10, 1, 6);
		System.out.println(" FIN DE PROGRAMA");
		
	}
}

