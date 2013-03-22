/*Realizar un programa Java compuesto de una clase p�blica de 
 * nombre AdivinarNumero que contenga s�lo al m�todo main. 
 * Su objetivo ser� permitir que el usuario averig�e un n�mero 
 * entero generado aleatoriamente y comprendido entre [0,100] 
 * que se almacenar�, dentro del c�digo del programa, en una 
 * variable int a la que se llamar� numero.

El programa pedir� un n�mero por teclado e informar� de si el 
n�mero que introduce el usuario es mayor o menor que el que 
se trata de averiguar. Si no se acierta a la primera, no importa
porque tiene que dejar introducir n�meros de forma ininterrumpida. 
Cuando el usuario acierte, se mostrar� un mensaje de felicitaci�n
 y el n�mero de intentos empleados. A tener en cuenta: 

    Si el usuario introduce un numero no comprendido entre [0,100], el programa mostrar� un mensaje informativo 

    Si el usuario teclea asterisco, el programa deber� finalizar 

    La generaci�n aleatoria del n�mero a adivinar se realizar� con
     el m�todo est�tico �void random()� de java.lang.Math. 
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
