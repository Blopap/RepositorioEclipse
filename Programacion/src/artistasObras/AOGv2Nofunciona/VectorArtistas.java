package artistasObras.AOGv2Nofunciona;

import java.util.Vector;

public class VectorArtistas implements java.io.Serializable {
	private Vector<Artista> artistas;
	
	public VectorArtistas()
	{
		setVectorArtista(new Vector<Artista>());
	}
	
	public VectorArtistas(Vector<Artista> aux)
	{
		setVectorArtista(aux);
	}
	
	public void setVectorArtista(Vector<Artista> aux)
	{
		this.artistas=aux;
	}
	
	public Vector<Artista> getVectorArtista()
	{
		return this.artistas;
	}
	
	public void anyadirArtista(Artista a)
	{
		this.artistas.add(a);
	}
	
	public void eliminarArtista(Artista a)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<artistas.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
		{
			if(artistas.get(pos).equals(a))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		
		if(encontrado)
		{
			artistas.remove(pos);
			System.out.println("Artista: "+a.getIdArtista()+" eliminado");
			
		}
		else System.out.println("Artista: "+a.getIdArtista()+" no encontrado.");
	}
	
	public Artista obtenerArtista(String id)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<artistas.size())
		{
			if(artistas.get(pos).getIdArtista().equals(id))//Busca la posicion del elemento cuya identificador sea id.
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return artistas.get(pos);
	}
	
	public boolean comprobarId(String id)
	{
		for (int i=0;i<artistas.size();i++)
		{
			if(artistas.get(i).getIdArtista().equals(id))//Comprueba que el Id del artista se encuentre en el vector artistas
			{
				return true;//Devuelve true si el artista se encuentra en el vector.
			}
		}
		
		return false;
	}
	
	public String listarIds()
	{
		String cadena="";
		
		for(int i=0;i<artistas.size();i++)
		{
			cadena+=artistas.get(i).getIdArtista()+" ";
		}
		cadena+= "\n";
		
		return cadena;
	}
	
	public String toString()
	{
		String cadena="";
		
		for( int i=0;i<artistas.size();i++) //Muestra el vector
		{
			cadena+= artistas.get(i).toString();
		}
		
		return cadena;
	}
	
	public boolean vacio()
	{
		return artistas.isEmpty();
	}
	
	
	
	

}
