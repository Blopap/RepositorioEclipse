package rutinas;

import artistasObras.Artista;
import artistasObras.Grupo;
import artistasObras.Obra;
import artistasObras.PrincipalAOG;

public class RutinasAOG {
	
	public static Grupo leerGrupo()
	{
		
		String id=Rutinas.leeString("Introduzca numero Identificador del grupo: ");
		String nom=Rutinas.leeString("Introduzca Nombre del grupo: ");
		
		return new Grupo(id,nom);	
	}
	
	public static Obra leerObra()
	{
		String id=Rutinas.leeString("Introduzca numero Identificador de la obra: ");
		String nom=Rutinas.leeString("Introduzca Nombre de la obra: ");
		double com=Rutinas.leeDouble("Introduzca la comision de la obra: ");
		
		return new Obra(id,nom,com);
	}
	public static Artista leerArtista()
	{
		String id=Rutinas.leeString("Introduzca numero Identificador del artista: ");
		String nom=Rutinas.leeString("Introduzca Nombre del artista: ");
		
		return new Artista(id,nom);
	}
	
	public static boolean deseaEliminar(String cad)
	{
		if(Rutinas.leeBooleano("Desea eliminar "+cad+"?"))
		{
			if(Rutinas.leeBooleano("Esta seguro de eliminar "+cad+"?"))
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public static String leerIdGrupo(String cadena)
	{
		String id=Rutinas.leeString(cadena);
		while(!PrincipalAOG.comprobarIdG(id)) //Lee un identificador y comprueba existe un grupo con ese identificador
		{
			id=Rutinas.leeString("No existe el identificador: "+id+" Por favor introduzca otro.");
		}
		return id;
	}
	
	public static String leerIdObra(String cadena)
	{
		String id=Rutinas.leeString(cadena);//Lee un identificador y comprueba existe una obra con ese identificador
		while(!PrincipalAOG.comprobarIdO(id))
		{
			id=Rutinas.leeString("No existe el identificador: "+id+" Por favor introduzca otro.");
		}
		return id;
	}
	public static String leerIdArtista(String cadena)
	{
		String id=Rutinas.leeString(cadena);
		while(!PrincipalAOG.comprobarIdA(id))//Lee un identificador y comprueba existe un artista con ese identificador
		{
			id=Rutinas.leeString("No existe el identificador: "+id+" Por favor introduzca otro.");
		}
		return id;
	}
	
	
}
