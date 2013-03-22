package Bucles_Iniciales;

public class Ej23 {
	public static void main(String [] args)
	{
		boolean i=false;
		
		int num=999999;
		
		while(num>100000 && i)
		{
			if(num%3!=0)
			{
				System.out.println(num);
				i=false;
			}
			num=num-2;
		}
		System.out.println("Fin");
	}

}
