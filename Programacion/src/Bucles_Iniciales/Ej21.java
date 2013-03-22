package Bucles_Iniciales;

import java.util.Scanner;

public class Ej21 {
	
	public static void main(String [] args)
	{
		
		int num;
		boolean i=true;
		
		
		Scanner sc=new Scanner(System.in);
		
		while(i)
		{
			System.out.println("Introduzca un numero");
			do{
				num=sc.nextInt();
				if(num==0)
				{
					i=false;
				}
			}while(num<1 && num>10 && i);
			if(i)
			{
				System.out.println("El cuadrado de "+num+" es "+num*num);
			}
		}
		System.out.println("Fin de programa");
	}
	
}
