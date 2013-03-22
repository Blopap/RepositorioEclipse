package EjerciciosVarios;

import java.util.Scanner;

public class Maximo {
	
	public static int[] leerNum()
	{
		int v[]=new int[100];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<8;i++)
		{
			System.out.println("Introduzca un numero");
			do{
				v[i]=sc.nextInt();
			}while (v[i]<0);
		}
		return v;
	}
	public static int obtenerMaximo(int v[])
	{
		int max=0;
		for( int i=v.length-1;i>=0;i--)
		{
			if(max<v[i])
			{
				max=v[i];
			}
		}
		return max;
	}
	public static void main(String [] args)
	{
		int vec[]= new int[100];
		
		vec=leerNum();
		System.out.println("El numero maximo es: "+obtenerMaximo(vec));
	}

}
