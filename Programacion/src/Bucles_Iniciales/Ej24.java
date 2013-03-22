package Bucles_Iniciales;

import java.util.Scanner;

public class Ej24 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int num;
		
		
		System.out.println("Introduzca un numero");
		num=sc.nextInt();
		while(num<=0)
		{
			num=sc.nextInt();
		}
		for(int i=1;i<=num;i++)
		{
			System.out.print(i*i+" ");
		}
		
	}

}
