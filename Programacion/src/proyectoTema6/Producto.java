package proyectoTema6;

import rutinas.Rutinas;

public class Producto {
	private String descripcion;
	private String codigo;
	private double precioCoste;
	private double precioVenta;
	
	
	public Producto(){
	}
	
	public Producto(String desc,String cod, double precC, double precV)
	{
		this.setDescripcion(desc);
		this.setCodigo(cod);
		this.setPrecioCoste(precC);
		this.setPrecioVenta(precV);
	}
	
	public void setDescripcion(String desc)
	{
		if(desc.length()>40)
		{
			this.descripcion=desc.substring(0,40);
		}
		else this.descripcion=desc;
	}
	
	public void setCodigo(String cod)
	{
		if(cod.length()>10)
		{
			this.codigo=cod.substring(0,10);
		}
		else this.codigo=cod;
	}
	
	public void setPrecioCoste(double precC)
	{		
		double p=precC;
		
		while(p < 1 || p > 1000)
		{
			
			if(p < 1)
			{
				System.out.println("Precio de Coste demasiado bajo.");
				p=Rutinas.leeDouble("Introduzca un numero");
			}
			else if(p >1000)
			{
				System.out.println("Precio de Coste demasiado alto.");
				p=Rutinas.leeDouble("Introduzca un numero");
			}
		}
		this.precioCoste=redondear(p);
	}
	
	public void setPrecioVenta(double precV)
	{	
		double pv=precV;
		
		
		while(pv <= this.precioCoste || pv > 2000)
		{
			
			if(pv<=this.precioCoste)
			{
				System.out.println("Precio de Venta inferior al precio de Coste.");
				pv=Rutinas.leeDouble("Introduzca un numero");
			}
			else if(pv>2000)
			{
				System.out.println("Precio de Venta demasiado alto.");
				pv=Rutinas.leeDouble("Introduzca un numero");
			}
		}
		this.precioVenta=redondear(pv);
		
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	public String getCodigo()
	{
		return this.codigo;
	}
	public double getPrecioCoste()
	{
		return this.precioCoste;
	}
	public double getPrecioVenta()
	{
		return this.precioVenta;
	}
	
	public String toString()
	{
		return "Descripcion: "+this.descripcion +"\n"
		+ "Codigo: "+this.codigo+"\n"
		+ "Precio de Coste: "+this.precioCoste+"\n"
		+ "Precio de Venta: "+this.precioVenta+"\n";
	}
	private double redondear(double n)
	{
		return Math.rint(n*100)/100;
	}
	
	
	

}
