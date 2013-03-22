/* Dados 101 numeros aleatorios entre 10 y 100 escribir
 * aquellos que sean mayores que el introducido en la
 * posicion central
 */

package EjerciciosVarios;

import java.util.Random;

public class Ej5 {
	
	public static int v[]=new int[101];
	
	
	
	public static void crearVectorAleatorio()
	{
		Random rd=new Random();
		for(int i=0;i<101;i++)
		{
			v[i]=rd.nextInt();
			System.out.print( v[i]+" ");
		}
	}
	
	public static int obtenerCentral()
	{		
		return v[(v.length-1)/2];
	}
	
	public static void mostrarMayores(int num)
	{
		for (int i=0;i<v.length;i++)
		{
			if(v[i]>num)
			{
				System.out.println(v[i]+" ");
			}
		}
	}
	public static void main(String [] args)
	{
		crearVectorAleatorio();
		mostrarMayores(obtenerCentral());
	}
	
	
}
