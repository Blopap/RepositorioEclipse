package Tema5;

public class Ordenador {
	
	private String marca;
	private double precio;
	
	public Ordenador()
	{
		
	}
	public Ordenador(String m, double p)
	{
		this.marca=m;
		this.precio=p;
	}
	
	public String getMarca()
	{
		return this.marca;
	}
	public double getPrecio()
	{
		return this.precio;
	}
	
	public void setMarca(String m)
	{
		this.marca=m;
	}
	
	public void setPrecio(double p)
	{
		this.precio=p;
	}
	
	public String toString()
	{
		return "Ordenador: "+this.getMarca()+"  Precio: "+this.getPrecio();
	}

}
