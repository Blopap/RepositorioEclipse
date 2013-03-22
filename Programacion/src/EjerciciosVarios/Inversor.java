package EjerciciosVarios;

import java.util.Scanner;

public class Inversor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int list[]=new int[10];
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Introduzca un numero");
			list[i]=sc.nextInt();
		}
		
		for(int j=list.length;j>0;j--)
		{
			System.out.print(list[j-1]+" ");
		}
		

	}

}
