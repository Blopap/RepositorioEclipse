package Bucles_Iniciales;

import java.util.Scanner;

public class EJER {
	public void main(String [] args)
	{
		int num;
		
		Scanner sc=new Scanner(System.in);
		
		do
		{
			System.out.println("Introduzca un numero");
			num=sc.nextInt();
		}while(num<0);
		
		
		for (int i=1;i<=100;i++)
		{
			if(i%2==0)
			{
				System.out.print(" -"+i);
			}
			else
			{
				System.out.print(" "+i);
			}
		}
	}
}
