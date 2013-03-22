package artistasObras.AOGv2Nofunciona;

import java.util.Vector;

public class VectorObras implements java.io.Serializable{
	Vector<Obra> obras;
	
	public VectorObras()
	{
		setVectorObras(new Vector<Obra>());
	}
	
	public VectorObras(Vector<Obra> aux)
	{
		setVectorObras(aux);
	}
	
	public void setVectorObras(Vector<Obra> aux)
	{
		this.obras=aux;
	}
	
	public Vector<Obra> getVectorObras()
	{
		return this.obras;
	}
	
	public void anyadirObra(Obra o)
	{
		this.obras.add(o);
	}
	
	public void eliminarObra(Obra o)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<obras.size())//Busca en el vector el identificador de la obra. Si no lo encuentra llegara hasta el final del vector
		{
			if(obras.get(pos).equals(o))
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		
		if(encontrado)
		{
			System.out.println("Obra: "+o.getIdObra()+" eliminada");
			obras.remove(pos);
		}
		else System.out.println("Obra: "+o.getIdObra()+" no encontrada.");
	}
	
	public Obra obtenerObra(String id)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<obras.size())
		{
			if(obras.get(pos).getIdObra().equals(id))//Busca la posicion del elemento cuya identificador sea id.
			{
				encontrado=true;
				pos--;
			}
			pos++;
		}
		return obras.get(pos);
	}
	
	public boolean comprobarIdO(String Id)
	{
		for(int i=0;i<obras.size();i++)
		{
			if(obras.get(i).getIdObra().equals(Id))//Comprueba que el Id de la obra este en el vector obras.
			{
				return true;//Devuelve true si la obra se encuentra en el vector.
			}
		}
		
		return false;
	}
	
	public String listarIds()
	{
		String cadena="";
		
		for(int i=0;i<obras.size();i++)
		{
			cadena+=obras.get(i).getIdObra()+" ";
		}
		cadena+="\n";
		return cadena;
	}
	
	public String toString()
	{
		String cadena="";
		
		for( int i=0;i<obras.size();i++) //Muestra el vector
		{
			cadena+= obras.get(i).toString();
		}
		
		return cadena;
	}
	
	public boolean vacio()
	{
		return obras.isEmpty();
	}

}
