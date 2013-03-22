package artistasObras.AOGv2Nofunciona;

public class Artista implements java.io.Serializable{
	private String idArtista;
	private String nombre;
	private double derechos;
	
	public Artista (String id, String nombre)
	{
		this.idArtista=id;
		this.nombre=nombre;
		this.derechos=0;
	}
	public Artista (String id, String nombre, double derechos)
	{
		this.idArtista=id;
		this.nombre=nombre;
		this.derechos=derechos;
	}
	
	public void setIdArtista(String id)
	{
		this.idArtista=id;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public void setDerechos(double derechos)
	{
		this.derechos=derechos;
	}
	public String getIdArtista()
	{
		return this.idArtista;
	}
	public String getNombre()
	{
		return this.nombre;
	}
	public double getDerechos()
	{
		return this.derechos;
	}
	
	
	public void cobrarDerechos(double derechos)
	{
		this.derechos+=derechos;
	}
	
	public String toString()
	{
		return "Artista "+getNombre()+"\nId: "+getIdArtista()+"\nValor de los derechos: "+getDerechos()+"\n";
	}
	
	
	

}
