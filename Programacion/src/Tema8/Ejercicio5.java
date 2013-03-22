package Tema8;

import java.io.File;

public class Ejercicio5 {
	
	public static void main(String [] args)
	{
	
		File f1= new File("carpeta1");
		
		if(f1.exists())//Comprueba que el fichero existe
		{
			if(f1.isDirectory())//Comprueba que el fichero es una carpeta
			{				
				mostrarContenido(f1);//Muestra el contenido de la carpeta
				
				File[] listaf=f1.listFiles();//obtiene una lista con los ficheros
				
				for(int i=0;i<listaf.length;i++)//recorre la lista de ficheros
				{
					if(listaf[i].isFile())//si es un fichero lo elimina
					{
						listaf[i].delete();
					}
					else if(listaf[i].isDirectory() && listaf[i].listFiles().length==0)//Si es una carpeta, comprueba si esta vacio y si es asi, lo elimina.
					{
						listaf[i].delete();
					}
				}
				
				System.out.println();
				
				mostrarContenido(f1);//muestra el contenido de la carpeta
				
			}
		}
	
	}

	public static void mostrarContenido(File f)
	{	
		File[] listaf=f.listFiles(); //obtiene una lista con los ficheros
		for(int i=0;i<listaf.length; i++) //muestra por pantalla el nombre de cada fichero de la lista
		{
			System.out.println(listaf[i].toString());
		}
	}

}
