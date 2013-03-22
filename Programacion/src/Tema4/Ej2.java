package Tema4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej2 {
	
	public static void main(String [] args) throws IOException
	{
		try {
			Scanner sc = new Scanner(System.in);
			int total, positivos, negativos, rep, num;
			total = 0;
			positivos = 0;
			negativos = 0;
			System.out.println("Introduzca el numero de numeros a sumar");
			rep = sc.nextInt();
			int i = 0;
			while (i < rep) {
				System.out.println("Introduzca un numero");
				num = sc.nextInt();
				total = total + num;
				if (num > 0) {
					positivos = positivos + num;
				} else {
					negativos = negativos + num;
				}
				i++;
			}
			
			System.out.println("Total: " +total);
			System.out.println("Positivos: "+positivos);
			System.out.println("Negativos: "+negativos);
			
		} catch (InputMismatchException e) {
			System.out.println("No es un numero");
		}
		
	}

}
