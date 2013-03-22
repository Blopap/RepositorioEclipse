/* Pedir numeros enteros hasta que nos den 0 
 * almacenandolos en un vector con un maximo 
 * de 100 elementos.
 * Comprobar antes de introducir en el vector
 *  que ese numero no existia.
 */

package EjerciciosVarios;

import java.util.Scanner;

public class Ej6 {
	
	public static int v[]= new int[100];
	public static int tam=0;
	
	public static boolean compruebaExistencia(int num)
	{
		boolean esta=false;
		for (int i=0;i<tam;i++)
		{
			if(!esta && v[i]==num)
			{
				esta=true;
			}
		}
		return esta;
	}
	public static void pedirNum()
	{
		Scanner sc=new Scanner(System.in);
		int num;
		do{
			System.out.println("Introduzca un numero");
			num=sc.nextInt();
			if(!compruebaExistencia(num))
			{
				v[tam]=num;
				tam++;
			}
		}while(num!=0 && tam<10);
		
	}
	public static void mostrar()
	{
		for (int i=0;i<tam;i++)
		{
			System.out.print(v[i]+" ");
		}
	}
	public static void main(String [] args)
	{
		pedirNum();
		mostrar();
	}

}
