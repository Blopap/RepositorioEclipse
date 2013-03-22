package Tema9;

import java.util.Vector;

public class Ejercicio1 {
	
	public static void main(String [] args)
	{
		StringBuffer sb=new StringBuffer("Hola caracola");
		
		System.out.println("La StringBuffer es: "+sb);
		
		System.out.println("Capacidad: "+sb.capacity()+" Longitud: "+sb.length());
		
		sb.setCharAt(0,'B');
		
		System.out.println(sb);
		
		sb.append(5000);
		
		sb.append("cucu");
		
		System.out.println(sb);
		
		sb.insert(9, "bonita");
		
		System.out.println(sb);
		
		sb.delete(0, 3);
		
		System.out.println(sb);
		
		String s=sb.substring(sb.length()-4);
		
		System.out.println(s);
		
		System.out.println("Capacidad: "+sb.capacity()+" Longitud: "+sb.length());
		
		Vector<StringBuffer> v=new Vector<StringBuffer>();
		
		v.add(new StringBuffer("Pablo"));
		v.add(new StringBuffer("Amilburu"));
		v.add(new StringBuffer("Fontecha"));
		
		System.out.println(v.toString());
		
		
	}

}
