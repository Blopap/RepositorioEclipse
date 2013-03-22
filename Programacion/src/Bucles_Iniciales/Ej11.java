package Bucles_Iniciales;
import java.util.Scanner;

public class Ej11 {
	public static void main (String [] args)
	{
		int n=0;
		
		int a=1;
		int b=0;
		int c=0;
		
		System.out.println("Introduzca un numero");
		Scanner sc= new Scanner(System.in);
		
		n=sc.nextInt();
		
		if(n>=10)
		{
			while (c < n)
			{
				System.out.print(c+" ");
				c=a+b;
				a=b;
				b=c;
				
			}
		}
		
	}
}
