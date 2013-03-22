package Bucles_Iniciales;

import java.util.Scanner;

public class Ej16 {
	
	public static void main(String [] args)
	{
		boolean creciente;
		
		int num,suma,ant;
		
		ant=0;
		suma=0;
		creciente=true;
		
		Scanner sc=new Scanner(System.in);
		
		for (int i=0;i<10;i++)
		{
			System.out.println("Introduzca un numero");
			
			do
			{
				num=sc.nextInt();
			}while(num<0);
			if(num<ant)
			{
				creciente=false;
			}
			suma=suma+num;
			ant=num;
		}
		
		System.out.println("La suma de los numeros es: "+suma);
		if(creciente)
		{
			System.out.println("La serie es creciente");
		}
		else
		{
			System.out.println("La serie no es creciente");
		}
	}

}
