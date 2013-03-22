package artistasObras;


public class Obra implements java.io.Serializable{
	
	private String idObra;
	private String titulo;
	private double comision;
	
	public Obra (String id, String titulo)
	{
		this.idObra=id;
		this.titulo=titulo;
		this.comision=0;
	}
	
	public Obra (String id, String titulo, double comision)
	{
		this.idObra=id;
		this.titulo=titulo;
		this.comision=comision;
	}
	
	public Obra (Obra o)
	{
		this.idObra=o.getIdObra();
		this.titulo=o.getTitulo();
		this.comision=o.getComision();
	}
	
	public void setIdObra(String id)
	{
		this.idObra=id;
	}
	public void setTitulo(String titulo)
	{
		this.titulo=titulo;
	}
	public void setComision(double comision)
	{
		this.comision=comision;
	}	
	public String getIdObra()
	{
		return this.idObra;
	}
	public String getTitulo()
	{
		return this.titulo;
	}
	public double getComision()
	{
		return this.comision;
	}
	
	public String toString()
	{
		return "Obra "+getTitulo()+"\nId: "+getIdObra()+"\nComision: "+getComision()+"\n";
	}
	
	

}
