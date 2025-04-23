package Ejercicios;

public class TercerEjercicio {
	/*
	 EJERCICIO 3. Escriba un método en Java que:
	
	*/
	
//	a. Reciba un número y determine si es par.
	public static void EsPar(int num) {
		if (num%2==0) {
			System.out.println("El número ingresado es par.");
		} else {
			System.out.println("El número ingresado es impar.");
		}
	}
	
//	b. Reciba un número y determine si es múltiplo de 5 o 7.
	public static void EsMultiplo(int num) {
		if ((num%5==0) && (num%7==0)) {
			System.out.println("El número ingresado es múltiplo de 5 y de 7.");
		}
		else if (num%7==0) {
			System.out.println("El número ingresado solamente es múltiplo de 7.");
			
		} else if (num%5==0) {
			System.out.println("El número ingresado solamente es múltiplo de 5.");
			
		}else {
			System.out.println("El número ingresado no es múltiplo de 5 ni de 7.");
		}
	}
	
//	c. Reciba dos números y retorne el mayor de ellos.
	public static int MayorEntre2(int a, int b) {
		int mayor;
		if (a == b) {
			mayor = a;
			System.out.println("Ambos números son iguales.");
		}else if (a > b) {
			mayor = a;
			System.out.println("El primer número ingresado es el mayor.");
		}else {
			mayor = b;
			System.out.println("El segundo número ingresado es el mayor");
		}
		return mayor;
	}
	
//	d. Reciba tres números y retorne el mayor de los tres.
	public static int MayorEntre3(int a, int b, int c) {
		int mayor;
		if ((a > b) && (a > c)) {
			mayor = a;
		}else if ((b > a) && (b > c)) {
			mayor = b;
		}else {
			mayor = c;
		}
		
		return mayor;
	}
	
//	e. Reciba un número entre 0 y 10, y si el número está entre 0 y 4 muestre “desaprobado”, si está entre 5 y 6
//	muestre “suspenso”, y si es mayor que 6 muestre “aprobado”.
	public static void EvaluarNota(int a) {
		int nota = a;
		if ((nota < 0) || (nota > 10)) {
			System.out.println("No se aceptan nota menores a 0 o mayores a 10");
		}
		
		switch(nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("Desaprobado.");
			break;
		case 5:
		case 6:
			System.out.println("Suspenso.");
			break;
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("Aprobado");
			break;
		}
		
		
	}
	
//	f. Muestre por pantalla todos los números entre 0 y 100.
	public static void MostrarNumerosEntre0Y100 () {
		for(int i = 0; i<=100;i++) {
			System.out.println(i);
		}
	}
	
//	g. Reciba un número N, y muestre por pantalla todos los enteros entre 0 y N
//	que sean pares.
	
	public static void MostrarParesEntre0YNumeroElegido (int num) {
		for (int i = 0; i<=num;i++) {
			if (i%2==0) {
				System.out.println(i);
			}
		}
	}
	
//	h. Reciba un número N, y retorne la sumatoria desde 0 a N.
	public static int RetornarSumatoriaHastaN (int n) {
		int sumatoria = 0;
		for (int i = 0; i <= n; i++) {
			
			System.out.println("Sumatoria: " + sumatoria + "+" +  i + " = " + (sumatoria + i));
			sumatoria += i;
			
		}
		
		return sumatoria;
		
	}
	
//	i. Reciba un número N, y retorne la suma de sus dígitos
	public static int SumarDigitosDeUnNumero (int num) {
		int suma = 0;
		int resto =0;
		
		
		
		do {
			resto = num % 10;
			num = num / 10;
			suma +=resto;
			
		}while (num != 0);
		
		return suma;
	}
	
//	j. Determine si, dado un número N = dm,dm-1, ..., d1 y un dígito d, d=di para
//			1<= i <= m
	
	
//	k. Determine si un número dado es primo.
	
	public static void EsPrimo(int num) {
		int resto;
		Boolean esPrimo = true;
		
		if (num < 2) {
	        System.out.println("El número " + num + " NO es primo");
	        return;
	    }
		for (int i = num -1;i > 1; i--) {
			resto = num % i;
			if (resto == 0) {
				esPrimo = false;
				break;
			}
		}
		if (esPrimo) {
			System.out.println("El número " + num + " es primo");
		}
		else {
			System.out.println("El número " + num + " NO es primo");
		}
			
	}
	
//	l. Determine si un número dado es perfecto; un número es perfecto si la suma de los divisores del número
//	(incluyendo al 1 y excluyendo al número) es igual al número.
//	Ej.: suma de divisores de 6 =>1 + 2 + 3 = 6 => es perfecto
	
	public static boolean EsPerfecto (int num) {
		int suma = 1;
		
		for (int i = 2; i<num; i++) {
			if (num % i == 0) {
				suma += i;
			}else if (suma > num) {
				return false;
			}
		}
		
		return suma == num;
	}

}
