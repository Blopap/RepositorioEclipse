package Tema5;

import java.util.Random;

public class ordenarArrayAleatorio {
	
	public static void ordenarArrayMenMay(double v[] )
	{
		double num;
		int total,j;
		total=v.length;
		
		for(int i=0;i<total-1;i++)
		{
			j=1;
			while(j<total)
			{
				if(v[j-1]>v[j])
				{
					num=v[j-1];
					v[j-1]=v[j];
					v[j]=num;
				}
				j++;
			}
		}
	}
	public static void ordenarArrayMayMen(double v[] )
	{
		double num;
		int total,j;
		total=v.length;
		
		for(int i=0;i<total-1;i++)
		{
			j=1;
			while(j<total)
			{
				if(v[j-1]<v[j])
				{
					num=v[j-1];
					v[j-1]=v[j];
					v[j]=num;
				}
				j++;
			}
		}
	}
	public static void mostrarArray(double v[])
	{
		int tot=v.length;
		System.out.print("[ ");
		for(int i=0;i<tot;i++)
		{
			System.out.print(v[i]+" ");
		}
		System.out.println("]");
		
	}
	public static void main(String [] args)
	{
		double v[]=new double[10];
		Random rd=new Random();
		
		for(int i=0;i<10;i++)
		{
			v[i]=Math.round(rd.nextDouble()*10000);
		}
		mostrarArray(v);
		
		ordenarArrayMenMay(v);
		
		mostrarArray(v);
		
		ordenarArrayMayMen(v);
		
		mostrarArray(v);
		
		
		
		
	}

}
