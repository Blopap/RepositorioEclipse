package Bucles_Iniciales;

import java.util.Scanner;

public class Ej22 {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int num;
		System.out.println("Introduzca un numero");
		do{
			num=sc.nextInt();
		}while(num<0 && num>10);
		
		for(int i=num*10;i<num*10+10;i++)
		{
			System.out.print(i+" ");
		}
		
//		for (int i=10;i<100;i++)
//		{
//			if(i/10==num)
//			{
//				System.out.print(i+" ");
//			}
//		}
		
	}

}
