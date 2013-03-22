package Bucles_Iniciales;

import java.util.Scanner;

public class Ej26 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int num;
		int cont=0;
		int i=0;
		
		
		while(i<5)
		{
			System.out.println("Introduzca un numero");
			num=sc.nextInt();
			if(num>0 && num%5==0)
			{
				i++;
				if( num%3==0)
				{
					cont++;
				}
			}
		}
		
		System.out.println("Hay "+cont+" multiplos de 3 que ademas son multiplos de 5 y positivos");
		
	}

}
