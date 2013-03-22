package Tema9;

import java.io.File;
import java.util.Vector;
import rutinas.Rutinas;

public class Ejercicio4 {
	
	public static void main(String [] args)
	{
		String dir=Rutinas.leeString("Introduzca la direccion del directorio");
		
		String ext=Rutinas.leeString("Introduzca extension");
		
		Vector<String> v=obtenerFicherosBuscados(dir,ext);
		
		System.out.println(v.toString());
		
	}
	private static boolean comprobarExtension(File f,String ext)
	{
		
		if(f.isFile())
		{
			int n=f.toString().length();
			if(f.toString().substring(n-ext.length(), n).equals(ext))
			{
				return true;
			}
		}
		
		return false;
	}
	private static Vector<String> obtenerFicherosBuscados(String dir,String ext)
	{
		Vector<String> v=new Vector<String>();
		
		File f=new File(dir);
		
		if(f.isDirectory())
		{
			File[] vf= f.listFiles();
			
			for(int i=0;i<vf.length-1;i++)
			{
				if(comprobarExtension(vf[i],ext))
				{
					v.add(vf[i].getName());
				}
			}
			
		}
		else
		{
			System.out.println("Directorio no encontrado");
		}
		return v;
	}

}
