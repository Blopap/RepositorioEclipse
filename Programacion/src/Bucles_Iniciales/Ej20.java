package Bucles_Iniciales;

import java.util.Scanner;

public class Ej20 {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int num;
		int div,rest;
		
		System.out.println("Introduzca un numero: ");
		do{
			num=sc.nextInt();
		}while(num<0 && num>80);
		
		div=num/4;
		rest=num%4;
		
		System.out.println(div+" "+rest);
		for(int i=0;i<div;i++)
		{
			System.out.print("****+");
		}
		for(int i=0;i<rest;i++)
		{
			System.out.print("*");
		}
		
	}
	

}
