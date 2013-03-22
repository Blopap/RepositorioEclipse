/*Calcular el volumen de un cilindro y el de una esfera previa 
 * introducci�n de la altura y radio del cilindro, as� como del
 *  radio de la esfera. Se definir� un m�todo para el c�lculo 
 *  del volumen del cilindro y otro para el de la esfera. 
 *  Se emplear�n m�todos est�ticos de la clase Math y la 
 *  variable de campo est�tica que almacena el valor de pi.
 */

package Tema3;

import java.util.Scanner;

public class Ej5 {
	public static double PI=Math.PI;
	public static double calcularCirculo(double radio)
	{
		return PI*Math.pow(radio,2);
	}
	
	public static double calcularVolumenCilindro(double altura,double radio)
	{
		return altura*calcularCirculo(radio);
	}
	public static double calcularVolumenEsfera(double radio)
	{
		return (4/3)*PI*Math.pow(radio, 3);
	}
	
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		
		double radC,altC,radE;
		
		System.out.println("Introduzca la altura de un cilindro");
		altC=sc.nextDouble();
		System.out.println("Introduzca el radio de un cilindro");
		radC=sc.nextDouble();
		
		System.out.println("El volumen del cilindro es: "+calcularVolumenCilindro(altC,radC));
		System.out.println();
		
		System.out.println("Introduzca el radio de una esfera");
		radE=sc.nextDouble();
		
		System.out.println("El volumen de la esfera es: "+calcularVolumenEsfera(radE));
	}

}
