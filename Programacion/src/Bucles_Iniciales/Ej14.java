package Bucles_Iniciales;

public class Ej14 {
	public static void main(String [] args)
	{
		int n,cont,resto,inv,num;
		
		n=10000;
		cont=0;
		
		while(cont <10 && n<99999)
		{
			if(n%3!=0)
			{
				num=n;
				inv=0;
				while(num!=0)
				{
					resto=num%10;
					inv=inv*10+resto;
					num=num/10;
				}
				if(n==inv)
				{
					System.out.print(n+" ");
					cont++;
				}
			}
			n=n+1;
		}
		
//		for(int i=100;i<=999;i++) //Capicua de tres cifras
//		{
//			if(i%10==i/100)
//			{
//				System.out.print(i+" ");
//			}
//		}
		
	}

}
