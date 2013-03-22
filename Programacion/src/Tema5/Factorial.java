package Tema5;

import java.util.Scanner;

public class Factorial {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int num;
		long n=1;
		
		
		System.out.println("Introduzca un numero para calcular su factorial");
		num=sc.nextInt();
		
		int v[]=new int[num];
		
		for(int i=0;i<num;i++)
		{
			v[i]=i+1;
		}
		
		for(int i=1;i<num;i++)
		{
			n=n*v[i];
		}
		
		System.out.println(n);
		
		
		
	}
}
