package com.eglobal.test.utils;

public class PalindromoTest {

	public static void main(String[] args) {

		// Definimos el número
		int num = 31;

		while (!(esPalindromo(num) && esPrimo(num))) {
			num++;
		}

		System.out.println(num);
	}
 
	// Función que nos permite determinar si es primo
	private static boolean esPrimo(int num) {
		return divisoresMenores(num) == 1;
	}

	// Nos ayuda a obtener cuantas pares caben en nuestro valor basado en el número ingresado.
	private static int divisoresMenores(int num) {
		
		// Contador
		int cantDivisores = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0)
				cantDivisores++;
		}
		return cantDivisores;
	}

	// Determinamos si es palindromo
	private static boolean esPalindromo(int num) {
		String s = String.valueOf(num);
		return (s.equals((reversa(s))));

	}

	// Con el valor convertido en string lo volteamos.
	private static String reversa(String s) {
		String reversa = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversa += String.valueOf(s.charAt(i));
		}
		return reversa;
	}

}
