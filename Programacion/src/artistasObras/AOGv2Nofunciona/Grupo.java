package artistasObras.AOGv2Nofunciona;

import java.util.Vector;
import rutinas.Rutinas;

public class Grupo implements java.io.Serializable{
	private String idGrupo;
	private String nombreGrupo;
	private Vector<Artista> artistas;
	private Vector<Obra> obras;
	private Vector<Double> porcentajesArtistas;
	
	
	public Grupo(String id, String nombre)
	{
		this.idGrupo=id;
		this.nombreGrupo=nombre;
		this.artistas=new Vector<Artista>();
		this.obras=new Vector<Obra>();
		this.porcentajesArtistas=new Vector<Double>();
		
	}
	
	public Grupo(String id, String nombre, Vector<Artista> v1)
	{
		this.idGrupo=id;
		this.nombreGrupo=nombre;
		this.artistas=v1;
		this.obras=new Vector<Obra>();
		this.porcentajesArtistas=new Vector<Double>();
		leerPorcentajes();
	}
	
	public Grupo(String id, String nombre, Vector<Artista> v1, Vector<Obra> v2)
	{
		this.idGrupo=id;
		this.nombreGrupo=nombre;
		this.artistas=v1;
		this.obras=v2;
		this.porcentajesArtistas=new Vector<Double>();
		leerPorcentajes();
	}
	
	public Grupo(String id, String nombre, Vector<Artista> v1, Vector<Obra> v2,Vector<Double> v3)
	{
		this.idGrupo=id;
		this.nombreGrupo=nombre;
		this.artistas=v1;
		this.obras=v2;
		this.porcentajesArtistas=v3;
	}
	
	public void setIdGrupo(String id)
	{
		this.idGrupo=id;
	}
	public void setNombreGrupo(String nombre)
	{
		this.nombreGrupo=nombre;
	}
	public void setPorcentajesArtistas(Vector<Double> porc) 
	{
		this.porcentajesArtistas = porc;
	}
	public String getIdGrupo()
	{
		return this.idGrupo;
	}
	public String getNombreGrupo()
	{
		return this.nombreGrupo;
	}
	public Vector<Artista> getArtistas()
	{
		return this.artistas;
	}
	public Vector<Obra> getObras()
	{
		return this.obras;
	}
	public Vector<Double> getPorcentajesArtistas() 
	{
		return this.porcentajesArtistas;
	}
	
	public void anyadirArtista(Artista ar)
	{
		this.artistas.add(ar);
	}
	
	public void eliminarArtista(Artista ar)
	{
		boolean el=this.artistas.remove(ar);
		
		System.out.println("valor del booleano "+el);
		System.out.println(ar.toString());
		
		if(el)
		{
			System.out.println("Artista "+ar.getIdArtista()+ " eliminado correctamente");
		}
		else
		{
			System.out.println("Error al eliminar artista "+ar.getIdArtista());
		}
	}
	
	public void leerPorcentajes()
	{
		double sum=0;
		double val;
		for(int i=0;i<this.artistas.size()-1;i++)//Introduce el porcentaje hasta el penultimo artista del vector
		{
			val=Rutinas.leeDouble("Introduce el porcentaje del artista: "+this.artistas.get(i).getNombre()+" 0-"+(100-sum), 0, 100-sum);
			sum+=val;
		
			this.porcentajesArtistas.add(i, val);
		}
		this.porcentajesArtistas.add(this.artistas.size()-1, 100-sum);//El porcentaje restante se lo queda el ultimo artista.
	}
	
	public void porcentajesDefecto()//Pone a todos los Artistas el mismo porcentaje de beneficios.
	{
		Double aux=(double) (100/this.artistas.size());
		
		for(int i=0;i<this.artistas.size();i++)
		{
			this.porcentajesArtistas.add(i,aux);
		}
		
		System.out.println("Beneficios por defecto.");
		
	}
	
	public void anyadirObra(Obra o)
	{
		this.obras.add(o);
	}
	
	public void eliminarObra(Obra o)
	{
		if(this.obras.remove(o))
		{
			System.out.println("Obra "+o.getIdObra()+ " eliminada con exito");
		}
		else
		{
			System.out.println("Error al eliminar obra "+o.getIdObra());
		}
	}

	public boolean estaArtista(Artista a)
	{
		for( int i=0;i<this.artistas.size();i++)
		{
			if(this.artistas.get(i).equals(a))
			{
				return true;//Si el artista a se encuentra en el grupo, devuelve true
			}
		}
		
		return false;
	}
	public boolean estaObra(Obra o)
	{
		for( int i=0;i<this.obras.size();i++)
		{
			if(this.obras.get(i).equals(o))
			{
				return true;//Si la obra o se encuentra en el grupo, devuelve true
			}
		}
		return false;
	}
	
	
	
	public String toString()
	{
		String cadena="Grupo "+getNombreGrupo()+"\nId: "+getIdGrupo()+"\n\n";
		
		for(int i=0;i<this.artistas.size();i++)
		{
			cadena+=this.artistas.get(i).toString()+"Comision en grupo: "+this.porcentajesArtistas.get(i)+"\n\n";
		}
		
		for(int i=0;i<this.obras.size();i++)
		{
			cadena+=this.obras.get(i).toString()+"\n";
		}
		
		
		return cadena;
	}
	
	public String listarIdsArtistas()
	{
		String cadena="";
		for(int i=0;i<this.artistas.size();i++)//Devuelve una lista de con los Identificadores de los artistas
		{
			cadena+=this.artistas.get(i).toString()+"\n";
		}
		cadena+="\n";
		return cadena;
	}
	public String listarIdsObras()
	{
		String cadena="";
		for(int i=0;i<this.obras.size();i++)
		{
			cadena+=this.obras.get(i).toString()+"\n";
		}
		cadena+="\n";
		return cadena;
	}
	
	public boolean tieneArtistas()
	{
		return artistas.isEmpty();
	}
	
	public boolean tieneObras()
	{
		return obras.isEmpty();
	}
	
	
	
	

}
