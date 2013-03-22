package artistasObras.AOGv2Nofunciona;

import java.util.Vector;

import rutinas.RutinasAOG;

public class VectorGrupos {
	private Vector<Grupo> grupos;
	
	public VectorGrupos()
	{
		setVectorGrupo(new Vector<Grupo>());
	}
	public VectorGrupos(Vector<Grupo> aux)
	{
		setVectorGrupo(aux);
	}
	
	public void setVectorGrupo(Vector<Grupo> aux)
	{
		this.grupos=aux;
	}
	
	public void anyadirGrupo(Grupo g)
	{
		this.grupos.add(g);
	}
	
	public void eliminarGrupo(Grupo g)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<grupos.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
		{
			if(grupos.get(pos).equals(g))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		
		if(encontrado)
		{
			grupos.remove(pos);
			System.out.println("Grupo: "+g.getIdGrupo()+" eliminado");
			
		}
		else System.out.println("Grupo: "+g.getIdGrupo()+" no encontrado.");
	}
	
	public Grupo obtenerGrupo(String id)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<grupos.size())
		{
			if(grupos.get(pos).getIdGrupo().equals(id))//Busca la posicion del elemento cuya identificador sea id.
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return grupos.get(pos);
	}
	
	public boolean comprobarId(String Id)
	{
		for (int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).getIdGrupo().equals(Id))//Comprueba que el Id del grupos se encuentre en el vector grupos
			{
				return true;//Devuelve true si el grupo se encuentra en el vector.
			}
		}
		
		return false;
	}
	
	
	public String listarIds()
	{
		String cadena="";
		
		for(int i=0;i<grupos.size();i++)
		{
			cadena+=grupos.get(i).getIdGrupo()+" ";
		}
		cadena+= "\n";
		
		return cadena;
	}
	
	public String listarIdArtistas(int pos)
	{
		return grupos.get(pos).listarIdsArtistas();
	}
	
	public String listarIdObras(int pos)
	{
		return grupos.get(pos).listarIdsArtistas();
	}
	
	
	
	public String toString()
	{
		String cadena="";
		
		for( int i=0;i<grupos.size();i++) //Muestra el vector
		{
			cadena+= grupos.get(i).toString();
		}
		
		return cadena;
	}
	
	public void anyadirArtista(Artista ar,int pos)
	{
		grupos.get(pos).anyadirArtista(ar);
	}
	
	public void anyadirObra(Obra o,int pos)
	{
		grupos.get(pos).anyadirObra(o);
	}
	
	public void eliminarArtista(Artista ar,int pos)
	{
		grupos.get(pos).eliminarArtista(ar);
	}
	
	public void eliminarObra(Obra o, int pos)
	{
		grupos.get(pos).eliminarObra(o);
	}
	
	public void porcentajesPorDefecto(int pos)
	{
		grupos.get(pos).porcentajesDefecto();
	}
	
	
	
	public void eliminarObraGrupos(Obra o)//Elimina todas las Obras o de los grupos.
	{
		for( int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).estaObra(o))
			{
				grupos.get(i).eliminarObra(o);
			}
		}
	}
	
	public void eliminarArtistasGrupos(Artista a) //Elimina todas los Artistas A de los grupos.
	{
		for( int i=0;i<grupos.size();i++)
		{
			if(grupos.get(i).estaArtista(a))
			{
				grupos.get(i).eliminarArtista(a);
			}
		}
	}
	
	public int posicionDelGrupo(String id)
	{
		int pos=0;
		boolean encontrado=false;
		while(!encontrado)
		{
			if(grupos.get(pos).getIdGrupo().equals(id))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return pos;
	}
	
	public boolean vacio()
	{
		return grupos.isEmpty();
	}
	
	public boolean tieneArtistas(int pos)
	{
		return grupos.get(pos).tieneArtistas();
	}
	
	public boolean tieneObras(int pos)
	{
		return grupos.get(pos).tieneObras();
	}
	
	
	
	

}
