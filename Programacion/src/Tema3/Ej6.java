/*Realizar un programa Java compuesto de una clase pública de 
 * nombre AdivinarNumero que contenga sólo al método main. 
 * Su objetivo será permitir que el usuario averigüe un número 
 * entero generado aleatoriamente y comprendido entre [0,100] 
 * que se almacenará, dentro del código del programa, en una 
 * variable int a la que se llamará numero.

El programa pedirá un número por teclado e informará de si el 
número que introduce el usuario es mayor o menor que el que 
se trata de averiguar. Si no se acierta a la primera, no importa
porque tiene que dejar introducir números de forma ininterrumpida. 
Cuando el usuario acierte, se mostrará un mensaje de felicitación
 y el número de intentos empleados. A tener en cuenta: 

    Si el usuario introduce un numero no comprendido entre [0,100], el programa mostrará un mensaje informativo 

    Si el usuario teclea asterisco, el programa deberá finalizar 

    La generación aleatoria del número a adivinar se realizará con
     el método estático “void random()” de java.lang.Math. 
    */
package Tema3;

import java.util.Scanner;
import java.util.Random;

public class Ej6 {
	
	public static void main(String []args)
	{
		Random rd=new Random();
		int random=rd.nextInt(100);
		int cont=1;
		
		int num=0;
		Scanner sc=new Scanner(System.in);
		
		
		while(num!=-1 || num>0 && num<100)
		{
			System.out.println("Introduce un numero o introduce -1 para salir");
			num=sc.nextInt();
			if(num==random)
			{
				System.out.println("Has acertado despues de "+cont+" intentos");
				num=-1;
			}
			else if(num>random)
			{
				System.out.println("El numero buscado es menor");
			}
			else
			{
				System.out.println("El numero buscado es mayor");
			}
			cont++;

		}
		
	}

}
