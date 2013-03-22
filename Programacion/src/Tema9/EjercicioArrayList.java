package Tema9;

import java.util.ArrayList;

import rutinas.Rutinas;

public class EjercicioArrayList {
	
	public static void main(String [] args)
	{
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for (int i=0;i<100;i++)
		{
			al.add(Rutinas.generaaleatorio(1, 1000));
		}
		
		System.out.println(al.toString());
		
		al.add(5, 2000);
		
		System.out.println(al.toString());
		
		if(al.contains(50))
		{
			al.remove(al.indexOf(50));
			System.out.println("Numero 50 eliminado");
		}
		else System.out.println("Numero 50 no encontrado");
		
		System.out.println(al.toString());
		
		al.remove(7);
		
		System.out.println("Elemento en la posicion 7 eliminado");
		
		for(int i=0;i<al.size();i++)
		{
			if(al.get(i)%2!=0)
			{
				System.out.print(al.get(i)+" ");
			}
		}
		System.out.println();
		
		if(al.contains(15))
		{
			System.out.println("Posicion del numero 15: "+al.indexOf(15));
		}
		else System.out.println("Numero 15 no encontrado");
		
		
		int[] lista= new int[al.size()];
		int tamaño=0;
		
		for(int i=0;i<al.size();i++)
		{
			lista[i]=al.get(i);
			tamaño++;
		}
		
		for(int i=0;i<tamaño;i++)
		{
			System.out.print(lista[i]+" ");
		}
		System.out.println();
		
		
		
		
		
		
	}

}
