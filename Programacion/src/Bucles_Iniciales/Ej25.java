package Bucles_Iniciales;

import java.util.Scanner;

public class Ej25 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int num, suma;
		
		suma=0;
		
		System.out.println("Introduzca un numero");
		num=sc.nextInt();
		
		while(num!=0)
		{
			suma=suma+num;
			
			System.out.println("Introduzca un numero");
			num=sc.nextInt();
		}
		
		System.out.println("La suma es: "+suma);
	}
	

}
