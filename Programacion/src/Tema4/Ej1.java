package Tema4;

import java.util.Scanner;

public class Ej1 {
	public static void main(String [] args)
	{
		try{
			Scanner sc=new Scanner(System.in);
			int inicio,fin;
				
			System.out.println("Introduzca un numero");
			inicio=sc.nextInt();
			System.out.println("Introduzca otro numero");
			fin=sc.nextInt();
			
			while(inicio>fin)
			{
				System.out.println("Inicio "+inicio);
				System.out.println("Div "+10/inicio);
				inicio--;
			}
			
		}
		catch(ArithmeticException e)
		{
			System.out.println("Division por cero");
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Formato de numero incorrecto");
			e.printStackTrace();
		}
		
		
		
	}

}
