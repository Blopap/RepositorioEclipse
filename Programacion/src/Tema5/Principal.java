package Tema5;

import java.util.Scanner;

public class Principal {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		
		
//		Cuadrado rectangulo=new Cuadrado(5,6);
//		Cuadrado cuadrado=new Cuadrado(5);
//		
//		System.out.println("Area del rectangulo: "+rectangulo.area());
//		System.out.println("Area del rectangulo: "+cuadrado.area());
//		
//		System.out.println("Introduzca el aumento que desea en %");
//		int por;
//		por=sc.nextInt();
//		
//		cuadrado.aumentarMismo(por);
//		System.out.println("Area del rectangulo: "+cuadrado.area());
//		
//		Cuadrado cuad;
//		cuad=rectangulo.aumentarConNuevo(por);
//		
//		System.out.println("Area del rectangulo: "+cuad.area());
//		System.out.println("Area del rectangulo: "+rectangulo.area());
		
		float u,l;
		
		System.out.println("Introduzca el numerador");
		u=sc.nextFloat();
		System.out.println("Introduzca el denominador");
		l=sc.nextFloat();
		
		
		Quebrado a1=new Quebrado(u,l);
		
		System.out.println("Introduzca el numerador");
		u=sc.nextFloat();
		System.out.println("Introduzca el denominador");
		l=sc.nextFloat();
		
		Quebrado a2=new Quebrado(u,l);
		
		Quebrado a3=new Quebrado();
		
		a3=a1.suma(a2);
		
		System.out.println("Suma: "+a3.toString());
		
		a3=a1.resta(a2);
		
		System.out.println("Resta: "+a3.toString());
		
		a3=a1.multiplicacion(a2);
		
		System.out.println("Multiplicacion: "+a3.toString());
		
		a3=a1.division(a2);
		
		System.out.println("Division: "+a3.toString());
		
		
		
		
		
	}

}
