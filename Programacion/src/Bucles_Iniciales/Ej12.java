package Bucles_Iniciales;

import java.util.Scanner;

public class Ej12 {
	public static void main (String [] args)
	{
		int n, max, min,posmax,posmin,i;
		
		max=0;
		min=100;
		
		i=0;
		posmax=0;
		posmin=0;
		
		System.out.println("Introduzca un numero: ");
		Scanner sc= new Scanner(System.in);
		
		n=sc.nextInt();
		
		while( n!=-1)
		{
			i++;
			if(n>0 && n%2==0 && n<100)
			{			
				if(n>max)
				{
					max=n;
					posmax=i;
					if (min>max)
					{
						min=max;
					}
				}
				if(n < min)
				{
					min=n;
					posmin=i;
				}
			}
			System.out.println("Introduzca un numero: ");
			n=sc.nextInt();
		}
		
		System.out.println("El numero maximo de la serie es: "+max+" ,su posicion es: "+posmax+" y el numero minimo de la serie es: "+min+" su posicion es: "+posmin);
		
	}

}
