package Tema9;

import java.util.Vector;

public class Ejercicio3 {
	
	public static void main(String [] args)
	{
		Vector<String> v=new Vector<String>();
		
		v.add("Jupiter");
		v.add("Marte");
		v.add("Mercurio");
		v.add("Neptuno");
		v.add("Pluton");
		v.add("Saturno");
		v.add("Tierra");
		v.add("Urano");
		v.add("Venus");
		
		System.out.println("Capacidad: "+v.capacity()+" Longitud: "+v.size());
		
		if(v.contains("Saturno"))
		{
			System.out.println("La posicion de Saturno es: "+v.indexOf("Saturno"));
		}
		
		System.out.println("Primer elemento: "+v.firstElement());
		System.out.println("Ultimo elemento: "+v.lastElement());
		
		StringBuffer log=new StringBuffer("Logroño");
		
		v.add(v.indexOf("Tierra"), log.toString());
		
		System.out.println("Capacidad: "+v.capacity()+" Longitud: "+v.size());
		
		Integer edad=new Integer(23);
		
		v.add(edad.toString());
		
		System.out.println(v.toString());
		
		v.removeAllElements();
		
		System.out.println("Capacidad: "+v.capacity()+" Longitud: "+v.size());
		
	}
	

}
