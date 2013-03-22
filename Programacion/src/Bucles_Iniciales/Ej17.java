package Bucles_Iniciales;

public class Ej17 {
	
	public static void main (String [] args)
	{
		int i,num,suma;
		
		i=0;
		suma=0;
		num=4;
		
		while(i<100)
		{
			num++;
			if(num%4==0 && num%3==0)
			{
				System.out.print(num+" ");
				suma=suma+num;
				i++;
			}
		}
		System.out.println("\nLa suma es: "+suma);
		
	}

}
