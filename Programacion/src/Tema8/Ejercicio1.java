package Tema8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import rutinas.Rutinas;

public class Ejercicio1 {
	
	public static Vector<Integer> leerFichero(String nombre)
	{
		Vector<Integer> v=new Vector<Integer>();
		
		try {
			
			FileInputStream fis = new FileInputStream(nombre);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			int rbyte=0;
			
			while((rbyte=bis.read()) !=-1)
			{
				v.add(rbyte);
			}
			
			bis.close();
			fis.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return v;
		
	}
	
	public static Vector<Integer> obtenerCaracteresImprimibles(Vector<Integer> v)
	{
		int cap=v.size();
		Vector<Integer> c=new Vector <Integer>();
		int n;
		
		for( int i=0;i<cap;i++)
		{
			n=(Integer) v.get(i);
			if(n == 13 || n >= 65 && n <=90 || n >=97 && n <=122)
			{
				c.add(n);
			}
		}
		
		return c;
	}
	
	public static void escribirCaracteres(Vector<Integer> c,String fichtext)
	{
		try {
			FileWriter fw=new FileWriter(fichtext);
			BufferedWriter bw= new BufferedWriter(fw);
			
			int cap=c.size();
			
			for(int i=0;i<cap;i++)
			{
				bw.write((Integer) c.get(i));
			}
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostarFich(String nom)
	{
		
		try {
			
			FileInputStream fis = new FileInputStream(nom);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			int rbyte=0;
			
			while((rbyte=bis.read()) !=-1)
			{
				System.out.print( rbyte+" ");
			}
			System.out.print("\n");
			
			
			
			bis.close();
			fis.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearFich(String nom)
	{
		File f=new File(nom);
		
		try {
			if(!f.exists())
			{
				f.createNewFile();
			}
			else
			{
				System.out.println("El fichero ya existe. ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearFichBytesAleatorio(String nom,int min, int max)
	{
		try {
			FileOutputStream fos=new FileOutputStream(nom);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			for(int i=0;i<1000;i++)
			{
				bos.write(Rutinas.generaaleatorio(min, max));
			}
			bos.flush();
			
			bos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static void eliminarFichero(String nom)
	{
		File f=new File(nom);
		
		
		
		if(f.exists())
		{
			String s= Rutinas.leeString("Seguro que desea eliminar "+nom+"???");
			
			if(s.substring(0, 1).toUpperCase().equals("S"))
			{
				s= Rutinas.leeString("Esta completamente seguro que desea eliminar "+nom+"???");
				if(s.substring(0, 1).toUpperCase().equals("S"))
				{
					if(f.delete())
					{
						System.out.println("Fichero borrado correctamente");
					}
				}
				else
				{
					System.out.println("El fichero NO ha sido borrado. ");
				}
			}
			else
			{
				System.out.println("El fichero NO ha sido borrado. ");
			}
				
		}
		else
		{
			System.out.println("El fichero no existe. ");
		}
	}
	
	public static void main(String[] args)
	{
		
		String fb=Rutinas.leeString("Introduzca el nombre del fichero de bytes");
		
		String ft=Rutinas.leeString("Introduzca el nombre del fichero de texto");
		
		crearFich(fb);
		
		crearFich(ft);
		
		crearFichBytesAleatorio(fb,0,255);
		
		escribirCaracteres(obtenerCaracteresImprimibles(leerFichero(fb)) ,ft);
		
		mostarFich(ft);
		
		eliminarFichero(fb);
	}

}
