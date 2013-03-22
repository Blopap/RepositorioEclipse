package Bucles_Iniciales;
public class Ej13 {
	public static void main(String [] args)
	{
		int i,mayor,menor,numd;
		i=0;
		
		
		System.out.println("Los numeros primos hasta 1000 son: ");
		System.out.print("1 2 3");
		
		for( i=6;i<=1000;i=i+6)
		{
			menor=i-1;
			numd=0;
			for( int d=2;d<=menor/2;d++)
			{
				if(menor%d==0)
				{
					numd++;
				}
			}
			if (numd==0)
			{
				System.out.print(" "+menor);
			}
			mayor=i+1;
			numd=0;
			int d=2;
			while(d<=mayor/2 && numd==0)
			{
				if(mayor%d==0)
				{
					numd++;
				}
				d++;
			}
			if(numd==0)
			{
				System.out.print(" "+mayor);
			}
			
		}		
	}

}
