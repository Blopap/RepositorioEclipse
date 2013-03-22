package Bucles_Iniciales;

public class Ej6 {
	public static void main (String [] args)
	{
		double num=0;
		int f;
		for (int i=1;i<100;i++)
		{
			f=2*i;
			
			num=num+(1/f);
		}
		
		System.out.println("El numero es: "+num);
	}
}
